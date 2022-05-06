package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @author Joonas
 * Luokka, jossa tulostetaan TyhjaActivity-aktiviteettiin paivakirja listojen tietoa.
 */
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

        Paivakirja paivakirja = new Paivakirja(this);

        //Näkymän numeroarvon avulla haetaan kirjauksen informaatio ja lisätään se textviewiin.
        String placeholder = getString(R.string.logi) + " " + paivakirja.getKirjausLista().get(indeksi);
        TextView tvKirjaus = findViewById(R.id.kirjausText);
        tvKirjaus.setText(placeholder);

        //Näkymän numeroarvon avulla haetaan paivamaaran informaatio ja lisätään se textviewiin.
        placeholder = getString(R.string.päivä) + " " + paivakirja.getPaivamaaraLista().get(indeksi);
        TextView tvPaiva = findViewById(R.id.paivamaaraText);
        tvPaiva.setText(placeholder);

        //Näkymän numeroarvon avulla haetaan kaloreiden informaatio ja lisätään se textviewiin.
        //Jos kalorit jätetty tyhjäksi, ei ilmoiteta arvoa kilokaloreina. Tyhjän arvo on ladattu stringeistä.
        if (paivakirja.getKaloritLista().get(indeksi).equals(getString(R.string.tyhjä))) {
            placeholder = getString(R.string.kalorit) + " " + paivakirja.getKaloritLista().get(indeksi);
        } else {
            placeholder = getString(R.string.kalorit) + " " + paivakirja.getKaloritLista().get(indeksi) + " kcal";
        }
        TextView tvKalorit = findViewById(R.id.kaloritText);
        tvKalorit.setText(placeholder);

        //Näkymän numeroarvon avulla haetaan mielialan informaatio ja lisätään se textviewiin.
        placeholder = getString(R.string.mielialaString) + " " + paivakirja.getMielialaLista().get(indeksi);
        TextView tvMieliala = findViewById(R.id.mielialaText);
        tvMieliala.setText(placeholder);

    }

    /**
     * Metodi, joka vie takaisin PaivakirjaActivity-aktiviteettin.
     * @param view metodiin liitetty floating-nappi R.id.takaisinButton
     */
    public void goBack(View view) {
        Intent intent = new Intent(this, PaivakirjaActivity.class);
        startActivity(intent);
    }

    /**
     * Metodi, joka siirtyy TyhjaActivityEditorActivity-aktiviteettiin.
     * @param view metodiin liitetty nappi R.id.muokkausButton
     */
    public void openEditor(View view) {
        Intent intent = new Intent(this, TyhjaActivityEditorActivity.class);
        intent.putExtra("indeksi", indeksi); // Mukaan indeksi, jolla editori aktiviteetti osaa navigoida listoja.
        startActivity(intent);
    }
}