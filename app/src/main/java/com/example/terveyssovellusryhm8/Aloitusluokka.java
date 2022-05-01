package com.example.terveyssovellusryhm8;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Aloitusluokka extends AppCompatActivity {
    boolean ensimmaistaKertaaKayttamassa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aloitusluokka);

        // Luodaan lista positiivisista lauseista ja tekijöistä
        ArrayList<Positiivisetsanat> positivisetSanatLista = new ArrayList<>();
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti1), getApplicationContext().getResources().getString(R.string.Lainaustekija1)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti2), getApplicationContext().getResources().getString(R.string.Lainaustekija2)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti3), getApplicationContext().getResources().getString(R.string.Lainaustekija3)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti4), getApplicationContext().getResources().getString(R.string.Lainaustekija4)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti5), getApplicationContext().getResources().getString(R.string.Lainaustekija5)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti6), getApplicationContext().getResources().getString(R.string.Lainaustekija6)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti7), getApplicationContext().getResources().getString(R.string.Lainaustekija7)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti8), getApplicationContext().getResources().getString(R.string.Lainaustekija8)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti9), getApplicationContext().getResources().getString(R.string.Lainaustekija9)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti10), getApplicationContext().getResources().getString(R.string.Lainaustekija10)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti11), getApplicationContext().getResources().getString(R.string.Lainaustekija11)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti12), getApplicationContext().getResources().getString(R.string.Lainaustekija12)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti13), getApplicationContext().getResources().getString(R.string.Lainaustekija13)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti14), getApplicationContext().getResources().getString(R.string.Lainaustekija14)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti15), getApplicationContext().getResources().getString(R.string.Lainaustekija15)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti16), getApplicationContext().getResources().getString(R.string.Lainaustekija16)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti17), getApplicationContext().getResources().getString(R.string.Lainaustekija17)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti18), getApplicationContext().getResources().getString(R.string.Lainaustekija18)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti19), getApplicationContext().getResources().getString(R.string.Lainaustekija19)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti20), getApplicationContext().getResources().getString(R.string.Lainaustekija20)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti21), getApplicationContext().getResources().getString(R.string.Lainaustekija21)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti22), getApplicationContext().getResources().getString(R.string.Lainaustekija22)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti23), getApplicationContext().getResources().getString(R.string.Lainaustekija23)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti24), getApplicationContext().getResources().getString(R.string.Lainaustekija24)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti25), getApplicationContext().getResources().getString(R.string.Lainaustekija25)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti26), getApplicationContext().getResources().getString(R.string.Lainaustekija26)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti27), getApplicationContext().getResources().getString(R.string.Lainaustekija27)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti28), getApplicationContext().getResources().getString(R.string.Lainaustekija28)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti29), getApplicationContext().getResources().getString(R.string.Lainaustekija29)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti30), getApplicationContext().getResources().getString(R.string.Lainaustekija30)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti31), getApplicationContext().getResources().getString(R.string.Lainaustekija31)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti32), getApplicationContext().getResources().getString(R.string.Lainaustekija32)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti33), getApplicationContext().getResources().getString(R.string.Lainaustekija33)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti34), getApplicationContext().getResources().getString(R.string.Lainaustekija34)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti35), getApplicationContext().getResources().getString(R.string.Lainaustekija35)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti36), getApplicationContext().getResources().getString(R.string.Lainaustekija36)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti37), getApplicationContext().getResources().getString(R.string.Lainaustekija37)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti38), getApplicationContext().getResources().getString(R.string.Lainaustekija38)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti39), getApplicationContext().getResources().getString(R.string.Lainaustekija39)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti40), getApplicationContext().getResources().getString(R.string.Lainaustekija40)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti41), getApplicationContext().getResources().getString(R.string.Lainaustekija41)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti42), getApplicationContext().getResources().getString(R.string.Lainaustekija42)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti43), getApplicationContext().getResources().getString(R.string.Lainaustekija43)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti44), getApplicationContext().getResources().getString(R.string.Lainaustekija44)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti45), getApplicationContext().getResources().getString(R.string.Lainaustekija45)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti46), getApplicationContext().getResources().getString(R.string.Lainaustekija46)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti47), getApplicationContext().getResources().getString(R.string.Lainaustekija47)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti48), getApplicationContext().getResources().getString(R.string.Lainaustekija48)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti49), getApplicationContext().getResources().getString(R.string.Lainaustekija49)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti50), getApplicationContext().getResources().getString(R.string.Lainaustekija50)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti51), getApplicationContext().getResources().getString(R.string.Lainaustekija51)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti52), getApplicationContext().getResources().getString(R.string.Lainaustekija52)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti53), getApplicationContext().getResources().getString(R.string.Lainaustekija53)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti54), getApplicationContext().getResources().getString(R.string.Lainaustekija54)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti55), getApplicationContext().getResources().getString(R.string.Lainaustekija55)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti56), getApplicationContext().getResources().getString(R.string.Lainaustekija56)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti57), getApplicationContext().getResources().getString(R.string.Lainaustekija57)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti58), getApplicationContext().getResources().getString(R.string.Lainaustekija58)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti59), getApplicationContext().getResources().getString(R.string.Lainaustekija59)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti60), getApplicationContext().getResources().getString(R.string.Lainaustekija60)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti61), getApplicationContext().getResources().getString(R.string.Lainaustekija61)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti62), getApplicationContext().getResources().getString(R.string.Lainaustekija62)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti63), getApplicationContext().getResources().getString(R.string.Lainaustekija63)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti64), getApplicationContext().getResources().getString(R.string.Lainaustekija64)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti65), getApplicationContext().getResources().getString(R.string.Lainaustekija65)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti66), getApplicationContext().getResources().getString(R.string.Lainaustekija66)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti67), getApplicationContext().getResources().getString(R.string.Lainaustekija67)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti68), getApplicationContext().getResources().getString(R.string.Lainaustekija68)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti69), getApplicationContext().getResources().getString(R.string.Lainaustekija69)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti70), getApplicationContext().getResources().getString(R.string.Lainaustekija70)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti71), getApplicationContext().getResources().getString(R.string.Lainaustekija71)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti72), getApplicationContext().getResources().getString(R.string.Lainaustekija72)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti73), getApplicationContext().getResources().getString(R.string.Lainaustekija73)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti74), getApplicationContext().getResources().getString(R.string.Lainaustekija74)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti75), getApplicationContext().getResources().getString(R.string.Lainaustekija75)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti76), getApplicationContext().getResources().getString(R.string.Lainaustekija76)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti77), getApplicationContext().getResources().getString(R.string.Lainaustekija77)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti78), getApplicationContext().getResources().getString(R.string.Lainaustekija78)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti79), getApplicationContext().getResources().getString(R.string.Lainaustekija79)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti80), getApplicationContext().getResources().getString(R.string.Lainaustekija80)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti81), getApplicationContext().getResources().getString(R.string.Lainaustekija81)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti82), getApplicationContext().getResources().getString(R.string.Lainaustekija82)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti83), getApplicationContext().getResources().getString(R.string.Lainaustekija83)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti84), getApplicationContext().getResources().getString(R.string.Lainaustekija84)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti85), getApplicationContext().getResources().getString(R.string.Lainaustekija85)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti86), getApplicationContext().getResources().getString(R.string.Lainaustekija86)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti87), getApplicationContext().getResources().getString(R.string.Lainaustekija87)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti88), getApplicationContext().getResources().getString(R.string.Lainaustekija88)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti89), getApplicationContext().getResources().getString(R.string.Lainaustekija89)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti90), getApplicationContext().getResources().getString(R.string.Lainaustekija90)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti91), getApplicationContext().getResources().getString(R.string.Lainaustekija91)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti92), getApplicationContext().getResources().getString(R.string.Lainaustekija92)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti93), getApplicationContext().getResources().getString(R.string.Lainaustekija93)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti94), getApplicationContext().getResources().getString(R.string.Lainaustekija94)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti95), getApplicationContext().getResources().getString(R.string.Lainaustekija95)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti96), getApplicationContext().getResources().getString(R.string.Lainaustekija96)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti97), getApplicationContext().getResources().getString(R.string.Lainaustekija97)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti98), getApplicationContext().getResources().getString(R.string.Lainaustekija98)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti99), getApplicationContext().getResources().getString(R.string.Lainaustekija99)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti100), getApplicationContext().getResources().getString(R.string.Lainaustekija100)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti101), getApplicationContext().getResources().getString(R.string.Lainaustekija101)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti102), getApplicationContext().getResources().getString(R.string.Lainaustekija102)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti103), getApplicationContext().getResources().getString(R.string.Lainaustekija103)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti104), getApplicationContext().getResources().getString(R.string.Lainaustekija104)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti105), getApplicationContext().getResources().getString(R.string.Lainaustekija105)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti106), getApplicationContext().getResources().getString(R.string.Lainaustekija106)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti107), getApplicationContext().getResources().getString(R.string.Lainaustekija107)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti108), getApplicationContext().getResources().getString(R.string.Lainaustekija108)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti109), getApplicationContext().getResources().getString(R.string.Lainaustekija109)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti110), getApplicationContext().getResources().getString(R.string.Lainaustekija110)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti111), getApplicationContext().getResources().getString(R.string.Lainaustekija111)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti112), getApplicationContext().getResources().getString(R.string.Lainaustekija112)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti113), getApplicationContext().getResources().getString(R.string.Lainaustekija113)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti114), getApplicationContext().getResources().getString(R.string.Lainaustekija114)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti115), getApplicationContext().getResources().getString(R.string.Lainaustekija115)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti116), getApplicationContext().getResources().getString(R.string.Lainaustekija116)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti117), getApplicationContext().getResources().getString(R.string.Lainaustekija117)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti118), getApplicationContext().getResources().getString(R.string.Lainaustekija118)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti119), getApplicationContext().getResources().getString(R.string.Lainaustekija119)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti120), getApplicationContext().getResources().getString(R.string.Lainaustekija120)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti121), getApplicationContext().getResources().getString(R.string.Lainaustekija121)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti122), getApplicationContext().getResources().getString(R.string.Lainaustekija122)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti123), getApplicationContext().getResources().getString(R.string.Lainaustekija123)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti124), getApplicationContext().getResources().getString(R.string.Lainaustekija124)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti125), getApplicationContext().getResources().getString(R.string.Lainaustekija125)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti126), getApplicationContext().getResources().getString(R.string.Lainaustekija126)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti127), getApplicationContext().getResources().getString(R.string.Lainaustekija127)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti128), getApplicationContext().getResources().getString(R.string.Lainaustekija128)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti129), getApplicationContext().getResources().getString(R.string.Lainaustekija129)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti130), getApplicationContext().getResources().getString(R.string.Lainaustekija130)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti131), getApplicationContext().getResources().getString(R.string.Lainaustekija131)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti132), getApplicationContext().getResources().getString(R.string.Lainaustekija132)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti133), getApplicationContext().getResources().getString(R.string.Lainaustekija133)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti134), getApplicationContext().getResources().getString(R.string.Lainaustekija134)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti135), getApplicationContext().getResources().getString(R.string.Lainaustekija135)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti136), getApplicationContext().getResources().getString(R.string.Lainaustekija136)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti137), getApplicationContext().getResources().getString(R.string.Lainaustekija137)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti138), getApplicationContext().getResources().getString(R.string.Lainaustekija138)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti139), getApplicationContext().getResources().getString(R.string.Lainaustekija139)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti140), getApplicationContext().getResources().getString(R.string.Lainaustekija140)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti141), getApplicationContext().getResources().getString(R.string.Lainaustekija141)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti142), getApplicationContext().getResources().getString(R.string.Lainaustekija142)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti143), getApplicationContext().getResources().getString(R.string.Lainaustekija143)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti144), getApplicationContext().getResources().getString(R.string.Lainaustekija144)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti145), getApplicationContext().getResources().getString(R.string.Lainaustekija145)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti146), getApplicationContext().getResources().getString(R.string.Lainaustekija146)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti147), getApplicationContext().getResources().getString(R.string.Lainaustekija147)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti148), getApplicationContext().getResources().getString(R.string.Lainaustekija148)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti149), getApplicationContext().getResources().getString(R.string.Lainaustekija149)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti150), getApplicationContext().getResources().getString(R.string.Lainaustekija150)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti151), getApplicationContext().getResources().getString(R.string.Lainaustekija151)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti152), getApplicationContext().getResources().getString(R.string.Lainaustekija152)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti153), getApplicationContext().getResources().getString(R.string.Lainaustekija153)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti154), getApplicationContext().getResources().getString(R.string.Lainaustekija154)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti155), getApplicationContext().getResources().getString(R.string.Lainaustekija155)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti156), getApplicationContext().getResources().getString(R.string.Lainaustekija156)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti157), getApplicationContext().getResources().getString(R.string.Lainaustekija157)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti158), getApplicationContext().getResources().getString(R.string.Lainaustekija158)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti159), getApplicationContext().getResources().getString(R.string.Lainaustekija159)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti160), getApplicationContext().getResources().getString(R.string.Lainaustekija160)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti161), getApplicationContext().getResources().getString(R.string.Lainaustekija161)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti162), getApplicationContext().getResources().getString(R.string.Lainaustekija162)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti163), getApplicationContext().getResources().getString(R.string.Lainaustekija163)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti164), getApplicationContext().getResources().getString(R.string.Lainaustekija164)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti165), getApplicationContext().getResources().getString(R.string.Lainaustekija165)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti166), getApplicationContext().getResources().getString(R.string.Lainaustekija166)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti167), getApplicationContext().getResources().getString(R.string.Lainaustekija167)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti168), getApplicationContext().getResources().getString(R.string.Lainaustekija168)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti169), getApplicationContext().getResources().getString(R.string.Lainaustekija169)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti170), getApplicationContext().getResources().getString(R.string.Lainaustekija170)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti171), getApplicationContext().getResources().getString(R.string.Lainaustekija171)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti172), getApplicationContext().getResources().getString(R.string.Lainaustekija172)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti173), getApplicationContext().getResources().getString(R.string.Lainaustekija173)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti174), getApplicationContext().getResources().getString(R.string.Lainaustekija174)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti175), getApplicationContext().getResources().getString(R.string.Lainaustekija175)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti176), getApplicationContext().getResources().getString(R.string.Lainaustekija176)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti177), getApplicationContext().getResources().getString(R.string.Lainaustekija177)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti178), getApplicationContext().getResources().getString(R.string.Lainaustekija178)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti179), getApplicationContext().getResources().getString(R.string.Lainaustekija179)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti180), getApplicationContext().getResources().getString(R.string.Lainaustekija180)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti181), getApplicationContext().getResources().getString(R.string.Lainaustekija181)));
        positivisetSanatLista.add(new Positiivisetsanat(getApplicationContext().getResources().getString(R.string.Lainausteksti182), getApplicationContext().getResources().getString(R.string.Lainaustekija182)));


        // jos eka kerta käyttämässä tulostetaan ruudulle "käytät ensimmäistä kertaa" ja tallennetaan boolean muuttuja siitä prefenssiin
        // kun seuraavan kerran tullaan paikalle viesti muuttuu
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        ensimmaistaKertaaKayttamassa = sharedPreferences.getBoolean("onkoekakertataalla", ensimmaistaKertaaKayttamassa);
        TextView aloitusTekstinakyma = (TextView) findViewById(R.id.textView21);
        TextView aloitusTekstinakyma2 = (TextView) findViewById(R.id.textView22);
        TextView aloitusTekstinakyma3 = (TextView) findViewById(R.id.textView23);
        if (!ensimmaistaKertaaKayttamassa) {
            aloitusTekstinakyma.setText(getApplicationContext().getResources().getString(R.string.textViewAloitusEka));
            aloitusTekstinakyma2.setText(getApplicationContext().getResources().getString(R.string.textViewAloitusToka));
            ensimmaistaKertaaKayttamassa = true;
            SharedPreferences.Editor asetusTallennus = sharedPreferences.edit();
            asetusTallennus.putBoolean("onkoekakertataalla", ensimmaistaKertaaKayttamassa);
            asetusTallennus.apply();
        } else {
            aloitusTekstinakyma.setText(R.string.textViewAloitusVanha);
            aloitusTekstinakyma2.setText(R.string.textViewAloitusVanha2);

        }
        int valitseSekalainenNumeroInt = (int) (Math.random() * positivisetSanatLista.size());
        Log.i("my_app", " " + valitseSekalainenNumeroInt);
        Log.i("my_app", " " + positivisetSanatLista.get(valitseSekalainenNumeroInt) + " \n" + " -" + positivisetSanatLista.get(valitseSekalainenNumeroInt).getPositiivisetSanatTekija());
        aloitusTekstinakyma3.setText(positivisetSanatLista.get(valitseSekalainenNumeroInt) + " \n" + " -" + positivisetSanatLista.get(valitseSekalainenNumeroInt).getPositiivisetSanatTekija());
        Thread tervetuloaLanka = new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    // 7 sekunnin viive
                    sleep(7000);
                } catch (Exception e) {

                } finally {

                    Intent uusiSiirtyma = new Intent(Aloitusluokka.this,
                            MainActivity.class);
                    startActivity(uusiSiirtyma);
                    finish();
                }
            }
        };
        tervetuloaLanka.start();
    }


}

