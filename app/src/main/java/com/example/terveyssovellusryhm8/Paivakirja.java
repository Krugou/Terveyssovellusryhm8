package com.example.terveyssovellusryhm8;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author Joonas
 * Luokka sisältää päiväkirjan käyttämät listat ja ylläpitää niiden tallennusta SharedPreferencceihin
 */
public class Paivakirja {
    /** Lista, johon tallennetaan päivämäärät */
    private final ArrayList<String> paivamaaraLista;
    /** Lista, johon tallennetaan kalorit */
    private final ArrayList<String> kaloritLista;
    /** Lista, johon tallennetaan mielialat */
    private final ArrayList<String> mielialaLista;
    /** Lista, johon tallennetaan kirjaukset */
    private final ArrayList<String> kirjausLista;
    /** Context, johon tallennetaan applikaation contexti */
    private final Context context;

    /**
     * Konstruktori, joka tekee uuden lisäyksen päiväkirja listoihin.
     * @param paivamaara merkkijono, joka lisätään paivamaaraListaan.
     * @param kalorit    merkkijono, joka listään kaloritListaan.
     * @param mieliala   merkkijono, joka lisätään mielialaListaan.
     * @param kirjaus    merkkijono, joka lisätään kirjausListaan.
     * @param context    contexti, joka tallennetaan context muuttujaan.
     */
    public Paivakirja(String paivamaara, String kalorit, String mieliala, String kirjaus, Context context) {

        this.context = context;
        paivamaaraLista = new ArrayList<>();
        kaloritLista = new ArrayList<>();
        mielialaLista = new ArrayList<>();
        kirjausLista = new ArrayList<>();

        paivamaaraLista.add(paivamaara);
        kaloritLista.add(kalorit);
        mielialaLista.add(mieliala);
        kirjausLista.add(kirjaus);

    }

    /**
     * Konstruktori, jolla päästään ainoastaan käsiksi luokan metodeihin.
     * @param context contexti, joka tallennetaan context muuttujaan.
     */
    public Paivakirja(Context context) {
        this.context = context;
        paivamaaraLista = getArrayList("paivamaaralista");
        kaloritLista = getArrayList("kaloritlista");
        mielialaLista = getArrayList("mielialalista");
        kirjausLista = getArrayList("kirjauslista");

    }

    /**
     * Metodi lisää listohin preferencceissä olevien listojen tiedot.
     */
    public void addPrevious() {

        // Listoihin luetaan preferencceissä olevat listat.
        ArrayList<String> paivamaaraLista2 = getArrayList("paivamaaralista");
        ArrayList<String> kaloritLista2 = getArrayList("kaloritlista");
        ArrayList<String> mielialaLista2 = getArrayList("mielialalista");
        ArrayList<String> kirjausLista2 = getArrayList("kirjauslista");

        // Lisätään listoihin kaikki merkkijonot preferenccien listoista.
        if (paivamaaraLista2 != null) {
            paivamaaraLista.addAll(paivamaaraLista2);
            kaloritLista.addAll(kaloritLista2);
            mielialaLista.addAll(mielialaLista2);
            kirjausLista.addAll(kirjausLista2);
        }
    }

    /**
     * Metodi, jolla kutsutaan saveArrayList-metodia kaikilla listoilla.
     */
    public void applyChanges() {
        saveArrayList(paivamaaraLista, "paivamaaralista");
        saveArrayList(kaloritLista, "kaloritlista");
        saveArrayList(mielialaLista, "mielialalista");
        saveArrayList(kirjausLista, "kirjauslista");
    }

    /**
     * Metodi, joka tarkistaa, onko paivamaaraLista tyhjä.
     * @return palauttaa boolean arvon
     */
    public boolean isEmpty() {
        return paivamaaraLista == null;
    }

    /**
     * Metodi, joka poistaa listoista alkioita.
     *
     * @param i alkion numero, joka poistetaan.
     */
    public void removeFromLists(int i) {
        paivamaaraLista.remove(i);
        kaloritLista.remove(i);
        mielialaLista.remove(i);
        kirjausLista.remove(i);
    }

    /**
     * Getteri paivamaaraListalle
     * @return palauttaa paivamaaraListan
     */
    public ArrayList<String> getPaivamaaraLista() {
        return paivamaaraLista;
    }

    /**
     * Getteri kaloritListalle
     * @return palauttaa kaloritListan
     */
    public ArrayList<String> getKaloritLista() {
        return kaloritLista;
    }

    /**
     * Getteri mielialaListalle
     * @return palauttaa mielialaListan
     */
    public ArrayList<String> getMielialaLista() {
        return mielialaLista;
    }

    /**
     * Getteri kirjausListalle
     * @return palauttaa kirjausListan
     */
    public ArrayList<String> getKirjausLista() {
        return kirjausLista;
    }

    /**
     * Metodi, jolla tallennetaan ArrayListoja SharedPreferencceihin
     * @param list lista, joka halutaan tallentaa
     * @param key  arvoa vastaava avain
     */

    //Koodi on kopioitu:https://gist.github.com/WrathChaos/5f39e3ce3874a049d25e2ca8958d18b6
    public void saveArrayList(ArrayList<String> list, String key) {
        SharedPreferences prefs = this.context.getSharedPreferences("com.example.terveyssovellusryhm8", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    /**
     * Hakee SharedPreferencceistä ArrayListan.
     * @param key avain, joka vastaa listaa.
     * @return palauttaa ArrayListan.
     */
//Metodi, jonka avulla preferencceistä haetaan tallennettu Arraylista avaimen parametrilla.
    // Koodi on kopioitu: https://gist.github.com/WrathChaos/5f39e3ce3874a049d25e2ca8958d18b6
    public ArrayList<String> getArrayList(String key) {
        SharedPreferences prefs = this.context.getSharedPreferences("com.example.terveyssovellusryhm8", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
