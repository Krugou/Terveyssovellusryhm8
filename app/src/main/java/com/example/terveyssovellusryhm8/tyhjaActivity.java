package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;



public class tyhjaActivity extends AppCompatActivity {

    private ArrayList<String> paivamaaraLista = new ArrayList<>();
    private ArrayList<String> kaloritLista = new ArrayList<>();
    private ArrayList<String>mielialaLista = new ArrayList<>();
    private ArrayList<String>kirjausLista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tyhja);
        Intent intent = getIntent();
        int indeksi = intent.getIntExtra("nro", -1);


        paivamaaraLista=this.getArrayList("paivamaaralista");
        kaloritLista=this.getArrayList("kaloritlista");
        mielialaLista=this.getArrayList("mielialalista");
        kirjausLista=this.getArrayList("kirjauslista");



        TextView tv = findViewById(R.id.kirjausText);
        tv.setText("LOGI: "+kirjausLista.get(indeksi));

        TextView tv2 = findViewById(R.id.paivamaaraText);
        tv2.setText("Päivä: "+paivamaaraLista.get(indeksi));

        TextView tv3 = findViewById(R.id.kaloritText);
        tv3.setText("Kalorit: "+kaloritLista.get(indeksi));

        TextView tv4 = findViewById(R.id.mielialaText);
        tv4.setText("Mieliala: "+mielialaLista.get(indeksi));



    }
    public void saveArrayList(ArrayList<String> list, String key){
        SharedPreferences prefs = getApplication().getSharedPreferences("testaus20", Context.MODE_PRIVATE);;
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public ArrayList<String> getArrayList(String key){
        SharedPreferences prefs = getApplication().getSharedPreferences("testaus20", Context.MODE_PRIVATE);;
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }
    public void goBack(View view){
        Intent intent = new Intent(this, PaivakirjaActivity.class);
        startActivity(intent);
    }
}