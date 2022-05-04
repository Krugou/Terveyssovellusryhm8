package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PaivakirjaActivity extends AppCompatActivity {

    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);
    }

    //Metodi, joka siirtää lisäys aktiviteettiin napin painalluksella.
    public void openDiaryEditor(View view) {
        Intent intent = new Intent(this, PaivakirjaLisaysActivity.class);
        intent.putExtra("viimeactivity", 2); // Viedään mukana numero, joka kertoo mistä aktiviteetista tultiin.
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

            //Tehdään alertti, joka varmistaa käyttäjän poistamisen.
            new AlertDialog.Builder(PaivakirjaActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle(R.string.alertVaroitus)
                    .setMessage(R.string.alertPoistoViesti)

                    // Jos käyttäjä valitsee "Kyllä", listoista poistetaan longclickatun näkymän tiedot.
                    .setPositiveButton(R.string.alertKyllä, (dialogInterface, i1) -> {

                        paivakirja.removeFromLists(poistettava);
                        paivakirja.applyChanges();
                        listAdapter.notifyDataSetChanged(); //Kerrotaan adapterille, että data on muuttunut.

                    })
                    // Jos käyttäjä valitsee "Ei", mitään ei tapahdu.
                    .setNegativeButton(R.string.alertEi, null)
                    .show();

            return true;
        });

    }
}