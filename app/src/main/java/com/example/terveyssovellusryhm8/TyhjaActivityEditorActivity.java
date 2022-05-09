package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * @author Joonas
 * Luokka, jossa jonkin tietyn päiväkirja lisäyksen dataa muokataan.
 */
public class TyhjaActivityEditorActivity extends AppCompatActivity {

    // Näillä päästään käsiksi EditText-näkymiin.
    private EditText paivamaaraEdit;
    private EditText kaloritEdit;
    private EditText mieliaalaEdit;
    private EditText kirjausEdit;

    private DatePickerDialog picker;

    private Paivakirja paivakirja;
    // Globaali indeksi muuttuja.
    private int indeksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tyhja_editor);

        paivakirja = new Paivakirja(this);

        // Otetaan vastaan intentin lähettämä numeroarvo. Tallennetaan se indeksi muuttujaan.
        Intent intent = getIntent();
        indeksi = intent.getIntExtra("indeksi", -1);

        // Liitetään muuttujat EditTexteihin.
        paivamaaraEdit = findViewById(R.id.editPaiva);
        kaloritEdit = findViewById(R.id.editKalorit);
        mieliaalaEdit = findViewById(R.id.editMieliala);
        kirjausEdit = findViewById(R.id.editKirjaus);

        // Syötetään EditTexteihin arvoiksi listalta löytyvät merkkijonot indeksi muuttujan avulla.
        paivamaaraEdit.setText(paivakirja.getPaivamaaraLista().get(indeksi));
        kaloritEdit.setText(paivakirja.getKaloritLista().get(indeksi));
        mieliaalaEdit.setText(paivakirja.getMielialaLista().get(indeksi));
        kirjausEdit.setText(paivakirja.getKirjausLista().get(indeksi));

        paivamaaraEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                paivamaaraEdit.setInputType(InputType.TYPE_NULL);
                // date picker dialog
                picker = new DatePickerDialog(TyhjaActivityEditorActivity.this,
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
                                paivamaaraEdit.setText(day + "." + month + "." + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

    }

    /**
     * Metodi, jolla tallennetaan päiväkirja dataan muutokset.
     * @param view Tallenna napin näkymä. R.id.buttonTallenna
     */
    public void saveEdits(View view) {
        String editoituPaivamaara = paivamaaraEdit.getText().toString();

        // Tallennetaan käyttäjän syöttämät arvot merkkijonoihin
        String editoituKalori = kaloritEdit.getText().toString();
        String editoituMieliala = mieliaalaEdit.getText().toString();
        String editoituKirjaus = kirjausEdit.getText().toString();

        // Jos päivämäärä puuttuu lähetetään käyttäjälle ilmoitus, joka käskee täyttää sen.
        if (editoituPaivamaara.equals("")) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus) // Ladataan alertiin liittyvät asiat stringeistä, jotta käyttö on monikielistä.
                    .setMessage(R.string.alertViesti)
                    .setPositiveButton(R.string.alertOk, (dialogInterface, i) -> {
                    })
                    .show();
        }
        else if (editoituMieliala.equals("") && editoituKirjaus.equals("")) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus) // // Ladataan alertiin liittyvät asiat stringeistä, jotta käyttö on monikielistä.
                    .setMessage(R.string.etVastannutAlert)
                    .setPositiveButton(R.string.alertOk, (dialogInterface, i) -> {

                    })
                    .show();
        } else if (!editoituMieliala.matches(".*[^0-9].*")) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus) // // Ladataan alertiin liittyvät asiat stringeistä, jotta käyttö on monikielistä.
                    .setMessage(R.string.alertVainNumeroita)
                    .setPositiveButton(R.string.alertOk, (dialogInterface, i) -> {

                    })
                    .show();
        } else {
            // Jos käyttäjä ei syöttänyt joitain arvoja, niihin merkitään arvo "tyhjä" joka ladataan stringeistä. Huom. monikielisyys.
            if (editoituKalori.equals("")) {
                editoituKalori = getString(R.string.tyhjä);
            }
            if (editoituMieliala.equals("")) {
                editoituMieliala = getString(R.string.tyhjä);
            }
            if (editoituKirjaus.equals("")) {
                editoituKirjaus = getString(R.string.tyhjä);
            }

            // Listojen indeksi muuttujan osoittamaan alkioon muokataan käyttäjän syöttämät arvot.
            paivakirja.getPaivamaaraLista().set(indeksi, editoituPaivamaara);
            paivakirja.getKaloritLista().set(indeksi, editoituKalori);
            paivakirja.getMielialaLista().set(indeksi, editoituMieliala);
            paivakirja.getKirjausLista().set(indeksi, editoituKirjaus);

            paivakirja.applyChanges();

            // Mennään takaisin päiväkirja-aktiviteettiin
            Intent intent = new Intent(this, PaivakirjaActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Metodi, jolla siirrytään TyhjaActivityyn.
     * @param view floating-napin näkymä. R.id.buttonTakaisinTyhjaEditor
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, TyhjaActivity.class);
        intent.putExtra("nro", indeksi); // Mukaan indeksi, jonka avulla TyhjaActivity hakee infot listoista.
        startActivity(intent);
    }
}