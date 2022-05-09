package com.example.terveyssovellusryhm8;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

/**
 * @author Tor-Erik
 *  Rentoutumisharjoitus, eli mediaplayer joka soittaa meidän rentoutumisharjoitusta.
 *  Koodia on otettu osoitteesta https://o7planning.org/12601/android-mediaplayer ja muokattu.
 */
public class Player extends Activity {
    /**
     * Soita äänitiedosto
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
