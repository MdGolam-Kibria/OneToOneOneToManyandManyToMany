package com.example.classOneProject.filter;

import com.example.classOneProject.dto.UserPrinciple;
import com.example.classOneProject.utill.DataUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;

import java.util.Date;
import java.util.UUID;

@Configuration
public class JwtTokenProvider {//for generate token..
    private String secretKey = "SpringBootTutorial";
    private Long expireHour = Long.valueOf("5");//for token access expire time

    public String generateToken(Authentication authentication) {
        //ekhon authentication theke UserPrincipal take ber kore nibo
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        Date now = new Date();
        return Jwts.builder().setId(UUID.randomUUID().toString())
                .claim("username", userPrinciple.getUsername())
                //.claim("role",userPrinciple.getAuthorities().stream().map(grantedAuthority -> ))
                .setSubject(String.valueOf(userPrinciple.getId()))
                .setIssuedAt(now)//mane ei token ta kokhon make kora hoise
                .setExpiration(DataUtils.getExpirationTime(expireHour))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return Long.valueOf(claims.getSubject());
    }

    public Boolean isValidateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);//ekhane toklen ta parse korte parle token ta validate
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
