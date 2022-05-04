package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class RentoutumisharjoitusActivity extends AppCompatActivity {

    int i = 0;
    int firstTime = 0;

    Player soundPlayer = new Player();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentoutumisharjoitus);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (i == 1){
            i = 0;
            soundPlayer.stopHumppa();
            soundPlayer.release();
        }

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        if (i == 1){
            i = 0;
            soundPlayer.stopHumppa();
            soundPlayer.release();
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        // initialiseSounds(this);
    }

    public void playHumppa(View v){
        System.out.println(Integer.toString(i));
        if (i == 0){
            soundPlayer.playSomeMusic("https://supla.digitacdn.net/live/_definst_/supla/radiorock/chunklist.m3u8", firstTime);
            firstTime = 1;
            i = 1;
        } else{
            i = 0;
            soundPlayer.stopHumppa();

        }

    }

}