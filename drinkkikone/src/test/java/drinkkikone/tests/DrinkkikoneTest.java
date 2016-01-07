
package drinkkikone.tests;

import drinkkikone.domain.Ainesosa;
import drinkkikone.domain.Baarikaappi;
import drinkkikone.domain.Drinkkikone;
import drinkkikone.domain.Resepti;
import drinkkikone.domain.Reseptikirja;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DrinkkikoneTest {
    private Drinkkikone drinkkikone;
    private Baarikaappi baarikaappi;
    private Reseptikirja reseptikirja;
    private Resepti resepti1;
    private List<Ainesosa> ainesosat;
    private Map<Ainesosa, Double> ainesosatMap;
    
    public DrinkkikoneTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        baarikaappi = new Baarikaappi();
        reseptikirja = new Reseptikirja();
        drinkkikone = new Drinkkikone(baarikaappi, reseptikirja);
        
        ainesosat = new ArrayList<>();
        ainesosat.add(new Ainesosa("Rommi", 25.0));
        ainesosat.add(new Ainesosa("Coca-Cola", 0.0));
        
        ainesosatMap = new HashMap<>();
        for (Ainesosa ainesosa : ainesosat) {
            ainesosatMap.put(ainesosa, 2.0);
        }
        
        resepti1 = new Resepti("Cuba Libre", ainesosatMap);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaBaarikaapin() {
        assertNotEquals(null, drinkkikone.getBaarikaappi());
    }
    
    @Test
    public void konstruktoriAsettaaReseptikirjan() {
        assertNotEquals(null, drinkkikone.getReseptikirja());
    }
    
    @Test
    public void reseptinLisaysLisaaReseptin() {
        drinkkikone.lisaaResepti(resepti1);
        assertEquals(1, drinkkikone.getReseptikirja().getKaikkiReseptit().size());
    }
    
    @Test
    public void reseptienTulostaminenToimii() {
        drinkkikone.lisaaResepti(resepti1);
        assertEquals(resepti1.toString() + "\n", reseptikirja.toString());
    }
    
    @Test
    public void aineksetLoytyyFalseJosAineksiaEiOle() {
        assertEquals(false, drinkkikone.aineksetLoytyy(resepti1));
    }
    
    @Test
    public void aineksetLoytyyFalseJosAineksiaEiOleTarpeeksi() {
        drinkkikone.lisaaResepti(resepti1);
        for (Ainesosa ainesosa : ainesosatMap.keySet()) {
            baarikaappi.lisaaAinesosa(ainesosa, 1.0);
        }
        assertEquals(false, drinkkikone.aineksetLoytyy(resepti1));
    }
    
    @Test
    public void aineksetLoytyyTrueJosAineksetLoytyy() {
        drinkkikone.lisaaResepti(resepti1);
        baarikaappi.lisaaUseaAinesosa(ainesosatMap);
        assertEquals(true, drinkkikone.aineksetLoytyy(resepti1));
    }
    
    @Test
    public void drinkkikoneEiPalautaDrinkkejaJosBaarikaappiOnTyhja() {
        assertEquals(null, this.drinkkikone.satunnainenDrinkki());
    }
    
    @Test
    public void satunnainenDrinkkiMetodiPalauttaaDrinkinJosSeOnMahdollista() {
        drinkkikone.lisaaResepti(resepti1);
        baarikaappi.lisaaUseaAinesosa(ainesosatMap);
        assertNotEquals(null, this.drinkkikone.satunnainenDrinkki());
    }
    
    @Test
    public void naytaValmistettavatDrinkitPalauttaaMahdollisetReseptit() {
        Ainesosa gin = new Ainesosa("Gin", 40.0);
        Ainesosa tonic = new Ainesosa("Tonic -vesi", 0.0);
        
        Resepti resepti2 = new Resepti("Gin & Tonic");
        resepti2.lisaaAinesosa(gin, 4.0);
        resepti2.lisaaAinesosa(tonic, 12.0);
        
        drinkkikone.lisaaResepti(resepti1);
        drinkkikone.lisaaResepti(resepti2);
        baarikaappi.lisaaUseaAinesosa(ainesosatMap);
        
        assertEquals("---\n" + resepti1.toString() + "\n---\n", drinkkikone.naytaValmistettavatDrinkit());
    }
}
