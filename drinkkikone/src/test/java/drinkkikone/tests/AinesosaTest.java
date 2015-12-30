
package drinkkikone.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import drinkkikone.domain.Ainesosa;

public class AinesosaTest {
    
    private Ainesosa ainesosa1;
    private Ainesosa ainesosa2;
    private Ainesosa ainesosa3;
    
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
        ainesosa1 = new Ainesosa("Karpalolikööri", 22.0);
        ainesosa2 = new Ainesosa("Karpalolikööri", 28.0);
        ainesosa3 = new Ainesosa("Bailey's", 17.0);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaNimenOikein() {
        assertEquals("Karpalolikööri", ainesosa1.getNimi());
    }
    
    @Test
    public void konstruktoriAsettaaAlkoholipitoisuudenOikein() {
        assertEquals(22.0, ainesosa1.getAlkoholipitoisuus(), 0.0001);
    }
    
    @Test
    public void toStringToimiiOikein() {
        assertEquals("Karpalolikööri", ainesosa1.toString());
    }
    
    @Test
    public void equalsMetodiFalseJosNimetEri() {
        assertEquals(false, ainesosa1.equals(ainesosa3));
    }
    
    @Test
    public void equalsMetodiTrueJosNimetSamat() {
        assertEquals(true, ainesosa1.equals(ainesosa2));
    }
}
