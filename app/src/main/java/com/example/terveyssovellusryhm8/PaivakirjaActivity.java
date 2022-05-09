package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author Joonas
 * Luokka PaivakirjaActivity-aktiviteetille, jossa ylläpidetään päiväkirjan etusivu näkymää.
 */
public class PaivakirjaActivity extends AppCompatActivity {

    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);
    }

    /**
     * Metodi siirtää PaivakirjaLisaysActivity-aktiviteettiin.
     * @param view floating-nappi. R.id.uusiLisaysButton
     */
    public void openDiaryEditor(View view) {
        Intent intent = new Intent(this, PaivakirjaLisaysActivity.class);
        startActivity(intent);
    }

    /**
     * Metodi siirtää aloitussivulle napin painalluksella.
     * @param view floating nappi. R.id.palaakotiinButton
     */
    public void openHome(View view) {
        navigateUpTo(new Intent(getBaseContext(), MainActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView paivakirjaLista = findViewById(R.id.paivakirjaLista);
        Paivakirja paivakirja = new Paivakirja(this);

        // Tarkistetaan ettei listat ole tyhjiä, ennenkuin näytetään listview.
        if (!paivakirja.isEmpty()) {

            // Listview saa adapterin listaan, jossa on päivämäärät.
            this.listAdapter = new ArrayAdapter<>(
                    this,
                    R.layout.listviewtext,
                    paivakirja.getPaivamaaraLista());
            paivakirjaLista.setAdapter(this.listAdapter);

            // Asetetaan listan näkymille kuuntelija, joka vie painalluksen jälkeen uuteen aktiviteettiin.
            paivakirjaLista.setOnItemClickListener((adapterView, view, i, l) -> {
                Intent intent = new Intent(getApplicationContext(), TyhjaActivity.class);
                intent.putExtra("nro", i); //Viedään extrana painetun viewin numeroarvo.
                startActivity(intent);
            });
        }

        //Asetetaan listviewille longclick-kuuntelija, jolla poisetetaan listasta lisäyksiä.
        paivakirjaLista.setOnItemLongClickListener((adapterView, view, i, l) -> {
            final int poistettava = i; //Tallennetaan longclickatun näkymän arvo.

            //Tehdään alertti, joka varmistaa käyttäjältä lisäyksen poistamisen.
            new AlertDialog.Builder(PaivakirjaActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus)
                    .setMessage(R.string.alertPoistoViesti)

                    // Jos käyttäjä valitsee "Kyllä", listoista poistetaan longclickatun näkymän tiedot.
                    .setPositiveButton(R.string.alertKyllä, (dialogInterface, i1) -> {

                        paivakirja.removeFromLists(poistettava);
                        paivakirja.applyChanges();
                        listAdapter.notifyDataSetChanged();

                    })
                    .setNegativeButton(R.string.alertEi, null)
                    .show();

            return true;
        });

    }
}