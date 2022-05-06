package com.example.terveyssovellusryhm8;

/**
 * @author Aleksi
 */
public class Positiivisetsanat {
    /**
     * The Positiviset sanat.
     */
// positiivisien sanojen olioluokka
    String positivisetSanat;

    /**
     * The Positiviset sanat tekija.
     */
    String positivisetSanatTekija;

    /**
     * Instantiates a new Positiivisetsanat.
     *
     * @param positivisetSanat       the positiviset sanat
     * @param positivisetSanatTekija the positiviset sanat tekija
     */
    public Positiivisetsanat(String positivisetSanat, String positivisetSanatTekija) {
        this.positivisetSanat = positivisetSanat;
        this.positivisetSanatTekija = positivisetSanatTekija;
    }


    /**
     * Gets positiiviset sanat.
     *
     * @return the positiiviset sanat
     */
// tulostaa takaisin sanat ja tekijät
    public String getPositiivisetSanat() {
        return positivisetSanat;
    }

    /**
     * Gets positiiviset sanat tekija.
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
