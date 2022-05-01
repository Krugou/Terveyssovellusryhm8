package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView videoView = (VideoView) findViewById(R.id.videoView2);
        Random sekalainen = new Random();
        int videoNumero = sekalainen.nextInt((6 - 1) + 1) + 1;
        Log.i("my_app", String.valueOf(videoNumero));
        if (videoNumero == 1){
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental1);
    } else if ( videoNumero == 2){
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental2);
    } else if ( videoNumero == 3){
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental3);
    } else if ( videoNumero == 4){
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental4);
    } else if ( videoNumero == 5){
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental5);

    } else if ( videoNumero == 6){
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental6);

    }
        videoView.start();
        // looppi videolle
        videoView.setOnCompletionListener ( new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });
    }
    //Metodi, joka siirtää päiväkirja-aktiviteettiin napin painalluksella.
    public void openDiary(View v){
        Intent intent = new Intent(this, PaivakirjaActivity.class);

        startActivity(intent);
    }
    //Metodi, joka siirtää päiväkirjanlisäys-aktiviteettiin napin painalluksella.
    public void openDiaryEditor(View v){
        Intent intent = new Intent(this, PaivakirjaLisaysActivity.class);

        startActivity(intent);
    }


}