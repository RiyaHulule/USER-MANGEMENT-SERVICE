package com.example.Trial.Controller;

import com.example.Trial.Entity.UserEntity;
import com.example.Trial.ServiceImple.JWTServiceImple;
import com.example.Trial.ServiceImple.UserServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserServiceImple userServiceImple;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTServiceImple jwtServiceImple;

    @GetMapping("/get")
    public String getUser(@RequestParam String username) {
        return "Hello " + username;
    }
    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity userEntity) {
        return userServiceImple.register(userEntity);
    }

    @PostMapping("/verify")
    public String verify(@RequestBody UserEntity userEntity) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword()));
        if(authentication.isAuthenticated()){
            return "Success to login!";
        }else {
            return "Incorrect username or password";
        }
    }

    @PostMapping("/login")
    public String token(@RequestBody UserEntity userEntity) {
        return jwtServiceImple.generateToken(userEntity);
    }
}
