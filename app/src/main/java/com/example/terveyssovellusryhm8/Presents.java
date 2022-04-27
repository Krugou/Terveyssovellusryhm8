package com.example.terveyssovellusryhm8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Presents extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentsluokka);
        
            TextView presentsTekstinakyma = findViewById(R.id.textView31);
            TextView presentsTekstinakyma2 = findViewById(R.id.textView32);
            presentsTekstinakyma.setText(getApplicationContext().getResources().getString(R.string.textViewPresents));
            presentsTekstinakyma2.setText(getApplicationContext().getResources().getString(R.string.textViewPresents2));
          
          Thread welcomeThread = new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    // 3 sekunnin viive
                    sleep(3000);
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(Presents.this,
                            Aloitusluokka.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }

}



