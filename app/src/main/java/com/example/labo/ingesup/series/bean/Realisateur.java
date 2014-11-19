package com.example.labo.ingesup.series.bean;

/**
 * Created by swater on 05/11/2014.
 */
public class Realisateur {



    private int id;
    private String Nom;

    public Realisateur() {
    }

    public Realisateur(String nom) {
        Nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}
