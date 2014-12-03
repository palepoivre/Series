package com.example.labo.ingesup.series.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.labo.ingesup.series.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by swater on 03/12/2014.
 */
public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String YOUTUBE_URL = "YOUTUBE_URL";

    private String mVideoUrl;

    private YouTubePlayerView mYouTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        mVideoUrl = getIntent().getStringExtra(YOUTUBE_URL);

        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.ypv);

        mYouTubePlayerView.initialize(getString(R.string.youtube_api_key), this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        /** Start buffering **/
        if (!wasRestored) {
            youTubePlayer.loadVideo(mVideoUrl);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, getString(R.string.youtube_error), Toast.LENGTH_LONG).show();
    }
}
