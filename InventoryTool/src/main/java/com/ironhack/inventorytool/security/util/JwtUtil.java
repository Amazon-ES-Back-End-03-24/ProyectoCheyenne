package com.ironhack.inventorytool.security.util;



import com.fasterxml.jackson.core.ErrorReportConfiguration;
import org.jline.reader.LineReaderBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

/*@Service
public class JwtUtil<Claims> {

    private String secret = "your_jwt_secret_key";

    public String extractUsername(String token) {
        Object Claims = null;
        return extractClaim(token, Claims::getSubjec t);
    }

    public Date extractExpiration(String token) {
        Object Claims = null;
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        LineReaderBuilder Jwts;
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        Object SignatureAlgorithm = null;
        ErrorReportConfiguration Jwts = null;
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}*/
