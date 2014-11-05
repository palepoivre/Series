package com.example.labo.ingesup.series.bean;

/**
 * Created by clément on 15/10/2014.
 */
public class Genre {

    private int mId;
    private String mNom;

    public Genre(String nom){
      mNom = nom;
     }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getNom() {
        return mNom;
    }

    public void setNom(String mNom) {
        this.mNom = mNom;
    }
}
