package com.example.terveyssovellusryhm8;

public class Positiivisetsanat {
    private static String positivisetSanat;
    private static String positivisetSanatTekija;
    
    public Positiivisetsanat(String positivisetSanat, String positivisetSanatTekija) {
        this.positivisetSanat = positivisetSanat;
        this.positivisetSanatTekija = positivisetSanatTekija;
    }



    public static String getPositiivisetSanat() {
        return positivisetSanat;
    }
    public void setPositiivisetSanat(String positivisetSanat) {
        this.positivisetSanat = positivisetSanat;
    }
    public static String getPositiivisetSanatTekija() {
        return positivisetSanatTekija;
    }
    public void setPositiivisetSanatTekija(String positivisetSanatTekija) {
        this.positivisetSanatTekija = positivisetSanatTekija;
    }

}
