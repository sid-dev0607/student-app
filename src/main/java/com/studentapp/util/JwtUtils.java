package com.studentapp.util;

import com.studentapp.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtils {
    @Autowired
    UserRepository userRepsitory;

    private String secret = "javaSys";

//    public String getUserNameFromJwtToken(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
//    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public java.util.Set<Map.Entry<String, Object>> extractPassword(String token){
        return extractClaim(token, Claims::entrySet);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username, String password) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put( "password", password);
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

//    public Boolean validateToken(String token, SignIn signIn) {
//        final String username = extractUsername(token);
//        return (username.equals(userRepsitory.findByEmailId(signIn.getEmailId())));
////        return (username.equals(userDetails.getEmailId() && !isTokenExpired(token));
//    }
     public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
//@Autowired
//StudentRepo studentRepo;
//
//    private static String secret = "javaSys";
//
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public java.util.Set<Map.Entry<String, Object>> extractPassword(String token){
//        return extractClaim(token, Claims::entrySet);
//    }
//
//    public Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//    }
////private Claims getAllClaimsFromToken(String token) {
////    return Jwts.parser().setSigningKey(secret.getBytes(Charset.forName("UTF-8")))
////            .parseClaimsJws(token.replace("{", "").replace("}","")).getBody();
////}
//
//    private Boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    public String generateToken(String username, String password) {
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("username", username);
//        claims.put( "password", password);
//        return createToken(claims, username);
//    }
//
//    private String createToken(Map<String, Object> claims, String subject) {
//
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                .signWith(SignatureAlgorithm.HS256, secret.getBytes(Charset.forName("UTF-8"))).compact();
//    }
//    public Boolean validateToken(String token, UserDetails userDetails) throws JwtException {
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
}