package top.himcs.bbgs.admin.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import top.himcs.bbgs.admin.bo.AdminUserDetails;
import top.himcs.bbgs.admin.compoent.RestAuthenticationEntryPoint;
import top.himcs.bbgs.admin.compoent.RestfulAccessDeniedHandler;
import top.himcs.bbgs.admin.filter.JwtAuthenticationTokenFilter;
import top.himcs.bbgs.admin.service.SystemAdminService;
import top.himcs.bbgs.mbg.model.SystemAdmin;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Autowired
    SystemAdminService adminService;

    /**
     * 用于配置需要拦截的url路径、jwt过滤器及出异常后的处理器；
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().sessionManagement()// 基于token，所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                ).permitAll()
                .antMatchers("/admin/login", "/admin/register")// 对登录注册要允许匿名访问
                .permitAll()
                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                .authenticated();
        // 禁用缓存
        http.headers().cacheControl();
        // 添加JWT filter
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //  添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                //当用户没有访问权限时的处理器，用于返回JSON格式的处理结果；
                .accessDeniedHandler(restfulAccessDeniedHandler)
                //当未登录或token失效时，返回JSON格式的结果；
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    /**
     * UserDetailsService:SpringSecurity定义的核心接口，用于根据用户名获取用户信息，需要自行实现；
     *
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            SystemAdmin systemAdmin = adminService.getAdminByAccount(username);
            if (systemAdmin == null) {
                throw new UsernameNotFoundException("用户名或密码错误");
            }
            return new AdminUserDetails(systemAdmin);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }
}
