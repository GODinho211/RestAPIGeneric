package com.example.test.model.Users;

public enum Role {
    USUARIO("usuario"),
    CLIENTE("cliente"),
    ADMIN("admin");

    private String role;

    Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}
