/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.verkkokauppa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {
    private Pankki pankki;
    private Viitegeneraattori viite;
    private Varasto varasto;
    private Kauppa k;

    public KauppaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        k = new Kauppa(varasto, pankki, viite);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        // luodaan ensin mock-oliot
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // sitten testattava kauppa 
        

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
    // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        // luodaan ensin mock-oliot
        // määritellään että viitegeneraattori palauttaa viitten 42
        when(viite.uusi()).thenReturn(42);

        
        // määritellään että tuote numero 1 on maito jonka hinta on 5 ja saldo 10
        when(varasto.saldo(1)).thenReturn(10);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");

        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));
        // toistaiseksi ei välitetty kutsussa käytetyistä parametreista
    }

    @Test
    public void kahdenEriTuotteenOstoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        
        when(viite.uusi()).thenReturn(986);
        
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kaali", 2));
        
        when(varasto.saldo(4)).thenReturn(20);
        when(varasto.haeTuote(4)).thenReturn(new Tuote(4, "porkkana", 11));
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(4);
        k.tilimaksu("Kaisa", "54321");
        
        verify(pankki).tilisiirto(eq("Kaisa"), eq(986), eq("54321"), eq("33333-44455"), eq(13));
    }

    @Test
    public void kahdenSamanTuotteenOstoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        
        when(viite.uusi()).thenReturn(913);
        
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kaali", 2));
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.lisaaKoriin(1);
        k.tilimaksu("Kaisa", "54321");
        
        verify(pankki).tilisiirto(eq("Kaisa"), eq(913), eq("54321"), eq("33333-44455"), eq(4));
    }
    
    @Test
    public void tuoteJotaEiTarpeeksiJNE() {
        when(viite.uusi()).thenReturn(913);
                
        when(varasto.saldo(4)).thenReturn(20);
        when(varasto.haeTuote(4)).thenReturn(new Tuote(4, "porkkana", 11));
        
        when(varasto.saldo(1)).thenReturn(0);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kaali", 2));
        
        k.aloitaAsiointi();
        k.lisaaKoriin(4);
        k.lisaaKoriin(1);
        k.tilimaksu("Pelleliina", "890");
        
        verify(pankki).tilisiirto(eq("Pelleliina"), eq(913), eq("890"), eq("33333-44455"), eq(11));
    }
    
    @Test
    public void aloitaAsiointiNollaaJNE() {
        when(viite.uusi()).thenReturn(913);
                
        when(varasto.saldo(4)).thenReturn(20);
        when(varasto.haeTuote(4)).thenReturn(new Tuote(4, "porkkana", 11));
        
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "kaali", 2));
        
        k.aloitaAsiointi();
        k.lisaaKoriin(4);
        k.lisaaKoriin(1);
        k.tilimaksu("Pelleliina", "890");
        
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), eq(13));
        
        k.aloitaAsiointi();
        k.lisaaKoriin(4);
        k.tilimaksu("Pelle", "89023");
        
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), eq(11));
    }
    
    @Test
    public void uusiViiteJNE() {

        k.aloitaAsiointi();
        k.lisaaKoriin(4);
        k.lisaaKoriin(1);
        k.tilimaksu("Pelleliina", "890");
        
        verify(viite, times(1)).uusi();
        
        k.aloitaAsiointi();
        k.lisaaKoriin(4);
        k.tilimaksu("Pelle", "89023");
        
        verify(viite, times(2)).uusi();
    }
    
    @Test
    public void poistaKorista() {
        Tuote t = new Tuote(1, "kaali", 2);
        
        when(varasto.saldo(1)).thenReturn(3);
        when(varasto.haeTuote(1)).thenReturn(t);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(1);
        k.poistaKorista(1);
        k.tilimaksu("...", "...");
        
        verify(varasto).palautaVarastoon(eq(t));
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), eq(0));
    }

//    varmistettava, että metodin aloitaAsiointi kutsuminen nollaa edellisen ostoksen tiedot 
//                    (eli edellisen ostoksen hinta ei näy uuden ostoksen hinnassa), katso tarvittaessa 
//                    apua projektin MockitoDemo testeistä!
//    varmistettava, että kauppa pyytää uuden viitenumeron jokaiselle maksutapahtumalle, 
//                    katso tarvittaessa apua projektin MockitoDemo testeistä!
}
