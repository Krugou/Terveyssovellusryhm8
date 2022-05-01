package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
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

    // Näihin listoihin lisätään käyttäjän syöttämä tieto, ja lisätään preferencceissä oleva tieto.
    private final ArrayList<String> paivamaaraLista = new ArrayList<>();
    private final ArrayList<String> kaloritLista = new ArrayList<>();
    private final ArrayList<String> mielialaLista= new ArrayList<>();
    private final ArrayList<String> kirjausLista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja_lisays);

        // lisää oletuksena paikallisen päivämäärän "syötä päivämäärä" kohtaan.
        String date_n = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
        TextView date  =  findViewById(R.id.editTextDate);
        date.setText(date_n);

    }

    // Metodi, joka ajetaan kun lisäysnappia painetaan.
    public void buttonPressed(View view) {

        boolean ready; // Tällä arvolla todetaan, onko päivämäärä täytetty

        // Tehdään EditText-näkymiin syötetyistä arvoista merkkijonoja.
        EditText paivamaara = findViewById(R.id.editTextDate);
        String paivamaaraString = paivamaara.getText().toString();

        EditText kalorit = findViewById(R.id.editTextKalorit);
        String kaloritString = kalorit.getText().toString();

        EditText mieliala = findViewById(R.id.editTextMieliala);
        String mielialaString = mieliala.getText().toString();

        EditText kirjaus=findViewById(R.id.editTextKirjaus);
        String kirjausString=kirjaus.getText().toString();

        // Jos päivämäärä puuttuu lähetetään käyttäjälle ilmoitus, joka käskee täyttää sen.
        if(paivamaaraString.equals(""))
        {
            ready=false;
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus) // // Ladataan alertiin liittyvät asiat stringeistä, jotta käyttö on monikielistä.
                    .setMessage(R.string.alertViesti)
                    .setPositiveButton(R.string.alertOk, (dialogInterface, i) -> {

                    })
                    .show();

        }
        else{
            ready=true;
        }
        if (ready) {

            //Jos käyttäjä ei lisännyt joitakin arvoja, niihin merkitään arvo "tyhjä" joka ladataan stringeistä. huom. monikielisyys.
            if(kaloritString.equals("")){
                kaloritString=getString(R.string.tyhjä);
            }
            if(mielialaString.equals(""))
            {
                mielialaString=getString(R.string.tyhjä);
            }
            if(kirjausString.equals(""))
            {
                kirjausString=getString(R.string.tyhjä);
            }

            // Näihin listoihin tallennetaan preferencceihin tallennetut merkkijono listat.
            ArrayList<String> paivamaaraLista2 = this.getArrayList("paivamaaralista");
            ArrayList<String> kaloritLista2 = this.getArrayList("kaloritlista");
            ArrayList<String> mielialaLista2 = this.getArrayList("mielialalista");
            ArrayList<String> kirjausLista2 = this.getArrayList("kirjauslista");

            // Listoihin lisätään käyttäjän syöttämät tiedot.
            paivamaaraLista.add(paivamaaraString);
            kaloritLista.add(kaloritString);
            mielialaLista.add(mielialaString);
            kirjausLista.add(kirjausString);

            // Jos preferenccien listat eivät ole tyhjiä, kopioidaan arvot toisiin listoihin.
            if (paivamaaraLista2 !=null) {
                paivamaaraLista.addAll(paivamaaraLista2);
                kaloritLista.addAll(kaloritLista2);
                mielialaLista.addAll(mielialaLista2);
                kirjausLista.addAll(kirjausLista2);
            }

            // Tallennetaan listat preferencceihin.
            this.saveArrayList(paivamaaraLista, "paivamaaralista");
            this.saveArrayList(kaloritLista, "kaloritlista");
            this.saveArrayList(mielialaLista, "mielialalista");
            this.saveArrayList(kirjausLista, "kirjauslista");


            // Siirrytään takaisin Päiväkirja-aktivitettiin.
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