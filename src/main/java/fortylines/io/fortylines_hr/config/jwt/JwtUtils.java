package fortylines.io.fortylines_hr.config.jwt;

import fortylines.io.fortylines_hr.config.jwt.JwtConfig;
import fortylines.io.fortylines_hr.entity.Auth;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class JwtUtils {

    private final JwtConfig jwtConfig;

    public String generateToken(Authentication authentication) {
        Auth authInfo = (Auth) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(authInfo.getEmail())
                .signWith(SignatureAlgorithm.HS256, jwtConfig.getSecretKey())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + (jwtConfig.getExpirationDateAfterDays() * 8600000)))
                .compact();
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtConfig.getSecretKey())
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean verifyToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtConfig.getSecretKey())
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
