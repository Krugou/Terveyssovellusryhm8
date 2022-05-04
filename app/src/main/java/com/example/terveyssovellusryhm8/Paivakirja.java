package com.example.terveyssovellusryhm8;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Paivakirja {

    private final ArrayList<String> paivamaaraLista;
    private final ArrayList<String> kaloritLista;
    private final ArrayList<String> mielialaLista;
    private final ArrayList<String> kirjausLista;
    private final Context context;

    public Paivakirja(String paivamaara, String kalorit, String mieliala, String kirjaus, Context context){

        this.context=context;
        paivamaaraLista = new ArrayList<>();
        kaloritLista = new ArrayList<>();
        mielialaLista= new ArrayList<>();
        kirjausLista = new ArrayList<>();

        paivamaaraLista.add(paivamaara);
        kaloritLista.add(kalorit);
        mielialaLista.add(mieliala);
        kirjausLista.add(kirjaus);

    }

    public Paivakirja(Context context){
        this.context=context;
        paivamaaraLista = getArrayList("paivamaaralista");
        kaloritLista = getArrayList("kaloritlista");
        mielialaLista = getArrayList("mielialalista");
        kirjausLista = getArrayList("kirjauslista");

    }

    // Metodi lisää listohihin preferencceissä olevien listojen tiedot.
    public void addPrevious(){

        // Listoihin luetaan preferencceissä olevat listat.
        ArrayList<String> paivamaaraLista2 = getArrayList("paivamaaralista");
        ArrayList<String> kaloritLista2 = getArrayList("kaloritlista");
        ArrayList<String> mielialaLista2 = getArrayList("mielialalista");
        ArrayList<String> kirjausLista2 = getArrayList("kirjauslista");

        // Lisätään listoihin kaikki merkkijonot preferenccien listoista.
        if (paivamaaraLista2 !=null){
            paivamaaraLista.addAll(paivamaaraLista2);
            kaloritLista.addAll(kaloritLista2);
            mielialaLista.addAll(mielialaLista2);
            kirjausLista.addAll(kirjausLista2);
        }
    }

    public void applyChanges(){
        saveArrayList(paivamaaraLista, "paivamaaralista");
        saveArrayList(kaloritLista, "kaloritlista");
        saveArrayList(mielialaLista, "mielialalista");
        saveArrayList(kirjausLista, "kirjauslista");
    }

    public boolean isEmpty(){
        return paivamaaraLista == null;
    }

    public void removeFromLists(int i){
        paivamaaraLista.remove(i);
        kaloritLista.remove(i);
        mielialaLista.remove(i);
        kirjausLista.remove(i);
    }
    public ArrayList<String> getPaivamaaraLista(){
        return paivamaaraLista;
    }
    public ArrayList<String> getKaloritLista(){
        return kaloritLista;
    }
    public ArrayList<String> getMielialaLista(){
        return mielialaLista;
    }
    public ArrayList<String> getKirjausLista(){
        return kirjausLista;
    }
    //Metodi, Jonka avulla preferencceihin tallennetaan Arraylistoja, listan ja avaimen parametreilla.
    public void saveArrayList(ArrayList<String> list, String key) {
        SharedPreferences prefs = this.context.getSharedPreferences("testaus41", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();
    }

    //Metodi, jonka avulla preferencceistä haetaan tallennettu Arraylista avaimen parametrilla.
    public ArrayList<String> getArrayList(String key){
        SharedPreferences prefs = this.context.getSharedPreferences("testaus41", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }
}
