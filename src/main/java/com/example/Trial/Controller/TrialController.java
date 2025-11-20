package com.example.Trial.Controller;

import com.example.Trial.Entity.TrialEntity;
import com.example.Trial.Service.JWTService;
import com.example.Trial.Service.TrialService;
import com.example.Trial.ServiceImple.TrialServiceImple;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TrialController {
    @Autowired
    TrialServiceImple trialServiceImple;

    @PostMapping("/DataPost")
    public TrialEntity trialPost(@RequestBody TrialEntity trialEntity) {
        return trialServiceImple.dataPosting(trialEntity);
    }
    @GetMapping("/DataGetAll")
    public List<TrialEntity> dataGetting() {
        return trialServiceImple.dataGetting();
    }
    @GetMapping("/DataOneGet/{number}")
    public Optional<TrialEntity> OneDataGet(@PathVariable Long number) {
        return trialServiceImple.OneDataGet(number);
    }
    @PutMapping("/updateByName/{number}")
    public TrialEntity updateName(@PathVariable Long number, @RequestParam String name) {
        return trialServiceImple.updataByName(number, name);
    }
    @DeleteMapping("/DeleteById/{number}")
    public void deleteById(@PathVariable Long number) {
        trialServiceImple.deleteByName(number);
    }
    @DeleteMapping("/DeleteByName/{name}")
    public void deleteByName1(@PathVariable String name) {
        trialServiceImple.deleteByname(name);
    }
    @GetMapping("/")
    public String Greet(HttpServletRequest request) {
        return "Hello Riya!"+ request.getSession().getId();
    }
    @GetMapping("/csrfToken")
    public CsrfToken csrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}