package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class tyhjaActivityEditor extends AppCompatActivity {

    private ArrayList<String> paivamaaraLista = new ArrayList<>();
    private ArrayList<String> kaloritLista = new ArrayList<>();
    private ArrayList<String> mielialaLista= new ArrayList<>();
    private ArrayList<String> kirjausLista = new ArrayList<>();

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private int indeksi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tyhja_editor);
        Intent intent=getIntent();
         indeksi = intent.getIntExtra("indeksi", -1);

         paivamaaraLista = this.getArrayList("paivamaaralista");
         kaloritLista = this.getArrayList("kaloritlista");
         mielialaLista = this.getArrayList("mielialalista");
         kirjausLista = this.getArrayList("kirjauslista");

        et1=findViewById(R.id.editPaiva);
        et2=findViewById(R.id.editKalorit);
        et3=findViewById(R.id.editMieliala);
        et4=findViewById(R.id.editKirjaus);

        et1.setText(paivamaaraLista.get(indeksi));
        et2.setText(kaloritLista.get(indeksi));
        et3.setText(mielialaLista.get(indeksi));
        et4.setText(kirjausLista.get(indeksi));



    }
    public void saveEdits(View view){
        boolean ready;
        String editoituPaivamaara = et1.getText().toString();
        if (editoituPaivamaara.equals("")){
            ready = false;
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus)
                    .setMessage(R.string.alertViesti)
                    .setPositiveButton(R.string.alertOk, (dialogInterface, i) -> {

                    })
                    .show();

        }
        else {
            ready=true;
        }
        if (ready) {
            String editoituKalori = et2.getText().toString();
            String editoituMieliala = et3.getText().toString();
            String editoituKirjaus = et4.getText().toString();

            if(editoituKalori.equals("")){
                editoituKalori=getString(R.string.tyhjä);
            }
            if(editoituMieliala.equals("")){
                editoituMieliala=getString(R.string.tyhjä);
            }
            if (editoituKirjaus.equals("")){
                editoituKirjaus=getString(R.string.tyhjä);
            }

            paivamaaraLista.set(indeksi, editoituPaivamaara);
            kaloritLista.set(indeksi, editoituKalori);
            mielialaLista.set(indeksi, editoituMieliala);
            kirjausLista.set(indeksi, editoituKirjaus);

            this.saveArrayList(paivamaaraLista, "paivamaaralista");
            this.saveArrayList(kaloritLista, "kaloritlista");
            this.saveArrayList(mielialaLista, "mielialalista");
            this.saveArrayList(kirjausLista, "kirjauslista");

            Intent intent = new Intent(this, PaivakirjaActivity.class);
            startActivity(intent);
        }
    }
    //Metodi, Jonka avulla preferencceihin tallennetaan Arraylistoja, listan ja avaimen parametreilla.
    public void saveArrayList(ArrayList<String> list, String key){
        SharedPreferences prefs = getApplication().getSharedPreferences("testaus20", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    //Metodi, jonka avulla preferencceistä haetaan tallennettu Arraylista avaimen parametrilla.
    public ArrayList<String> getArrayList(String key){
        SharedPreferences prefs = getApplication().getSharedPreferences("testaus20", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }
}