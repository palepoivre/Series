package com.example.labo.ingesup.series.bean;

import java.util.List;

/**
 * Created by clément on 15/10/2014.
 */
public class Serie {

    private int mId;
    private String mTitre;
    private String mUrl;
    private String mTrailerUrl;
    private Genre mGenre;
    private List<Realisateur> mRealisateurs;
    private String mSynopsis;
    private boolean mVue;

    /**
     * Constructeur
     **/
    public Serie() {
    }

    public Serie(String mTitre, String mUrl, String mTrailerUrl, List<Realisateur> mRealisateurs, String mSynopsis) {
        this.mTitre = mTitre;
        this.mUrl = mUrl;
        this.mTrailerUrl = mTrailerUrl;
        this.mRealisateurs = mRealisateurs;
        this.mSynopsis = mSynopsis;
    }

    /** GETTERS & SETTERS **/

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

    public List<Realisateur> getRealisateurs() {
        return mRealisateurs;
    }

    public void setRealisateurs(List<Realisateur> mRealisateurs) {
        this.mRealisateurs = mRealisateurs;
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
