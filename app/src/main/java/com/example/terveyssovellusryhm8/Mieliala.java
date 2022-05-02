package com.example.terveyssovellusryhm8;

public class Mieliala {
        // Kaik on kesken
        private int[] mood;
        private String arviointi;
        private int points;

        public Mieliala(int pituus){
            this.mood = new int[pituus];
        }

        public int[] getMieliala(){
            return this.mood;
        }
        public int getPituus(){
            return this.mood.length;
        }

        public int pointsit(){
            for (int i = 0; i < this.mood.length; i++){
                points += this.mood[i];
            }
            return points;
        }

        public String moodText(int i){
            if (i < 4){
                return "Ei masennusoireita";
                // <string name="depression1">Ei masennusoireita</string>
                // Jatka tästä
            } else if (i < 7){
                return "Lieviä masennusoireita";
            } else if (i < 15){
                return "Kohtalaisia masennusoireita";
            } else {
                return "Vakavia masennusoireita";
            }
        }
    }
