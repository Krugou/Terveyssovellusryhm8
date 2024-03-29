package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;
import java.util.Random;
/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Video play loop.
     */
    public void videoPlayLoop(){
        // sekalainen video main aktiviteetille
        VideoView videoView =findViewById(R.id.videoView2);
        Random sekalainen = new Random();
        int videoNumero = sekalainen.nextInt((6 - 1) + 1) + 1;
        Log.i("my_app", String.valueOf(videoNumero));
        if (videoNumero == 1) {
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental1);
        } else if (videoNumero == 2) {
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental2);
        } else if (videoNumero == 3) {
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental3);
        } else if (videoNumero == 4) {
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental4);
        } else if (videoNumero == 5) {
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental5);

        } else {
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.mental6);

        }
        videoView.start();
        // looppi videolle
        videoView.setOnCompletionListener(mediaPlayer -> videoView.start());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoPlayLoop();

    }


    @Override
    protected void  onResume() {
        super.onResume();
        videoPlayLoop();

    }

    /**
     * Open mood activity.
     *
     * @param view the view
     */
    public void openMoodActivity(View view) {
        Intent intent = new Intent(this, MielialakyselyActivity.class);
        startActivity(intent);
    }

    /**
     * Open diary.
     *
     * @param v the v
     */
//Metodi, joka siirtää päiväkirja-aktiviteettiin napin painalluksella.
    public void openDiary(View v){
        Intent intent = new Intent(this, PaivakirjaActivity.class);

        startActivity(intent);
    }

    /**
     * Open diary editor.
     *
     * @param v the v
     */
//Metodi, joka siirtää päiväkirjanlisäys-aktiviteettiin napin painalluksella.
    public void openDiaryEditor(View v){
        Intent intent = new Intent(this, PaivakirjaLisaysActivity.class);
        startActivity(intent);
    }

    /**
     * Open relax.
     *
     * @param v the v
     */
    public void openRelax(View v){
        Intent intent = new Intent(this, RentoutumisharjoitusActivity.class);
        startActivity(intent);
    }


}