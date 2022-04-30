package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;



public class tyhjaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tyhja);

        //Otetaan vastaan clickatun näkymän numeroarvo.
        Intent intent = getIntent();
        int indeksi = intent.getIntExtra("nro", -1);

        //Näihin listoihin tallennetaan preferencceihin tallennetut arvot.
      ArrayList<String>paivamaaraLista;
      ArrayList<String>kaloritLista;
      ArrayList<String>mielialaLista;
      ArrayList<String>kirjausLista;

        //Tallennetaan listoihin preferenccejen arvot
        paivamaaraLista=this.getArrayList("paivamaaralista");
        kaloritLista=this.getArrayList("kaloritlista");
        mielialaLista=this.getArrayList("mielialalista");
        kirjausLista=this.getArrayList("kirjauslista");

        //Näkymän numeroarvon avulla haetaan kirjauksen informaatio ja lisätään se textviewiin.
        String placeholder = "LOGI: "+kirjausLista.get(indeksi);
        TextView tv = findViewById(R.id.kirjausText);
        tv.setText(placeholder);

        //Näkymän numeroarvon avulla haetaan paivamaaran informaatio ja lisätään se textviewiin.
        placeholder="Päivä: "+paivamaaraLista.get(indeksi);
        TextView tv2 = findViewById(R.id.paivamaaraText);
        tv2.setText(placeholder);

        //Näkymän numeroarvon avulla haetaan kaloreiden informaatio ja lisätään se textviewiin.
        //Jos kalorit jätetty tyhjäksi, ei ilmoiteta arvoa kilokaloreina.
        if(kaloritLista.get(indeksi).equals("Tyhjä")) {
            placeholder = "Kalorit: " + kaloritLista.get(indeksi);
        }
        else{
            placeholder = "Kalorit: " + kaloritLista.get(indeksi) + " kcal";
        }
        TextView tv3 = findViewById(R.id.kaloritText);
        tv3.setText(placeholder);

        //Näkymän numeroarvon avulla haetaan mielialan informaatio ja lisätään se textviewiin.
        placeholder="Mieliala: "+mielialaLista.get(indeksi);
        TextView tv4 = findViewById(R.id.mielialaText);
        tv4.setText(placeholder);

    }

    //Metodi, jonka avulla preferencceistä haetaan tallennettu Arraylista avaimen parametrilla.
    public ArrayList<String> getArrayList(String key){
        SharedPreferences prefs = getApplication().getSharedPreferences("testaus20", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }
    //Metodi, jonka avulla käyttäjä palaa päiväkirja-aktiviteettiin napin painalluksella.
    public void goBack(View view){
        Intent intent = new Intent(this, PaivakirjaActivity.class);
        startActivity(intent);
    }
}