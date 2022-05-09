package com.example.terveyssovellusryhm8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @author Tor-Erik
 * Luokka sisältää vastaukset RBDI-mielialakyselyyn
 */
public class MielialaVastausActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mieliala_vastaus);
        TextView ptsView = findViewById(R.id.points);
        TextView resultView = findViewById(R.id.selitys);

        Intent intent = getIntent();
        int[] points = intent.getIntArrayExtra(com.example.terveyssovellusryhm8.MielialakyselyActivity.EXTRA_MESSAGE);
        int results = totalValue(points);

        ptsView.setText(Integer.toString(results));

        if (results < 4){
            resultView.setText(R.string.depression1);
        } else if (results < 7){
            resultView.setText(R.string.depression2);
        } else if (results < 15){
            resultView.setText(R.string.depression3);
        } else {
            resultView.setText(R.string.depression4);
        }

    }

    /**
     * Total value int.
     * Luokka laskee yhteen taulukkoon tallennetut pisteet
     * @param points the points
     * @return the int
     */
    public int totalValue(int[] points){

        int totalValue = 0;
        for (int point : points) {
            totalValue += point;
        }
        return totalValue;
    }

    /**
     * Go home.
     *
     * @param view the view
     */
    public void goHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}