package com.example.labo.ingesup.series.bean;

/**
 * Created by clément on 15/10/2014.
 */
public class Serie {

    private String mTitre;
    private String mUrl;
    private String mGenre;
    private String mRealisateur;
    private String mSynopsis;
    private boolean mVue;

    /**
     * Constructeur
     * @param s
     */
    public Serie(String s) {
    }

    /** GETTERS & SETTERS **/

    public String getTitre() {
        return mTitre;
    }

    public void setTitre(String mTitre) {
        this.mTitre = mTitre;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String mGenre) {
        this.mGenre = mGenre;
    }

    public String getRealisateur() {
        return mRealisateur;
    }

    public void setRealisateur(String mRealisateur) {
        this.mRealisateur = mRealisateur;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public void setSynopsis(String mSynopsis) {
        this.mSynopsis = mSynopsis;
    }

    public boolean isVue() {
        return mVue;
    }

    public void setmVue(boolean mVue) {
        this.mVue = mVue;
    }
}
