package br.com.pedroacordi.clinica.security;

import br.com.pedroacordi.clinica.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.security.Key;
import java.util.Collections;
import java.util.Date;

public class TokenUtil {

    public static final long SECONDS   = 1000;
    public static final long MINUTES    = 60 * SECONDS;
    public static final long HOURS      = 60 * MINUTES;
    public static final long DAYS       = 24 * HOURS;
    public static final long EXPIRATION = 2*DAYS;

    public static final String ISSUER = "*CompNam*";
    public static final String SECRET_KEY = "abcdefghijklmnopqrstuvwxyz0123456789";
    public static final String PREFIX = "Bearer ";


    public static Token encode(User user){
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        String jws = Jwts.builder()
                .setSubject(user.getLogin())
                .setIssuer(ISSUER)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        return new Token(PREFIX + jws);
    }

    public static Authentication decode(HttpServletRequest request) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith(PREFIX)) {
            return null;
        }

        token = token.replace(PREFIX, "");
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);

        String subject = claims.getBody().getSubject();
        String issuer = claims.getBody().getIssuer();
        Date exp = claims.getBody().getExpiration();

        return isValidToken(subject, issuer, exp)
                ? new UsernamePasswordAuthenticationToken(subject, null, Collections.emptyList())
                : null;
    }

    public static boolean isValidToken(String subject, String issuer, Date exp){
        return subject != null && !subject.isEmpty() && issuer.equals(ISSUER) && exp.after(new Date(System.currentTimeMillis()));
    }


}
