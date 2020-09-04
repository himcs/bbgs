package top.himcs.bbgs.admin.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

    private final SecretKey key;

    public JwtTokenUtil(String secretString) {
        this.key = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * @param claims 主体为自定义对象
     * @return
     */
    public String generateToken(Map<String, ?> claims) {
        return Jwts.builder().setClaims(claims).signWith(key).compact();
    }

    /**
     * 从Token 中加载 主体对象
     *
     * @param token
     * @return
     */
    public Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public String getSubjectFromToken(String token)
    {
        Claims claims = getClaimsFromToken(token);
        return claims.getSubject();
    }

    /**
     * 验证Token是否有效
     * @param token
     * @param object
     * @return
     */
    public boolean validateToken(String token,Object object)
    {
        String account = getSubjectFromToken(token);
        return false;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String secretString = "mall-admin-secretmall-admin-secret";
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil(secretString);
        Map<String, String> map = new HashMap<>();
        map.put("sub", "Joe");
        String jws = jwtTokenUtil.generateToken(map);
        System.out.println(jws);
        System.out.println(jwtTokenUtil.getClaimsFromToken(jws));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
//        解密
//      eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.ZQYkivgcXuVpPbRgxNoxJUGsmeSk6MY1MKjWey6gOds

    }
}
