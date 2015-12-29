
package drinkkikone.tests;

import drinkkikone.domain.Ainesosa;
import drinkkikone.domain.Resepti;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReseptiTest {
    
    private Resepti resepti;
    private HashMap<Ainesosa, Double> ainesosat;
    
    public ReseptiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ainesosat = new HashMap<>();
        ainesosat.put(new Ainesosa("Vermutti", 15.0), 6.0);
        ainesosat.put(new Ainesosa("Gin", 15.0), 1.0);
        resepti = new Resepti("Gin & Tonic");
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getAinesosatPalauttaaListan() {
        
    }
    
    @Test
    public void ainesosienListaAluksiTyhja() {
        assertEquals(0, resepti.getAinesosat().size());
    }
    
    @Test
    public void ainesosienLisaysOnnistuu() {
        Ainesosa a = new Ainesosa("Alkoholi", 100.0);
        resepti.lisaaAinesosa(a, 100.0);
        assertEquals(1, resepti.getAinesosat().size());
    }
    
    @Test
    public void ainesosienLisaysOnnistuuHashMapilla() {
        resepti.lisaaUseaAinesosa(ainesosat);
        assertEquals(2, resepti.getAinesosat().size());
    }
    
    @Test
    public void toStringToimiiOikein() {
        resepti.lisaaUseaAinesosa(ainesosat);
        assertEquals("Gin & Tonic: \n  Gin: 1.0 cl, \n  Vermutti: 6.0 cl", resepti.toString());
    }
}
