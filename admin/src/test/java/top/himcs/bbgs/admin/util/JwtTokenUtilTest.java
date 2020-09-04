package top.himcs.bbgs.admin.util;

import io.jsonwebtoken.Claims;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class JwtTokenUtilTest {

    String secretString = "mall-admin-secretmall-admin-secret";
    JwtTokenUtil jwtTokenUtil = new JwtTokenUtil(secretString);

    @Test
    public void generateToken() {
        Map<String, String> map = new HashMap<>();
        map.put("sub", "Joe");
        String jws = jwtTokenUtil.generateToken(map);
        String want = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.ZQYkivgcXuVpPbRgxNoxJUGsmeSk6MY1MKjWey6gOds";
        assertEquals(want, jws);
    }

    @Test
    public void getClaimsFromToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.ZQYkivgcXuVpPbRgxNoxJUGsmeSk6MY1MKjWey6gOds";
        Claims claims = jwtTokenUtil.getClaimsFromToken(token);
        assertEquals("Joe", claims.getSubject());
    }

    @Test
    public void getSubjectFromToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.ZQYkivgcXuVpPbRgxNoxJUGsmeSk6MY1MKjWey6gOds";
        assertEquals("Joe", jwtTokenUtil.getSubjectFromToken(token));
    }
}