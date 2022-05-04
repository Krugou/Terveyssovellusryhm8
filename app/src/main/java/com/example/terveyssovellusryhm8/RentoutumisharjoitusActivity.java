package com.example.terveyssovellusryhm8;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.TimeUnit;

// A lot of code has been taken from
// https://o7planning.org/12601/android-mediaplayer
// and modified by us

public class RentoutumisharjoitusActivity extends AppCompatActivity {

    private Button buttonStart;
    private Button buttonStop;
    private Button buttonPause;
    private SeekBar seekBar;

    private TextView current;
    private TextView duration;

    private Handler threadHandler = new Handler();

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentoutumisharjoitus);

        this.duration=(TextView)this.findViewById(R.id.duration);
        this.current=(TextView)this.findViewById(R.id.current);

        this.buttonStart=(Button)this.findViewById(R.id.playButton);
        this.buttonStop=(Button)this.findViewById(R.id.stopButton);
        this.buttonPause=(Button)this.findViewById(R.id.pauseButton);

        this.seekBar=(SeekBar) this.findViewById(R.id.seekBar);
        this.seekBar.setClickable(false);

        this.buttonStart.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){

               doStart();
           }
        });
        this.buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPause();
            }
        });
        this.buttonStop.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               doStop();
           }
        });

        // Mediaplayer
        this.mediaPlayer = new MediaPlayer();
        // The line below is taken from Android tutorials
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );

        this.mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                doStop(); // Stop current media.
            }
        });

        this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                doComplete();
            }
        });
        Player.playRawMedia(this, this.mediaPlayer);
    }
    // OnCreate ends here

    private void doStart(){
        if (this.mediaPlayer.isPlaying()) {
            return;
        }

        // duration in milliseconds
        int duration = this.mediaPlayer.getDuration();

        int currentPosition = this.mediaPlayer.getCurrentPosition();

        if(currentPosition==0){
            this.seekBar.setMax(duration);
            this.duration.setText(this.millisecondsToString(duration));
        }else if(currentPosition== duration) {
            // Resets the MediaPlayer to its uninitialized state.
            this.mediaPlayer.reset();
        }
        this.mediaPlayer.start();
        // Create a thread to update position of SeekBar.
        UpdateSeekBarThread updateSeekBarThread= new UpdateSeekBarThread();
        threadHandler.postDelayed(updateSeekBarThread,50);
    }

    private void doStop(){
        if(this.mediaPlayer.isPlaying()) {
            this.mediaPlayer.stop();
        }
    }
    private void doPause(){
        this.mediaPlayer.pause();
        this.buttonPause.setEnabled(false);
        this.buttonStart.setEnabled(true);
    }

    private void doComplete() {

    }

    // Convert millisecond to string.
    private String millisecondsToString(int milliseconds)  {
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) milliseconds);
        long seconds =  TimeUnit.MILLISECONDS.toSeconds((long) milliseconds) ;
        return minutes + ":"+ seconds;
    }

    // Thread to Update position for SeekBar.
    class UpdateSeekBarThread implements Runnable {

        public void run()  {
            int currentPosition = mediaPlayer.getCurrentPosition();
            String currentPositionStr = millisecondsToString(currentPosition);
            current.setText(currentPositionStr);

            seekBar.setProgress(currentPosition);
            // Delay thread 50 milisecond.
            threadHandler.postDelayed(this, 50);
        }
    }
    public void goHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
