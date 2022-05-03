package com.example.terveyssovellusryhm8;

public class Positiivisetsanat {
    // positiivisien sanojen olioluokka
    String positivisetSanat;

    String positivisetSanatTekija;

    public Positiivisetsanat(String positivisetSanat, String positivisetSanatTekija) {
        this.positivisetSanat = positivisetSanat;
        this.positivisetSanatTekija = positivisetSanatTekija;
    }


    // tulostaa takaisin sanat ja tekijät
    public String getPositiivisetSanat() {
        return positivisetSanat;
    }
    public String getPositiivisetSanatTekija() {
        return positivisetSanatTekija;
    }
    @Override
    public String toString(){
        return positivisetSanat;

    }

}
