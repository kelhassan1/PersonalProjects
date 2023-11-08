package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mpWeeknd, mpMichael, mpKanye;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.musicBtn1);
        Button button1 = (Button) findViewById(R.id.musicBtn2);
        Button button2 = (Button) findViewById(R.id.musicBtn3);
        mpWeeknd = new MediaPlayer();
        mpWeeknd = MediaPlayer.create(this, R.raw.weeknd);
        mpMichael = new MediaPlayer();
        mpMichael = MediaPlayer.create(this, R.raw.michael_jackson);
        mpKanye = new MediaPlayer();
        mpKanye = MediaPlayer.create(this, R.raw.kanye_west);
        playing = 0;

        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                switch (playing){
                    case 0:
                        mpWeeknd.start();
                        playing = 1;
                        button.setText("Pause The Weeknd Song");
                        button1.setVisibility(View.INVISIBLE);
                        button2.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpWeeknd.pause();
                        playing = 0;
                        button.setText("Play The Weeknd");
                        button1.setVisibility(View.VISIBLE);
                        button2.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                switch (playing){
                    case 0:
                        mpMichael.start();
                        playing = 1;
                        button1.setText("Pause Michael Jackson Song");
                        button.setVisibility(View.INVISIBLE);
                        button2.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpMichael.pause();
                        playing = 0;
                        button1.setText("Play Michael Jackson");
                        button.setVisibility(View.VISIBLE);
                        button2.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                switch (playing){
                    case 0:
                        mpKanye.start();
                        playing = 1;
                        button2.setText("Pause Kanye West Song");
                        button.setVisibility(View.INVISIBLE);
                        button1.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpKanye.pause();
                        playing = 0;
                        button2.setText("Play Kanye West");
                        button.setVisibility(View.VISIBLE);
                        button1.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }

}