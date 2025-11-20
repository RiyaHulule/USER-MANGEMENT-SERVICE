package com.example.Trial.ServiceImple;

import com.example.Trial.Entity.UserEntity;
import com.example.Trial.Service.JWTService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTServiceImple implements JWTService {
    private String SecretKey = "mySuperLongSecretKeyForJwtAuth123456789";
    @Override
    public String generateToken(UserEntity userEntity) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder().claims().add(claims).subject(userEntity.getUsername()).issuedAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis()+ 1000*60*30)).and().compact();
    }
}
