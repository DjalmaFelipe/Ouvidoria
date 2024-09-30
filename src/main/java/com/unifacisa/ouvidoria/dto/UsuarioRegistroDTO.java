package com.unifacisa.ouvidoria.dto;

public class UsuarioRegistroDTO {
    private String username;
    private String password;
    private String role;  // Pode ser "USER", "FUNCIONARIO", etc.

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}