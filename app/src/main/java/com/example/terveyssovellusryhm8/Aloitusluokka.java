package com.example.terveyssovellusryhm8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Aloitusluokka extends AppCompatActivity {
    boolean ensimmaistaKertaaKayttamassa;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_aloitusluokka);
            Positiivisetsanatlistaoffline.positivisetSanatListaLuontiOffline();
            TextView aloitusTekstinakyma = (TextView) findViewById(R.id.textView21);
            TextView aloitusTekstinakyma2 = (TextView) findViewById(R.id.textView22);
           TextView aloitusTekstinakyma3 = (TextView) findViewById(R.id.textView23);
            if (!ensimmaistaKertaaKayttamassa){
                aloitusTekstinakyma.setText(getApplicationContext().getResources().getString(R.string.textViewAloitusEka));
                aloitusTekstinakyma2.setText(getApplicationContext().getResources().getString(R.string.textViewAloitusToka));
                ensimmaistaKertaaKayttamassa = true;
            } else {
                aloitusTekstinakyma.setText(R.string.textViewAloitusVanha);
                aloitusTekstinakyma2.setText(R.string.textViewAloitusVanha2);
                
            }
            aloitusTekstinakyma3.setText(Positiivisetsanat.getPositiivisetSanat() + " \n"+" -"+ Positiivisetsanat.getPositiivisetSanatTekija());
            Thread welcomeThread = new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    // 7 sekunnin viive
                    sleep(7000);
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(Aloitusluokka.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }

}

