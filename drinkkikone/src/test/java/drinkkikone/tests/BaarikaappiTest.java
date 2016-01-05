
package drinkkikone.tests;

import drinkkikone.domain.Ainesosa;
import drinkkikone.domain.Baarikaappi;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BaarikaappiTest {
    private Baarikaappi baarikaappi;
    private Ainesosa ainesosa1;
    private Ainesosa ainesosa2;
    private Map<Ainesosa, Double> ainesosat;
    
    public BaarikaappiTest() {
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
        ainesosa1 = new Ainesosa("Tequila", 38.0);
        ainesosa2 = new Ainesosa("Baileys", 17.0);
        ainesosat = new HashMap<>();
        
        ainesosat.put(ainesosa1, 200.0);
        ainesosat.put(ainesosa2, 300.0);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void baarikaapinAinesosatauluEiOleNull() {
        assertNotEquals(null, this.baarikaappi.getBaarikaapinSisalto());
    }
    
    @Test
    public void onTyhjaPalauttaaTrueJosBaarikaappiOnTyhja() {
        assertEquals(true, this.baarikaappi.onTyhja());
    }
    
    @Test
    public void ainesosanLisaysOnnistuu() {
        this.baarikaappi.lisaaAinesosa(ainesosa1, 100.0);
        assertEquals(1, this.baarikaappi.getBaarikaapinAinesosienNimet().size());
    }
    
    @Test
    public void ainesosanLisaysAsettaaMaaranOikein() {
        this.baarikaappi.lisaaAinesosa(ainesosa1, 100.0);
        assertEquals(100.0, this.baarikaappi.getAinesosanMaaraBaarikaapissa(ainesosa1), 0.001);
    }
    
    @Test
    public void onTyhjaPalauttaaFalseJosBaarikaappiEiOleTyhja() {
        this.baarikaappi.lisaaAinesosa(ainesosa1, 100.0);
        assertEquals(false, this.baarikaappi.onTyhja());
    }
    
    @Test
    public void useanAinesosanLisaysOnnistuu() {
        this.baarikaappi.lisaaUseaAinesosa(ainesosat);
        assertEquals(2, this.baarikaappi.getBaarikaapinAinesosienNimet().size());
    }
    
    @Test
    public void ainesosienLisaaminenKahdestiEiLisaaAinesosia() {
        this.baarikaappi.lisaaAinesosa(ainesosa1, 2.0);
        this.baarikaappi.lisaaAinesosa(ainesosa1, 3.0);
        assertEquals(1, this.baarikaappi.getBaarikaapinAinesosienNimet().size());
    }
    
}
