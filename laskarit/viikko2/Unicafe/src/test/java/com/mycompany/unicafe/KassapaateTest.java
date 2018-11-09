/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Samuli
 */
public class KassapaateTest {

    Kassapaate kassa;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }

    @Test
    public void kassaLuotuOikein() {
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kassaLuotuOikein2() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kassaLuotuOikein3() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoMaukkaastiLisaaRahaa() {
        kassa.syoMaukkaasti(400);
        assertEquals(100400, kassa.kassassaRahaa());

    }

    @Test
    public void syoEdullisestiLisaaRahaa() {
        kassa.syoEdullisesti(250);
        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void syoEdullisestiVaihtorahaToimii() {

        assertEquals(60, kassa.syoEdullisesti(300));

    }

    @Test
    public void syoEdullisestiKassaToimiiVaihtorahalla() {
        kassa.syoEdullisesti(300);

        assertEquals(100240, kassa.kassassaRahaa());
    }

    @Test
    public void syoMaukkaastiVaihtoRahaToimii() {
        assertEquals(150, kassa.syoMaukkaasti(550));
    }

    @Test
    public void syoMaukkaastiKassaToimiiVaihtorahalla() {
        kassa.syoMaukkaasti(550);
        assertEquals(100400, kassa.kassassaRahaa());
    }

    @Test
    public void syoMaukkaastiKasvattaaLaskuria() {
        kassa.syoMaukkaasti(400);
        kassa.syoMaukkaasti(400);
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiKasvattaaLaskuria() {
        kassa.syoEdullisesti(240);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiRahaEiRiitaKassa() {
        kassa.syoEdullisesti(160);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void syoMaukkaastiRahaEiRiitaKassa() {
        kassa.syoMaukkaasti(200);
        kassa.syoMaukkaasti(340);

        assertEquals(100000, kassa.kassassaRahaa());

    }

    @Test
    public void syoEdullisestiRahaEiRiitaLaskuri() {
        kassa.syoEdullisesti(120);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoMaukkaastiRahaEiRiitaLaskuri() {
        kassa.syoMaukkaasti(100);
        kassa.syoMaukkaasti(263);

        assertEquals(0, kassa.maukkaitaLounaitaMyyty());

    }

    @Test
    public void syoEdullisestiToimiiKortilla() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoEdullisesti(kortti);

        assertEquals(760, kortti.saldo());
        assertEquals(true, kassa.syoEdullisesti(kortti));

    }

    @Test
    public void syoMaukkastiToimiiKortilla() {
        Maksukortti kortti = new Maksukortti(1000);

        kassa.syoMaukkaasti(kortti);

        assertEquals(600, kortti.saldo());
        assertEquals(true, kassa.syoMaukkaasti(kortti));
    }

    @Test
    public void syoEdullisestiKasvaaKortilla() {
        Maksukortti kortti = new Maksukortti(1000);

        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);

        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }

    @Test
    public void syoMaukkaastiKasvaaKortilla() {
        Maksukortti kortti = new Maksukortti(1000);

        kassa.syoMaukkaasti(kortti);

        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void syoEdullisestiKortillaEiSaldoa() {
        Maksukortti kortti = new Maksukortti(200);

        kassa.syoEdullisesti(kortti);

        assertEquals(false, kassa.syoEdullisesti(kortti));
        assertEquals(0, kassa.edullisiaLounaitaMyyty());

    }

    @Test
    public void syoMaukkaastiKortillaEiSaldoa() {
        Maksukortti kortti = new Maksukortti(300);
        
        kassa.syoMaukkaasti(kortti);
        
        assertEquals(false, kassa.syoMaukkaasti(kortti));
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
       
    }
    
    @Test
    public void korttiostoEiKasvataRahamäärää() {
        Maksukortti kortti = new Maksukortti (1400);
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        
        assertEquals(100000,kassa.kassassaRahaa());
    }
    
    @Test
    public void saldonLatausKortilleToimii() {
        Maksukortti kortti = new Maksukortti(100);
        
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(100500, kassa.kassassaRahaa());
        assertEquals(600, kortti.saldo());
    }

    
    @Test
    public void negatiivisenSummanLatausEiOnnistu() {
        
        Maksukortti kortti = new Maksukortti(100);
        
        kassa.lataaRahaaKortille(kortti, -700);
        
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(100, kortti.saldo());
        
    }
    

}
