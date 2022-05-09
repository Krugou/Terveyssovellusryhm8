package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Joonas
 * Luokka PaivakirjaLisaysActivity-aktiviteetille, jossa käyttäjä tekee päiväkirjaan lisäyksiä.
 */
public class PaivakirjaLisaysActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja_lisays);

        // lisää oletuksena paikallisen päivämäärän "syötä päivämäärä" kohtaan.
        String tanPaivanLisays = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
        TextView etsiPaivaRuutuRuudulta = findViewById(R.id.editTextPaiva);
        etsiPaivaRuutuRuudulta.setText(tanPaivanLisays);
    }

    /**
     * Metodi, jota kutsutaan kun lisääysnappia painetaan.
     * @param view nappi näkymä. R.id.buttonLisays
     */

    public void buttonPressed(View view) {

        boolean ready; // Tällä arvolla todetaan, onko päivämäärä täytetty

        // Tehdään EditText-näkymiin syötetyistä arvoista merkkijonoja.
        EditText paivamaara = findViewById(R.id.editTextPaiva);
        String paivamaaraString = paivamaara.getText().toString();

        EditText kalorit = findViewById(R.id.editTextKalorit);
        String kaloritString = kalorit.getText().toString();

        EditText mieliala = findViewById(R.id.editTextMieliala);
        String mielialaString = mieliala.getText().toString();

        EditText kirjaus = findViewById(R.id.editTextKirjaus);
        String kirjausString = kirjaus.getText().toString();

        // Jos päivämäärä puuttuu lähetetään käyttäjälle ilmoitus, joka käskee täyttää sen.
        if (paivamaaraString.equals("")) {
            ready = false;
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus) // // Ladataan alertiin liittyvät asiat stringeistä, jotta käyttö on monikielistä.
                    .setMessage(R.string.alertViesti)
                    .setPositiveButton(R.string.alertOk, (dialogInterface, i) -> {

                    })
                    .show();

        } else {
            ready = true;
        }
        if (ready) {

            //Jos käyttäjä ei lisännyt joitakin arvoja, niihin merkitään arvo "tyhjä" joka ladataan stringeistä. huom. monikielisyys.
            if (kaloritString.equals("")) {
                kaloritString = getString(R.string.tyhjä);
            }
            if (mielialaString.equals("")) {
                mielialaString = getString(R.string.tyhjä);
            }
            if (kirjausString.equals("")) {
                kirjausString = getString(R.string.tyhjä);
            }
            // Kutsutaan päiväkirjan konstruktoria kenttien tiedoilla.
            Paivakirja paivakirja = new Paivakirja(paivamaaraString, kaloritString, mielialaString, kirjausString, this);
            paivakirja.addPrevious();
            paivakirja.applyChanges();

            // Siirrytään takaisin Päiväkirja-aktivitettiin.
            Intent intent = new Intent(this, PaivakirjaActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Metodi, jolla siirrytään takaisin viime aktiviteettiin.
     * @param view floating-napin näkymä. R.id.buttonTakaisinLisays
     */
    public void goBack(View view) {
        finish();
    }
}