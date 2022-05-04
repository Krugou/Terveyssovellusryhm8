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



public class TyhjaActivity extends AppCompatActivity {
    // Globaali indeksi muuttuja
    private int indeksi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tyhja);

        //Otetaan vastaan clickatun näkymän numeroarvo. Tallennetaan se globaaliin indeksi muuttujaan
        Intent intent = getIntent();
         indeksi = intent.getIntExtra("nro", -1);

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
        String placeholder = getString(R.string.logi)+" "+kirjausLista.get(indeksi);
        TextView tvKirjaus = findViewById(R.id.kirjausText);
        tvKirjaus.setText(placeholder);

        //Näkymän numeroarvon avulla haetaan paivamaaran informaatio ja lisätään se textviewiin.
        placeholder=getString(R.string.päivä)+" "+paivamaaraLista.get(indeksi);
        TextView tvPaiva = findViewById(R.id.paivamaaraText);
        tvPaiva.setText(placeholder);

        //Näkymän numeroarvon avulla haetaan kaloreiden informaatio ja lisätään se textviewiin.
        //Jos kalorit jätetty tyhjäksi, ei ilmoiteta arvoa kilokaloreina. Tyhjän arvo on ladattu stringeistä.
        if(kaloritLista.get(indeksi).equals(getString(R.string.tyhjä))) {
            placeholder = getString(R.string.kalorit) +" "+ kaloritLista.get(indeksi);
        }
        else{
            placeholder = getString(R.string.kalorit) +" "+ kaloritLista.get(indeksi) + " kcal";
        }
        TextView tvKalorit = findViewById(R.id.kaloritText);
        tvKalorit.setText(placeholder);

        //Näkymän numeroarvon avulla haetaan mielialan informaatio ja lisätään se textviewiin.
        placeholder=getString(R.string.mielialaString)+" "+mielialaLista.get(indeksi);
        TextView tvMieliala = findViewById(R.id.mielialaText);
        tvMieliala.setText(placeholder);

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
    public void openEditor(View view){
        Intent intent = new Intent(this, TyhjaActivityEditorActivity.class);
        intent.putExtra("indeksi", indeksi); // Mukaan indeksi, jolla editori aktiviteetti osaa navigoida listoja.
        startActivity(intent);
    }
}