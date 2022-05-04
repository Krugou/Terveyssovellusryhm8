package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TyhjaActivityEditorActivity extends AppCompatActivity {

    // Näillä päästään käsiksi EditText-näkymiin.
    private EditText paivamaaraEdit;
    private EditText kaloritEdit;
    private EditText mieliaalaEdit;
    private EditText kirjausEdit;

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


    }

    // Tätä kutsutaan, kun Tallenna-nappia painetaan.
    public void saveEdits(View view) {
        boolean ready;
        String editoituPaivamaara = paivamaaraEdit.getText().toString();

        // Jos päivämäärä puuttuu lähetetään käyttäjälle ilmoitus, joka käskee täyttää sen.
        if (editoituPaivamaara.equals("")) {
            ready = false;
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus) // Ladataan alertiin liittyvät asiat stringeistä, jotta käyttö on monikielistä.
                    .setMessage(R.string.alertViesti)
                    .setPositiveButton(R.string.alertOk, (dialogInterface, i) -> {
                    })
                    .show();
        } else {
            ready = true;
        }
        if (ready) {

            // Tallennetaan käyttäjän syöttämät arvot merkkijonoihin
            String editoituKalori = kaloritEdit.getText().toString();
            String editoituMieliala = mieliaalaEdit.getText().toString();
            String editoituKirjaus = kirjausEdit.getText().toString();

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

    // Metodi, joka vie takaisin TyhjaActivityyn.
    public void goBack(View view) {
        Intent intent = new Intent(this, TyhjaActivity.class);
        intent.putExtra("nro", indeksi); // Mukaan indeksi, jonka avulla TyhjaActivity hakee infot listoista.
        startActivity(intent);
    }
}