package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class PaivakirjaLisaysActivity extends AppCompatActivity {

    // NÄIHIN LUETAAN KÄYTTÄJÄN SYÖTTÄMÄ TIETO JA LISÄTÄÄN PREFERENCCIT
    private ArrayList<String> paivamaaraLista = new ArrayList<>();
    private ArrayList<String> kaloritLista = new ArrayList<>();
    private ArrayList<String> mielialaLista= new ArrayList<>();
    private ArrayList<String> kirjausLista = new ArrayList<>();


    // NÄIHIN LADATAAN PREFERENCEISSÄ OLEVAT TIEDOT
    private ArrayList<String>paivamaaraLista2=new ArrayList<>();
    private ArrayList<String>kaloritLista2=new ArrayList<>();
    private ArrayList<String>mielialaLista2=new ArrayList<>();
    private ArrayList<String>kirjausLista2=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja_lisays);
        // lisää oletuksena paikallisen päivämäärän "syötä päivämäärä" kohtaan
        String date_n = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
        TextView date  = (TextView) findViewById(R.id.editTextDate);
        date.setText(date_n);

    }
    public void buttonPressed(View view) {
        boolean ready = false;
        EditText paivamaara = findViewById(R.id.editTextDate);
        String paivamaaraString = paivamaara.getText().toString();
        EditText kalorit = findViewById(R.id.editTextKalorit);
        String kaloritString = kalorit.getText().toString();
        EditText mieliala = findViewById(R.id.editTextMieliala);
        String mielialaString = mieliala.getText().toString();
        EditText kirjaus=findViewById(R.id.editTextKirjaus);
        String kirjausString=kirjaus.getText().toString();
        if(paivamaaraString.equals("") ||kaloritString.equals("") || mielialaString.equals("") || kirjausString.equals("") )
        {
            ready = false;
            Log.i("MYAPP", "asd23");
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("HUOMATUS!")
                    .setMessage("Sinun Tulee Täyttää Kaikki Kohdat Ennen Jatkamista")
                    .setPositiveButton("OKEI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .show();

        }
        else{
            ready=true;
        }
        if (ready==true) {

            paivamaaraLista2=this.getArrayList("paivamaaralista");
            kaloritLista2=this.getArrayList("kaloritlista");
            mielialaLista2=this.getArrayList("mielialalista");
            kirjausLista2=this.getArrayList("kirjauslista");
            if (paivamaaraLista2!=null) {
                for (int i = 0; i < paivamaaraLista2.size(); i++) {
                    paivamaaraLista.add(paivamaaraLista2.get(i));
                }
                for (int i = 0; i < kaloritLista2.size(); i++) {
                    kaloritLista.add(kaloritLista2.get(i));
                }
                for (int i = 0; i < mielialaLista2.size(); i++) {
                    mielialaLista.add(mielialaLista2.get(i));
                }
                for (int i = 0; i < kirjausLista2.size(); i++) {
                    kirjausLista.add(kirjausLista2.get(i));
                }
            }
            paivamaaraLista.add(paivamaaraString);
            kaloritLista.add(kaloritString);
            mielialaLista.add(mielialaString);
            kirjausLista.add(kirjausString);

            this.saveArrayList(paivamaaraLista, "paivamaaralista");
            this.saveArrayList(kaloritLista, "kaloritlista");
            this.saveArrayList(mielialaLista, "mielialalista");
            this.saveArrayList(kirjausLista, "kirjauslista");



            Intent intent = new Intent(this, PaivakirjaActivity.class);
            startActivity(intent);


        }
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

}