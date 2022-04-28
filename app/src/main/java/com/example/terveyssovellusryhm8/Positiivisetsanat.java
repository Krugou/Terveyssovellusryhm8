package com.example.terveyssovellusryhm8;

public class Positiivisetsanat {
    String positivisetSanat;

    String positivisetSanatTekija;

    public Positiivisetsanat(String positivisetSanat, String positivisetSanatTekija) {
        this.positivisetSanat = positivisetSanat;
        this.positivisetSanatTekija = positivisetSanatTekija;
    }




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
