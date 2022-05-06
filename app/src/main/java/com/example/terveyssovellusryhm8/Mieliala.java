package com.example.terveyssovellusryhm8;

/**
 * @author Tor-Erik
 */
public class Mieliala {
        // Kaik on kesken

    /**
     * Calculate total int.
     *
     * @param mood the mood
     * @return the int
     */
    public int calculateTotal(int[] mood) {
            int points = 0;
            for (int j : mood) {
                points += j;
            }
            return points;
        }
/*
        public String howDepressed(int i){
            if (i < 4){
                return App.getRes().getString(R.string.depression1);
                // <string name="depression1">Ei masennusoireita</string>
                // Jatka tästä
            } else if (i < 7){
                return App.getRes().getString(R.string.depression2);
            } else if (i < 15){
                return App.getRes().getString(R.string.depression3);
            } else {
                return App.getRes().getString(R.string.depression4);
            }
        }*/

    }
