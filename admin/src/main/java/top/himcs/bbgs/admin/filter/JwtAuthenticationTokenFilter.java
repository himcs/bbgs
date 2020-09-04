package top.himcs.bbgs.admin.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import top.himcs.bbgs.admin.util.JwtTokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 检测Http 请求中JWT字段 并在安全容器中填充
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 已设置安全容器 直接返回
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            filterChain.doFilter(request, response);
            return;
        }
        String authToken = getToken(request);
        if (StringUtils.isEmpty(authToken)) {
            filterChain.doFilter(request, response);
            return;
        }
        String username = jwtTokenUtil.getSubjectFromToken(authToken);
        if (StringUtils.isEmpty(username)) {
            filterChain.doFilter(request, response);
            return;
        }

        LOGGER.info("checking username:{}", username);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.validateToken(authToken, userDetails)) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            LOGGER.info("authenticated username:{}", username);
            //设置安全容器
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    /**
     * 获取Token
     *
     * @param request
     * @return
     */
    private String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader == null || !authHeader.startsWith(this.tokenHead)) {
            return null;
        }
        String authToken = authHeader.substring(this.tokenHead.length());
        return authToken;
    }
}
