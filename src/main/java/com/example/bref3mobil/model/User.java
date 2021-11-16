package com.example.bref3mobil.model;
//cette class definie les valeur qui return  ce forme Json
public class User {
    private String userId;
    private String nom ;
     private String  prenom;
    private String email;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public User(String userId, String nom, String prenom, String email) {
        this.userId = userId;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
}
