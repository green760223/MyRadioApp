package com.example.android.myradioapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;

public class NewsActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    private MediaPlayer player;
    private String bbcRadioURL = "http://bbcwssc.ic.llnwd.net/stream/bbcwssc_mp1_ws-eieuk";
    private String foxNewsRadioURL = "http://107.22.125.82/foxnewsradio-foxnewsmp3-ibc2";
    private String voaRadioURL = "http://92.122.127.4/7/48/322034/v1/ibb.akacast.akamaistream.net/voa-22?akacasthops=1";
    private ImageView bbcRadioPlayImg;
    private ImageView foxNewsRadioPlayImg;
    private ImageView voaRadioPlayImg;
    private boolean switchOn = true;
    private ProgressBar myProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        myProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        bbcRadioPlayImg = (ImageView) findViewById(R.id.bbc_status);
        foxNewsRadioPlayImg = (ImageView) findViewById(R.id.fox_status);
        voaRadioPlayImg = (ImageView) findViewById(R.id.voa_status);

        myProgressBar.setVisibility(View.INVISIBLE);

        bbcRadioPlayImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchOn) {
                    try {
                        myProgressBar.setVisibility(View.VISIBLE);
                        myProgressBar.setIndeterminate(true);
                        switchOn = false;
                        player = new MediaPlayer();
                        player.setOnPreparedListener(NewsActivity.this);
                        player.setDataSource(bbcRadioURL);
                        player.prepareAsync();
                        bbcRadioPlayImg.setImageResource(R.drawable.stop);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    bbcRadioPlayImg.setImageResource(R.drawable.play);
                    switchOn = true;
                    player.stop();
                    player.release();
                    player = null;
                }
            }
        });

        foxNewsRadioPlayImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchOn) {
                    try {
                        myProgressBar.setVisibility(View.VISIBLE);
                        myProgressBar.setIndeterminate(true);
                        switchOn = false;
                        player = new MediaPlayer();
                        player.setOnPreparedListener(NewsActivity.this);
                        player.setDataSource(foxNewsRadioURL);
                        player.prepareAsync();
                        foxNewsRadioPlayImg.setImageResource(R.drawable.stop);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    foxNewsRadioPlayImg.setImageResource(R.drawable.play);
                    switchOn = true;
                    player.stop();
                    player.release();
                    player = null;
                }
            }
        });

        voaRadioPlayImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchOn) {
                    try {
                        myProgressBar.setVisibility(View.VISIBLE);
                        myProgressBar.setIndeterminate(true);
                        switchOn = false;
                        player = new MediaPlayer();
                        player.setOnPreparedListener(NewsActivity.this);
                        player.setDataSource(voaRadioURL);
                        player.prepareAsync();
                        voaRadioPlayImg.setImageResource(R.drawable.stop);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    voaRadioPlayImg.setImageResource(R.drawable.play);
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
