package com.sfood.util;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.sfood.dto.CustomerDTO;
import com.sfood.dto.request.IntrospectRequest;
import com.sfood.dto.response.IntrospectResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Date;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtUtils {
    private String SIGNER_KEY = "Tl2MUnV5je2GPkBIT3RksQljBflXe9oWORcq2+U+kDLdzrTw/PdRDRwdCn3mpkYf";
    public Authentication createAuthentication(CustomerDTO customerDTO) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("CUSTOMER");

        return new UsernamePasswordAuthenticationToken(
                customerDTO,
                null,
                Collections.singletonList(authority)
        );
    }
    public String generateToken(String username, Long cusId) throws JOSEException {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("sfood.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("customerId", cusId)
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(header, payload);

        jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
        return jwsObject.serialize();
    }

    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        var token = request.getToken();
        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);
        Date expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();
        var verified = signedJWT.verify(verifier);
        return IntrospectResponse.builder()
                .valid(verified && expirationTime.after(new Date()))
                .build();
    }


    public static Long getIdUser(HttpServletRequest request) {
        try {
            String token = (String) request.getSession().getAttribute("token");
            if (token != null) {
                JwtUtils jwtUtils = new JwtUtils();
                return jwtUtils.getIdUserFromToken(token);
            }
        } catch (Exception e) {
            System.err.println("Failed to extract user ID: " + e.getMessage());
        }
        return null;
    }
    public Long getIdUserFromToken(String token) throws ParseException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        JWTClaimsSet claims = signedJWT.getJWTClaimsSet();
        return claims.getLongClaim("customerId");
    }
}
