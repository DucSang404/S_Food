package com.sfood.util;

import com.sfood.dto.CustomerDTO;
import com.sfood.dto.MyUser;
import com.sfood.repository.AccountRepository;
import com.sfood.repository.CustomerRepository;
import com.sfood.service.impl.CustomerService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class JwtUtils {
    private static final String SECRET_KEY = "your-very-long-secret-key-at-least-32-bytesyour-very-long-secret-key-at-least-32-bytesyour-very-long-secret-key-at-least-32-bytesyour-very-long-secret-key-at-least-32-bytesyour-very-long-secret-key-at-least-32-bytesyour-very-long-secret-key-at-least-32-bytesyour-very-long-secret-key-at-least-32-bytesyour-very-long-secret-key-at-least-32-bytesyour-very-long-secret-key-at-least-32-bytesyour-very-long-secret-key-at-least-32-bytesyour-very-long-secret-key-at-least-32-bytes";
    private final long EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    private final Key key;

    public JwtUtils() {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        this.key = Keys.hmacShaKeyFor(keyBytes); // Đảm bảo khóa đủ dài
    }

    private static Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public Authentication createAuthentication(CustomerDTO customerDTO) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("CUSTOMER");

        return new UsernamePasswordAuthenticationToken(
                customerDTO,
                null,
                Collections.singletonList(authority)
        );
    }

    public Long getCustomerId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            MyUser myUser = (MyUser) authentication.getPrincipal();
            return myUser.getId();
        }
        return null;
    }

    public String generateToken(String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
    public Claims parseToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("Token đã hết hạn", e);
        } catch (JwtException e) {
            throw new RuntimeException("Token không hợp lệ", e);
        }
    }

    public boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
