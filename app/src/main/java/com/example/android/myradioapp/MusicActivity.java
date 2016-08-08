package com.example.android.myradioapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;

public class MusicActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    private MediaPlayer player;
    private String fm181RadioURL = "http://relay5.181.fm:8064/";
    private String radioLoveLiveRadioURL = "http://newyorkcity.radiostreamlive.com:8000/radiolovelive_128";
    private String bluegrassRadioURL = "http://209.133.216.3:7362/live";
    private ImageView fm181RadioPlayImg;
    private ImageView bluegrassRadioPlayImg;
    private ImageView radioLoveLiveRadioPlayImg;
    private boolean switchOn = true;
    private ProgressBar myProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        myProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        fm181RadioPlayImg = (ImageView) findViewById(R.id.fm181_status);
        bluegrassRadioPlayImg = (ImageView) findViewById(R.id.bluegrass_status);
        radioLoveLiveRadioPlayImg = (ImageView) findViewById(R.id.radio_love_live_status);

        myProgressBar.setVisibility(View.INVISIBLE);

        fm181RadioPlayImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchOn) {
                    try {
                        myProgressBar.setVisibility(View.VISIBLE);
                        myProgressBar.setIndeterminate(true);
                        switchOn = false;
                        player = new MediaPlayer();
                        player.setOnPreparedListener(MusicActivity.this);
                        player.setDataSource(fm181RadioURL);
                        player.prepareAsync();
                        fm181RadioPlayImg.setImageResource(R.drawable.stop);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    fm181RadioPlayImg.setImageResource(R.drawable.play);
                    switchOn = true;
                    player.stop();
                    player.release();
                    player = null;
                }
            }
        });

        bluegrassRadioPlayImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchOn) {
                    try {
                        myProgressBar.setVisibility(View.VISIBLE);
                        myProgressBar.setIndeterminate(true);
                        switchOn = false;
                        player = new MediaPlayer();
                        player.setOnPreparedListener(MusicActivity.this);
                        player.setDataSource(bluegrassRadioURL);
                        player.prepareAsync();
                        bluegrassRadioPlayImg.setImageResource(R.drawable.stop);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    bluegrassRadioPlayImg.setImageResource(R.drawable.play);
                    switchOn = true;
                    player.stop();
                    player.release();
                    player = null;
                }
            }
        });

        radioLoveLiveRadioPlayImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchOn) {
                    try {
                        myProgressBar.setVisibility(View.VISIBLE);
                        myProgressBar.setIndeterminate(true);
                        switchOn = false;
                        player = new MediaPlayer();
                        player.setOnPreparedListener(MusicActivity.this);
                        player.setDataSource(radioLoveLiveRadioURL);
                        player.prepareAsync();
                        radioLoveLiveRadioPlayImg.setImageResource(R.drawable.stop);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    radioLoveLiveRadioPlayImg.setImageResource(R.drawable.play);
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
