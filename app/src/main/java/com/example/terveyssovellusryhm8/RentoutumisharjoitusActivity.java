package com.example.terveyssovellusryhm8;

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

/**
 * @author Tor-Erik
 * Rentoutumisharjoitus, eli mediaplayer joka soittaa meidän rentoutumisharjoitusta.
 * Koodia on otettu osoitteesta https://o7planning.org/12601/android-mediaplayer ja muokattu.
 */
public class RentoutumisharjoitusActivity extends AppCompatActivity {

    private Button buttonStart, buttonStop, buttonPause;
    private SeekBar seekBar;
    private TextView current, duration;
    private Handler threadHandler = new Handler();
    private MediaPlayer mediaPlayer;

    @Override
    public void onStop() {
        super.onStop();
        if (this.mediaPlayer.isPlaying()) {
            doPause();
        }
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        if (this.mediaPlayer.isPlaying()) {
            doPause();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentoutumisharjoitus);

        this.duration=(TextView)this.findViewById(R.id.duration);
        this.current=(TextView)this.findViewById(R.id.current);

        this.buttonStart=(Button)this.findViewById(R.id.playButton);
        this.buttonStop=(Button)this.findViewById(R.id.stopButton);
        this.buttonPause=(Button)this.findViewById(R.id.pauseButton);
        this.buttonStop.setEnabled(false);
        this.buttonStart.setEnabled(true);
        this.buttonPause.setEnabled(true);

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
        this.buttonStop.setEnabled(true);
        this.buttonPause.setEnabled(true);
        this.buttonStart.setEnabled(false);
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
            this.mediaPlayer.reset();

            this.buttonStop.setEnabled(false);
            this.buttonStart.setEnabled(true);
            this.buttonPause.setEnabled(true);
            Player.playRawMedia(this, this.mediaPlayer);
        }
    }
    private void doPause(){
        this.mediaPlayer.pause();
        this.buttonPause.setEnabled(false);
        this.buttonStart.setEnabled(true);
    }

    private void doComplete() {
        this.mediaPlayer.reset();

        this.buttonStop.setEnabled(false);
        this.buttonStart.setEnabled(true);
        this.buttonPause.setEnabled(true);

        Player.playRawMedia(this, this.mediaPlayer);
    }

    // Convert millisecond to string.
    // There was a bug in the original tutorial, it didn't remove the seconds
    // if there was more than 60 seconds, so I fixed it.
    // It's a bubblegum fix but it works and I'm out of time.
    private String millisecondsToString(int milliseconds)  {
        int minutes = (int) TimeUnit.MILLISECONDS.toMinutes(milliseconds);
        int seconds = (int) TimeUnit.MILLISECONDS.toSeconds(milliseconds);
        for (int i = minutes; i > 0; i--){
            seconds = seconds-60;
        }
        if (seconds < 10 ){
            return minutes + ":" + "0" + seconds;
        }

        return minutes + ":"+ seconds;
    }

    /**
     * Luokka SeekBarin päivittämiseen
     */
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

    /**
     * Mee kotiin
     *
     * @param view the view
     */
    public void goHome(View view){
        finish();
    }

}
