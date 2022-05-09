package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Joonas
 * Luokka PaivakirjaLisaysActivity-aktiviteetille, jossa käyttäjä tekee päiväkirjaan lisäyksiä.
 */
public class PaivakirjaLisaysActivity extends AppCompatActivity {
    private DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja_lisays);

        // lisää oletuksena paikallisen päivämäärän "syötä päivämäärä" kohtaan.
        String tanPaivanLisays = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
        TextView etsiPaivaRuutuRuudulta = findViewById(R.id.editTextPaiva);
        etsiPaivaRuutuRuudulta.setText(tanPaivanLisays);
        etsiPaivaRuutuRuudulta.setInputType(InputType.TYPE_NULL);
        etsiPaivaRuutuRuudulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                // date picker dialog
                picker = new DatePickerDialog(PaivakirjaLisaysActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                monthOfYear++;
                                String day = Integer.toString(dayOfMonth);
                                String month = Integer.toString(monthOfYear);
                                if (monthOfYear < 10){
                                    month = "0" + monthOfYear;
                                } if (dayOfMonth < 10){
                                    day = "0" + dayOfMonth;
                                }
                                etsiPaivaRuutuRuudulta.setText(day + "." + month + "." + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

    }

    /**
     * Metodi, jota kutsutaan kun lisääysnappia painetaan.
     * @param view nappi näkymä. R.id.buttonLisays
     */

    public void buttonPressed(View view) {

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
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus) // // Ladataan alertiin liittyvät asiat stringeistä, jotta käyttö on monikielistä.
                    .setMessage(R.string.alertViesti)
                    .setPositiveButton(R.string.alertOk, (dialogInterface, i) -> {

                    })
                    .show();

        } else if (kirjausString.equals("") && mielialaString.equals("")) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus) // // Ladataan alertiin liittyvät asiat stringeistä, jotta käyttö on monikielistä.
                    .setMessage(R.string.etVastannutAlert)
                    .setPositiveButton(R.string.alertOk, (dialogInterface, i) -> {

                    })
                    .show();
        } else if (!mielialaString.matches(".*[^0-9].*")) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus) // // Ladataan alertiin liittyvät asiat stringeistä, jotta käyttö on monikielistä.
                    .setMessage(R.string.alertVainNumeroita)
                    .setPositiveButton(R.string.alertOk, (dialogInterface, i) -> {

                    })
                    .show();
        } else{

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