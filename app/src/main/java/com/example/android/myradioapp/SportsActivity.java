package com.example.android.myradioapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;

public class SportsActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    private MediaPlayer player;
    private String espnRadioURL = "http://edge.espn.cdn.abacast.net/espn-networkmp3-48?";
    private String talkSportURL = "http://radio.talksport.com/stream?awparams=platform:ts-web&amsparams=playerid:ts-web";
    private String wfanSportsURL = "http://15063.live.streamtheworld.com/WFANAM_SC";
    private ImageView talkSportPlayImg;
    private ImageView espnRadioPlayImg;
    private ImageView wfanRadioPlayImg;
    private boolean switchOn = true;
    private ProgressBar myProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);

        talkSportPlayImg = (ImageView) findViewById(R.id.talk_sport_status);
        myProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        espnRadioPlayImg = (ImageView) findViewById(R.id.espn_status);
        wfanRadioPlayImg = (ImageView) findViewById(R.id.wfan_status);

        myProgressBar.setVisibility(View.INVISIBLE);

        talkSportPlayImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchOn) {
                    try {
                        myProgressBar.setVisibility(View.VISIBLE);
                        myProgressBar.setIndeterminate(true);
                        switchOn = false;
                        player = new MediaPlayer();
                        player.setOnPreparedListener(SportsActivity.this);
                        player.setDataSource(talkSportURL);
                        player.prepareAsync();
                        talkSportPlayImg.setImageResource(R.drawable.stop);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    talkSportPlayImg.setImageResource(R.drawable.play);
                    switchOn = true;
                    player.stop();
                    player.release();
                    player = null;
                }
            }
        });

        espnRadioPlayImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchOn) {
                    try {
                        myProgressBar.setVisibility(View.VISIBLE);
                        myProgressBar.setIndeterminate(true);
                        switchOn = false;
                        player = new MediaPlayer();
                        player.setOnPreparedListener(SportsActivity.this);
                        player.setDataSource(espnRadioURL);
                        player.prepareAsync();
                        espnRadioPlayImg.setImageResource(R.drawable.stop);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    espnRadioPlayImg.setImageResource(R.drawable.play);
                    switchOn = true;
                    player.stop();
                    player.release();
                    player = null;
                }
            }
        });

        wfanRadioPlayImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchOn) {
                    try {
                        myProgressBar.setVisibility(View.VISIBLE);
                        myProgressBar.setIndeterminate(true);
                        switchOn = false;
                        player = new MediaPlayer();
                        player.setOnPreparedListener(SportsActivity.this);
                        player.setDataSource(wfanSportsURL);
                        player.prepareAsync();
                        wfanRadioPlayImg.setImageResource(R.drawable.stop);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    wfanRadioPlayImg.setImageResource(R.drawable.play);
                    switchOn = true;
                    player.stop();
                    player.release();
                    player = null;
                }
            }
        });
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        player.start();
        myProgressBar.setIndeterminate(false);
        myProgressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(player != null) {
            player.stop();
            player.release();
            player = null;
        }
    }
}
