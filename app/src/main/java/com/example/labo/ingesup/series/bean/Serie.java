package com.example.labo.ingesup.series.bean;

/**
 * Created by clément on 15/10/2014.
 */
public class Serie {

    private int mId;
    private String mTitre;
    private String mUrl;
    private String mTrailerUrl;
    private Genre mGenre;
    private String mRealisateur;
    private String mSynopsis;
    private boolean mVue;

    /**
     * Constructeur
     * @param s
     */
    public Serie() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
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

    public String getTrailerUrl() {
        return mTrailerUrl;
    }

    public void setTrailerUrl(String mTrailerUrl) {
        this.mTrailerUrl = mTrailerUrl;
    }

    public Genre getGenre() {
        return mGenre;
    }

    public void setGenre(Genre mGenre) {
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

    public void setVue(boolean mVue) {
        this.mVue = mVue;
    }
}
