package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kortinSaldoOnOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void rahanLatausKasvattaaSaldoa() {
        kortti.lataaRahaa(10);

        assertEquals("saldo: 0.20", kortti.toString());
    }

    @Test
    public void rahanOttaminenToimii() {
        kortti.otaRahaa(5);

        assertEquals("saldo: 0.05", kortti.toString());
    }

    @Test
    public void saldoEiMuutuJosEiTarpeeksi() {
        kortti.otaRahaa(20);

        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void rahanOttaminenBooleanToimii() {

        assertEquals(true, kortti.otaRahaa(5));
    }
    
    @Test
    public void rahaVastaaSaldoa() {
        assertEquals(10, kortti.saldo());
    }
}
