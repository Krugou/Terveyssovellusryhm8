package com.example.terveyssovellusryhm8;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * The type Paivakirja.
 */
public class Paivakirja {

    private final ArrayList<String> paivamaaraLista;
    private final ArrayList<String> kaloritLista;
    private final ArrayList<String> mielialaLista;
    private final ArrayList<String> kirjausLista;
    private final Context context;

    /**
     * Instantiates a new Paivakirja.
     *
     * @param paivamaara the paivamaara
     * @param kalorit    the kalorit
     * @param mieliala   the mieliala
     * @param kirjaus    the kirjaus
     * @param context    the context
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
     * Instantiates a new Paivakirja.
     *
     * @param context the context
     */
    public Paivakirja(Context context) {
        this.context = context;
        paivamaaraLista = getArrayList("paivamaaralista");
        kaloritLista = getArrayList("kaloritlista");
        mielialaLista = getArrayList("mielialalista");
        kirjausLista = getArrayList("kirjauslista");

    }

    /**
     * Add previous.
     */
// Metodi lisää listohihin preferencceissä olevien listojen tiedot.
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
     * Apply changes.
     */
    public void applyChanges() {
        saveArrayList(paivamaaraLista, "paivamaaralista");
        saveArrayList(kaloritLista, "kaloritlista");
        saveArrayList(mielialaLista, "mielialalista");
        saveArrayList(kirjausLista, "kirjauslista");
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return paivamaaraLista == null;
    }

    /**
     * Remove from lists.
     *
     * @param i the
     */
    public void removeFromLists(int i) {
        paivamaaraLista.remove(i);
        kaloritLista.remove(i);
        mielialaLista.remove(i);
        kirjausLista.remove(i);
    }

    /**
     * Gets paivamaara lista.
     *
     * @return the paivamaara lista
     */
    public ArrayList<String> getPaivamaaraLista() {
        return paivamaaraLista;
    }

    /**
     * Gets kalorit lista.
     *
     * @return the kalorit lista
     */
    public ArrayList<String> getKaloritLista() {
        return kaloritLista;
    }

    /**
     * Gets mieliala lista.
     *
     * @return the mieliala lista
     */
    public ArrayList<String> getMielialaLista() {
        return mielialaLista;
    }

    /**
     * Gets kirjaus lista.
     *
     * @return the kirjaus lista
     */
    public ArrayList<String> getKirjausLista() {
        return kirjausLista;
    }

    /**
     * Save array list.
     *
     * @param list the list
     * @param key  the key
     */
//Metodi, Jonka avulla preferencceihin tallennetaan Arraylistoja, listan ja avaimen parametreilla.
    public void saveArrayList(ArrayList<String> list, String key) {
        SharedPreferences prefs = this.context.getSharedPreferences("testaus41", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    /**
     * Gets array list.
     *
     * @param key the key
     * @return the array list
     */
//Metodi, jonka avulla preferencceistä haetaan tallennettu Arraylista avaimen parametrilla.
    public ArrayList<String> getArrayList(String key) {
        SharedPreferences prefs = this.context.getSharedPreferences("testaus41", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
