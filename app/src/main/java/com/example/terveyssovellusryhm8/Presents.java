package com.example.terveyssovellusryhm8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Presents extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentsluokka);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);  //casting to VideoView is not Strictly required above API level 26
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.start); //set the path of the video that we need to use in our VideoView
        videoView.start();  //start() method of the VideoView class will start the video to play
            TextView presentsTekstinakyma = findViewById(R.id.textView31);
            TextView presentsTekstinakyma2 = findViewById(R.id.textView32);
            presentsTekstinakyma.setText(getApplicationContext().getResources().getString(R.string.textViewPresents));
            presentsTekstinakyma2.setText(getApplicationContext().getResources().getString(R.string.textViewPresents2));
          
          Thread welcomeThread = new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    // 6 sekunnin viive
                    sleep(6000);
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



