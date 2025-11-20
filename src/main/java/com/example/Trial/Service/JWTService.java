package com.example.Trial.Service;

import com.example.Trial.Entity.UserEntity;
import org.springframework.stereotype.Service;

public interface JWTService {
    public String generateToken(UserEntity userEntity);
}
