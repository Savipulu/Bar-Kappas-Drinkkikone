
package drinkkikone.tests;

import drinkkikone.domain.Ainesosa;
import drinkkikone.domain.Baarikaappi;
import drinkkikone.domain.Drinkkikone;
import drinkkikone.domain.Resepti;
import drinkkikone.domain.Reseptikirja;
import java.util.HashMap;
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
        
        HashMap<Ainesosa, Integer> ainesosat = new HashMap<>();
        ainesosat.put(new Ainesosa("Rommi", 25), 2);
        ainesosat.put(new Ainesosa("Coca-cola", 0), 2);
        resepti1 = new Resepti("Cuba Libre", ainesosat);
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
        assertEquals(1, drinkkikone.getReseptikirja().getReseptit().size());
    }
    
    @Test
    public void reseptienTulostaminenToimii() {
        drinkkikone.lisaaResepti(resepti1);
        assertEquals(resepti1.toString(), reseptikirja.toString());
    }
    
    @Test
    public void drinkkikoneEiPalautaDrinkkejaJosBaarikaappiOnTyhja() {
        //to-do
    }
}
