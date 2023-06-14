package com.example.serviceshotel.utils;

public class Responsable {
    private String Pseudo;
    private String password ;
    public Responsable(){};
    public Responsable(String pseudo, String password) {
        Pseudo = pseudo;
        this.password = password;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String pseudo) {
        Pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
