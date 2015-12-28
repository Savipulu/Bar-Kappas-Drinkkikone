
package drinkkikone.tests;

import drinkkikone.domain.Baarikaappi;
import drinkkikone.domain.Drinkkikone;
import drinkkikone.domain.Resepti;
import drinkkikone.domain.Reseptikirja;
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
        resepti1 = new Resepti("Cuba Libre");
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
}
