package com.example.Trial.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserServiceInfo")
public class UserEntity {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String Role;

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
