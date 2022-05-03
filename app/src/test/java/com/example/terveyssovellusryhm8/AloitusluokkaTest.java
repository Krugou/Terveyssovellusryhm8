package com.example.terveyssovellusryhm8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.util.Log;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;


public class AloitusluokkaTest {
    private List<Positiivisetsanat> positivisetSanatLista;
    private final String testiString = "test";
    private final String testiString2 = "test2";


    @Before
    public void setUp() {
        positivisetSanatLista = new ArrayList<>();



    }
    @Test
    public void testAloitusluokkaInit(){
        assertTrue(positivisetSanatLista.isEmpty());
        assertEquals(0, positivisetSanatLista.size());
    }
    @Test
    public void testAloitusluokkaAdd() {
        positivisetSanatLista.add(new Positiivisetsanat(testiString, testiString2));
        assertEquals(1, positivisetSanatLista.size());
        assertEquals(testiString, positivisetSanatLista.get(0).getPositiivisetSanat());
        assertEquals(testiString2, positivisetSanatLista.get(0).getPositiivisetSanatTekija());



    }
    @Test
    public void testAloitusluokkaRemove(){
        positivisetSanatLista.add(new Positiivisetsanat(testiString, testiString2));
        positivisetSanatLista.add(new Positiivisetsanat(testiString2, testiString));
        positivisetSanatLista.remove(0);
        assertEquals(1, positivisetSanatLista.size());
        assertEquals(testiString2, positivisetSanatLista.get(0).getPositiivisetSanat());
        assertEquals(testiString, positivisetSanatLista.get(0).getPositiivisetSanatTekija());

    }
    @Test
    public void testAloitusluokkaAreThere(){
        assertTrue(testiString==testiString);
        assertTrue(testiString2==testiString2);
        
    }

}