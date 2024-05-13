package com.portal.healthcare.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.GrantedAuthority;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtUtil {
    public static Map<String,String> getTokens(User user){

    Algorithm algorithm= Algorithm.HMAC256("secret".getBytes());

    String access_token= getAccessToken(user,algorithm);
    String refresh_token= getRefreshToken(user,algorithm);
    Map<String,String> map= new HashMap<>();
    map.put("access_token",access_token);
    map.put("refresh_token",refresh_token);
    return map;
}
    public static String getAccessToken(User user, Algorithm algorithm){
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*1000))
                .withIssuer("")
                .withClaim("roles",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
    }

    public static String getRefreshToken(User user, Algorithm algorithm){
        return  JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*1000))
                .withIssuer("")
                .sign(algorithm);
    }
    public static String extractDoctorIdFromToken(String token) {
        String tokenWithoutBearer = removeBearerPrefix(token);
            DecodedJWT jwt = JWT.decode(tokenWithoutBearer);
            // Assuming "doctorId" is the claim name containing the doctor's ID
            String userName = jwt.getSubject();
            return userName;

    }
    private static String removeBearerPrefix(String tokenWithBearer) {
        if (tokenWithBearer != null && tokenWithBearer.startsWith("Bearer ")) {
            return tokenWithBearer.substring(7); // Remove the first 7 characters ("Bearer ")
        }
        return tokenWithBearer; // Return the original token if "Bearer " prefix is not found
    }

}
