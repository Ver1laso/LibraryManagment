package dev.jlprisan.LibraryManagment.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String jwtSecretKey;
    @Value("${jwt.expirationMs}")
    private long jwtExpirationMs;
    private SecretKey key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }
    //Generate JWT Token
    public String generateToken(String email) {
        return io.jsonwebtoken.Jwts.builder()
                .setSubject(email)
                .setExpiration(new java.util.Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(key)
                .compact();
    }

    //Get email from JWT Token
    public String getEmailFromToken(String token) {
        return io.jsonwebtoken.Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    //Validate JWT Token
    public boolean validateToken(String token) {
        try {
            io.jsonwebtoken.Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException e) {
            System.out.println("Invalid JWT signature: " + e.getMessage());
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            System.out.println("JWT token is expired: " + e.getMessage());
        } catch (io.jsonwebtoken.MalformedJwtException e) {
            System.out.println("Invalid JWT token: " + e.getMessage());
        } catch (io.jsonwebtoken.UnsupportedJwtException e) {
            System.out.println("JWT token is unsupported: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("JWT claims string is empty: " + e.getMessage());
        }
        return false;
    }
}
