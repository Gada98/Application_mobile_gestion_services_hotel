package com.example.serviceshotel;

public class User {
    private int id;
    private String nom, prénom, nationalité, N_CIN, adresse, numéro_téléphone, email, Pseudo, Mot_de_passe;

    public User(int id, String nom, String prénom, String nationalité, String N_CIN, String adresse, String numéro_téléphone, String email, String Pseudo, String Mot_de_passe) {
        this.id = id;
        this.nom = nom;
        this.prénom = prénom;
        this.nationalité = nationalité;
        this.N_CIN = N_CIN;
        this.adresse = adresse;
        this.numéro_téléphone = numéro_téléphone;
        this.email = email;
        this.Pseudo = Pseudo;
        this.Mot_de_passe = Mot_de_passe;
    }

    public int getId() {

        return id;
    }

    public String getNom() {

        return nom;
    }

    public String getPrénom() {

        return prénom;
    }

    public String getNationalité() {

        return nationalité;
    }

    public String getN_CIN() {
        return N_CIN;
    }
    public String getAdresse()
    {
        return adresse;
    }
    public String getNuméro_téléphone() {

        return numéro_téléphone;
    }
    public String getEmail() {

        return email;
    }

    public String getPseudo() {

        return Pseudo;
    }
    public String getMot_de_passe() {

        return Mot_de_passe;
    }
}
