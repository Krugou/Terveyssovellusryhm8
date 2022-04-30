package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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