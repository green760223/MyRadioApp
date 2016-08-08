package com.example.android.myradioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view that shows the specific category
        TextView news = (TextView) findViewById(R.id.news);
        TextView sports = (TextView) findViewById(R.id.sports);
        TextView music = (TextView) findViewById(R.id.talk_sport_textview);

        // Set up OnClickListener method to trigger open specific activity
        // To open NewsActivity from TextView which named is news.
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newsIntent = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(newsIntent);
            }
        });

        // To open MusicActivity from TextView which named is music.
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musicIntent = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(musicIntent);
            }
        });

        // To open SportsActivity from TextView which named is sports.
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sportsIntent = new Intent(MainActivity.this, SportsActivity.class);
                startActivity(sportsIntent);
            }
        });
    }
}
