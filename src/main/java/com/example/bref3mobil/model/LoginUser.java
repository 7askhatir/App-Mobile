package com.example.bref3mobil.model;

//cette class definie les valeur qui envoyer ce forme Json UserRequest in spring boot
public class LoginUser {
    private String email;
    private String password;


    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
