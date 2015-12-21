
package Drinkkikone;

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
    public void AinesosienListaEiOleNull() {
        assertNotEquals(null, resepti.getAinesosat());
    }
    
    @Test
    public void AinesosienListaAluksiTyhja() {
        assertEquals(0, resepti.getAinesosat().size());
    }
}
