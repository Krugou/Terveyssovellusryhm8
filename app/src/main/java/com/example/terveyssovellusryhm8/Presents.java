package com.example.terveyssovellusryhm8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Aleksi
 */
public class Presents extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentsluokka);
        // alkuvideo
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.start);
        // alkuvideon käynnistys
        videoView.start();
        // tekstinäkymät
            TextView presentsTekstinakyma = findViewById(R.id.textView31);
            TextView presentsTekstinakyma2 = findViewById(R.id.textView32);
            presentsTekstinakyma.setText(getApplicationContext().getResources().getString(R.string.textViewPresents));
            presentsTekstinakyma2.setText(getApplicationContext().getResources().getString(R.string.textViewPresents2));
          
          Thread tervetulosLanka = new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    // 6 sekunnin viive
                    sleep(6000);
                } catch (Exception e) {

                } finally {

                    Intent seuraavaluokka = new Intent(Presents.this,
                            Aloitusluokka.class);
                    startActivity(seuraavaluokka);
                    finish();
                }
            }
        };
        tervetulosLanka.start();
    }

}



