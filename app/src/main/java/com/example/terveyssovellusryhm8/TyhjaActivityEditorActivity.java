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

public class TyhjaActivityEditorActivity extends AppCompatActivity {

    // Näihin listoihin lisätään käyttäjän syöttämä tieto, ja lisätään preferencceissä oleva tieto.
    private ArrayList<String> paivamaaraLista = new ArrayList<>();
    private ArrayList<String> kaloritLista = new ArrayList<>();
    private ArrayList<String> mielialaLista= new ArrayList<>();
    private ArrayList<String> kirjausLista = new ArrayList<>();

    // Näillä päästään käsiksi EditText-näkymiin.
    private EditText paivamaaraEdit;
    private EditText kaloritEdit;
    private EditText mieliaalaEdit;
    private EditText kirjausEdit;

    // Globaali indeksi muuttuja.
    private int indeksi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tyhja_editor);

        // Otetaan vastaan intentin lähettämä numeroarvo. Tallennetaan se indeksi muuttujaan.
        Intent intent=getIntent();
         indeksi = intent.getIntExtra("indeksi", -1);

         // Kopioidaan listoihin arvot preferencceistä.
         paivamaaraLista = this.getArrayList("paivamaaralista");
         kaloritLista = this.getArrayList("kaloritlista");
         mielialaLista = this.getArrayList("mielialalista");
         kirjausLista = this.getArrayList("kirjauslista");

         // Liitetään muuttujat EditTexteihin.
        paivamaaraEdit=findViewById(R.id.editPaiva);
        kaloritEdit=findViewById(R.id.editKalorit);
        mieliaalaEdit=findViewById(R.id.editMieliala);
        kirjausEdit=findViewById(R.id.editKirjaus);

        // Syötetään EditTexteihin arvoiksi listalta löytyvät merkkijonot indeksi muuttujan avulla.
        paivamaaraEdit.setText(paivamaaraLista.get(indeksi));
        kaloritEdit.setText(kaloritLista.get(indeksi));
        mieliaalaEdit.setText(mielialaLista.get(indeksi));
        kirjausEdit.setText(kirjausLista.get(indeksi));



    }
    // Tätä kutsutaan, kun Tallenna-nappia painetaan.
    public void saveEdits(View view){
        boolean ready;
        String editoituPaivamaara = paivamaaraEdit.getText().toString();

        // Jos päivämäärä puuttuu lähetetään käyttäjälle ilmoitus, joka käskee täyttää sen.
        if (editoituPaivamaara.equals("")){
            ready = false;
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus) // Ladataan alertiin liittyvät asiat stringeistä, jotta käyttö on monikielistä.
                    .setMessage(R.string.alertViesti)
                    .setPositiveButton(R.string.alertOk, (dialogInterface, i) -> {

                    })
                    .show();

        }
        else {
            ready=true;
        }
        if (ready) {

            // Tallennetaan käyttäjän syöttämät arvot merkkijonoihin
            String editoituKalori = kaloritEdit.getText().toString();
            String editoituMieliala = mieliaalaEdit.getText().toString();
            String editoituKirjaus = kirjausEdit.getText().toString();

            // Jos käyttäjä ei syöttänyt joitain arvoja, niihin merkitään arvo "tyhjä" joka ladataan stringeistä. Huom. monikielisyys.
            if(editoituKalori.equals("")){
                editoituKalori=getString(R.string.tyhjä);
            }
            if(editoituMieliala.equals("")){
                editoituMieliala=getString(R.string.tyhjä);
            }
            if (editoituKirjaus.equals("")){
                editoituKirjaus=getString(R.string.tyhjä);
            }

            // Listojen indeksi muuttujan osoittamaan alkioon muokataan käyttäjän syöttämät arvot.
            paivamaaraLista.set(indeksi, editoituPaivamaara);
            kaloritLista.set(indeksi, editoituKalori);
            mielialaLista.set(indeksi, editoituMieliala);
            kirjausLista.set(indeksi, editoituKirjaus);

            // Tallennetaan listat preferencceihin.
            this.saveArrayList(paivamaaraLista, "paivamaaralista");
            this.saveArrayList(kaloritLista, "kaloritlista");
            this.saveArrayList(mielialaLista, "mielialalista");
            this.saveArrayList(kirjausLista, "kirjauslista");

            // Mennään takaisin päiväkirja-aktiviteettiin
            Intent intent = new Intent(this, PaivakirjaActivity.class);
            startActivity(intent);
        }
    }
    // Metodi, Jonka avulla preferencceihin tallennetaan Arraylistoja, listan ja avaimen parametreilla.
    public void saveArrayList(ArrayList<String> list, String key){
        SharedPreferences prefs = getApplication().getSharedPreferences("testaus20", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    // Metodi, jonka avulla preferencceistä haetaan tallennettu Arraylista avaimen parametrilla.
    public ArrayList<String> getArrayList(String key){
        SharedPreferences prefs = getApplication().getSharedPreferences("testaus20", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }
    // Metodi, joka vie takaisin TyhjaActivityyn.
    public void goBack(View view){
        Intent intent = new Intent(this, TyhjaActivity.class);
        intent.putExtra("nro", indeksi); // Mukaan indeksi, jonka avulla TyhjaActivity hakee infot listoista.
        startActivity(intent);
    }
}