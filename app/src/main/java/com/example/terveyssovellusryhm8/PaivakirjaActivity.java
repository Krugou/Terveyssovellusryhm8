package com.example.terveyssovellusryhm8;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class PaivakirjaActivity extends AppCompatActivity {
    private ArrayList<String>paivamaaraLista=new ArrayList<>();
    private ArrayList<String>kaloritLista = new ArrayList<>();
    private ArrayList<String>mielialaLista = new ArrayList<>();
    private ArrayList<String>kirjausLista = new ArrayList<>();

    private ArrayAdapter<String> listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paivakirja);


    }

    public void openDiaryEditor(View view){

        Intent intent = new Intent(this, PaivakirjaLisaysActivity.class);

        startActivity(intent);
    }
    public void openHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart(){
        super.onStart();

        if(this.getArrayList("paivamaaralista")!=null) {

            paivamaaraLista = this.getArrayList("paivamaaralista");
            kaloritLista = this.getArrayList("kaloritlista");
            mielialaLista = this.getArrayList("mielialalista");
            kirjausLista = this.getArrayList("kirjauslista");
        }



        ListView lv = findViewById(R.id.paivakirjaLista);
        if (paivamaaraLista!=null) {

            this.listAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    paivamaaraLista);
            lv.setAdapter(this.listAdapter);


            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getApplicationContext(), tyhjaActivity.class);
                    intent.putExtra("nro", i);
                    startActivity(intent);
                }
            });
        }


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int poistettava = i;
                Log.d("MYAPP", "ASD");

                new AlertDialog.Builder(PaivakirjaActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Varmistus")
                        .setMessage("Haluatko poistaa lisäyksen")
                        .setPositiveButton("Kyllä", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                paivamaaraLista.remove(poistettava);
                                kaloritLista.remove(poistettava);
                                mielialaLista.remove(poistettava);
                                kirjausLista.remove(poistettava);

                                listAdapter.notifyDataSetChanged();

                                saveArrayList(paivamaaraLista, "paivamaaralista");
                                saveArrayList(kaloritLista, "kaloritlista");
                                saveArrayList(mielialaLista, "mielialalista");
                                saveArrayList(kirjausLista, "kirjauslista");

                            }
                        })
                        .setNegativeButton("Ei", null)
                        .show();

                return true;
            }

        });

    }

    public void saveArrayList(ArrayList<String> list, String key){
        SharedPreferences prefs = getApplication().getSharedPreferences("testaus20", Context.MODE_PRIVATE);;
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public ArrayList<String> getArrayList(String key){
        SharedPreferences prefs = getApplication().getSharedPreferences("testaus20", Context.MODE_PRIVATE);;
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, type);
    }

}