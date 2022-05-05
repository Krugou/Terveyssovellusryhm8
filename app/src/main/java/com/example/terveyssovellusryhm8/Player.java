package com.example.terveyssovellusryhm8;



import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;


/**
 * The type Player.
 */
public class Player extends Activity {

    //private MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.rentoutumisharjoitusmusiconly);


    /**
     * Play raw media.
     *
     * @param context     the context
     * @param mediaPlayer the media player
     */
    public static void playRawMedia(Context context, MediaPlayer mediaPlayer){
        try{
            Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.rentoutumisharjoitus);
            mediaPlayer.setDataSource(context, uri);
            mediaPlayer.prepareAsync();

        }catch(Exception e){
            System.out.println("Media play error " + e);
        }
    }
}
