package com.example.terveyssovellusryhm8;

/**
 * 
 * 
 * 
 * @author Aleksi
 */
public class Positiivisetsanat {
    /**
     * Create string of positive words.
     */
// positiivisien sanojen olioluokka
    String positivisetSanat;

    /**
     * Create string of positive words author.
     */
    String positivisetSanatTekija;
    /**
     * 
     *
     * @param positivisetSanat       the positiviset sanat
     * @param positivisetSanatTekija the positiviset sanat tekija
     */
    public Positiivisetsanat(String positivisetSanat, String positivisetSanatTekija) {
        this.positivisetSanat = positivisetSanat;
        this.positivisetSanatTekija = positivisetSanatTekija;
    }


    /**
     * Palauttaa positiivisen lauseen.
     *
     * @return the positiiviset sanat
     */
// tulostaa takaisin sanat ja tekijät
    public String getPositiivisetSanat() {
        return positivisetSanat;
    }

    /**
     * Palauttaa positiivisen sanojen tekijän.
     *
     * @return the positiiviset sanat tekija
     */
    public String getPositiivisetSanatTekija() {
        return positivisetSanatTekija;
    }
    @Override
    public String toString(){
        return positivisetSanat;

    }

}
