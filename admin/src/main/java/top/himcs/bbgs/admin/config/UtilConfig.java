package top.himcs.bbgs.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.himcs.bbgs.admin.util.JwtTokenUtil;

@Configuration
public class UtilConfig {
    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil(secret);
    }
}
