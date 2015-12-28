
package drinkkikone.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import drinkkikone.domain.Ainesosa;

public class AinesosaTest {
    
    private Ainesosa ainesosa;
    
    public AinesosaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ainesosa = new Ainesosa("Karpalolikööri", 22.0);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaNimenOikein() {
        assertEquals("Karpalolikööri", ainesosa.getNimi());
    }
    
    @Test
    public void konstruktoriAsettaaAlkoholipitoisuudenOikein() {
        assertEquals(22.0, ainesosa.getAlkoholipitoisuus(), 0.0001);
    }
    
    @Test
    public void toStringToimiiOikein() {
        assertEquals("Karpalolikööri", ainesosa.toString());
    }
}
