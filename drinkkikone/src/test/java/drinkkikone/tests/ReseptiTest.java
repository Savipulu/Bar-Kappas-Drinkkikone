
package drinkkikone.tests;

import drinkkikone.domain.Ainesosa;
import drinkkikone.domain.Resepti;
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
        resepti = new Resepti("Karpalobooli");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ainesosienListaEiOleNull() {
        assertNotEquals(null, resepti.getAinesosat());
    }
    
    @Test
    public void ainesosienListaAluksiTyhja() {
        assertEquals(0, resepti.getAinesosat().size());
    }
    
    @Test
    public void ainesosienLisaysOnnistuu() {
        Ainesosa a = new Ainesosa("Alkoholi", 100, 100);
        resepti.lisaaAinesosa(a);
        assertEquals(1, resepti.getAinesosat().size());
    }
}
