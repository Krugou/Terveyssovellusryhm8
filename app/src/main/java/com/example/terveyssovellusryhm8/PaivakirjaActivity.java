package com.example.terveyssovellusryhm8;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class PaivakirjaActivity extends AppCompatActivity {

    //Näihin listoihin tallennetaan preferencceihin tallennetut arvot.
    private ArrayList<String> paivamaaraLista = new ArrayList<>();
    private ArrayList<String> kaloritLista = new ArrayList<>();
    private ArrayList<String> mielialaLista = new ArrayList<>();
    private ArrayList<String> kirjausLista = new ArrayList<>();

    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);

    }
//Metodi, joka siirtää lisäys aktiviteettiin napin painalluksella.
    public void openDiaryEditor(View view) {
        Intent intent = new Intent(this, PaivakirjaLisaysActivity.class);
        startActivity(intent);
    }
//Metodi, joka siirtää aloitussivulle napin painalluksella.
    public void openHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ListView paivakirjaLista = findViewById(R.id.paivakirjaLista);

/*
Jos käyttäjä on tehnyt lisäyksiä "paivamaaralista!=null", silloin arvot
tallennetaan luokan sisäisiin listoihin.
 */
        if (this.getArrayList("paivamaaralista") != null) {
            paivamaaraLista = this.getArrayList("paivamaaralista");
            kaloritLista = this.getArrayList("kaloritlista");
            mielialaLista = this.getArrayList("mielialalista");
            kirjausLista = this.getArrayList("kirjauslista");

            // Listview saa adapterin listaan, jossa on päivämäärät.
            this.listAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    paivamaaraLista);
            paivakirjaLista.setAdapter(this.listAdapter);

            // Asetetaan listan näkymille kuuntelija, joka vie painalluksen jälkeen uuteen aktiviteettiin.
            paivakirjaLista.setOnItemClickListener((adapterView, view, i, l) -> {
                Intent intent = new Intent(getApplicationContext(), tyhjaActivity.class);
                intent.putExtra("nro", i); //Viedään extrana painetun viewin numeroarvo.
                startActivity(intent);
            });
        }

        //Asetetaan listviewille longclick-kuuntelija, jolla poisetetaan listasta lisäyksiä.
        paivakirjaLista.setOnItemLongClickListener((adapterView, view, i, l) -> {
            final int poistettava = i; //Tallennetaan longclickatun näkymän arvo.

        //Tehdään alertti, joka varmistaa käyttäjän poistamisen.
            new AlertDialog.Builder(PaivakirjaActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus)
                    .setMessage(R.string.alertPoistoViesti)

                    // Jos käyttäjä valitsee "Kyllä", listoista poistetaan longclickatun näkymän tiedot.
                    .setPositiveButton(R.string.alertKyllä, (dialogInterface, i1) -> {

                        paivamaaraLista.remove(poistettava);
                        kaloritLista.remove(poistettava);
                        mielialaLista.remove(poistettava);
                        kirjausLista.remove(poistettava);

                        listAdapter.notifyDataSetChanged(); //Kerrotaan adapterille, että data on muuttunut.

                        //Tallennetaan preferencceihin muutetut listat.
                        saveArrayList(paivamaaraLista, "paivamaaralista");
                        saveArrayList(kaloritLista, "kaloritlista");
                        saveArrayList(mielialaLista, "mielialalista");
                        saveArrayList(kirjausLista, "kirjauslista");

                    })
                    // Jos käyttäjä valitsee "Ei", mitään ei tapahdu.
                    .setNegativeButton(R.string.alertEi, null)
                    .show();

            return true;
        });

    }

    //Metodi, Jonka avulla preferencceihin tallennetaan Arraylistoja, listan ja avaimen parametreilla.
    public void saveArrayList(ArrayList<String> list, String key) {
        SharedPreferences prefs = getApplication().getSharedPreferences("testaus20", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }
    //Metodi, jonka avulla preferencceistä haetaan tallennettu Arraylista avaimen parametrilla.
    public ArrayList<String> getArrayList(String key) {
        SharedPreferences prefs = getApplication().getSharedPreferences("testaus20", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        return gson.fromJson(json, type);
    }

}