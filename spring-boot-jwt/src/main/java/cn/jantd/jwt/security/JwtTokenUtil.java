package cn.jantd.jwt.security;

import io.jsonwebtoken.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.*;

public class JwtTokenUtil {

    public static String getHeader() {
        return "Authorization";
    }

    public static String getTokenPrefix() {
        return "token ";
    }

    private static String secret = "123456";

    public static String createToken(String payload) {
        Key signingKey = new SecretKeySpec(DatatypeConverter.parseBase64Binary(secret), SignatureAlgorithm.HS256.getJcaName());
        JwtBuilder builder = Jwts.builder()
//                .setHeaderParam("typ", "JWT")
//                .setHeaderParam("alg", SignatureAlgorithm.HS256.getValue())
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .setPayload(payload);
        return builder.compact();
    }

    public static Jwt<Header, Claims> parse(String token) {
        Key signingKey = new SecretKeySpec(DatatypeConverter.parseBase64Binary(secret), SignatureAlgorithm.HS256.getJcaName());
        return Jwts.parser().setSigningKey(signingKey).parse(token);
    }

    public static Header getHeader(String token) {
        return parse(token).getHeader();
    }

    public static Claims getBody(String token) {
        return parse(token).getBody();
    }

    public static SecurityProperties.User getAuthentication(String token) {
        if(!StringUtils.isEmpty(token)) {
            Claims body = getBody(token);
            if (null != body) {
                String username = (String) body.get("username");
                List roles = body.get("roles", List.class);
                SecurityProperties.User user = new SecurityProperties.User();
                user.setName(username);
                user.setRoles(roles);
                return user;
            }
        }
        return null;
    }

    public static String getUsername(String token) {
        return (String) getBody(token).get("name");
    }
}
