
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
        HashMap ainesosat = new HashMap<Ainesosa, Integer>();
        ainesosat.put(new Ainesosa("Vermutti", 20), 6);
        ainesosat.put(new Ainesosa("Gin", 15), 1);
        resepti = new Resepti("Gin & Tonic", ainesosat);
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void getAinesosatPalauttaaListan() {
        
    }
    
    @Test
    public void ainesosienListaAluksiTyhja() {
        assertEquals(2, resepti.getAinesosat().size());
    }
    
    @Test
    public void ainesosienLisaysOnnistuu() {
        Ainesosa a = new Ainesosa("Alkoholi", 100);
        resepti.lisaaAinesosa(a, 100);
        assertEquals(3, resepti.getAinesosat().size());
    }
    
    @Test
    public void toStringToimiiOikein() {
        assertEquals("Gin & Tonic: \n  Vermutti: 6 cl, \n  Gin: 1 cl", resepti.toString());
    }
}
