/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.tests;

import drinkkikone.domain.Ainesosa;
import drinkkikone.domain.Resepti;
import drinkkikone.domain.Reseptikirja;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReseptikirjaTest {
    private Reseptikirja reseptikirja;
    private Resepti resepti1;
    private Resepti resepti2;
    
    public ReseptikirjaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        reseptikirja = new Reseptikirja();
        
        HashMap<Ainesosa, Double> ainesosat = new HashMap<>();
        ainesosat.put(new Ainesosa("Rommi", 30.0), 2.0);
        ainesosat.put(new Ainesosa("Coca-cola", 0.0), 2.0);
        resepti1 = new Resepti("Rommikola", ainesosat);
        
        ainesosat.clear();
        ainesosat.put(new Ainesosa("Gin", 35.0), 1.0);
        ainesosat.put(new Ainesosa("Vermutti", 40.0), 6.0);
        resepti2 = new Resepti("Martini", ainesosat);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void reseptienListaEiOleNull() {
        assertNotEquals(null, reseptikirja.getKaikkiReseptit());
    }
    
    @Test
    public void reseptienListaAluksiTyhja() {
        assertEquals(0, reseptikirja.getKaikkiReseptit().size());
    }
    
    @Test
    public void reseptinLisaysLisaaReseptin() {
        reseptikirja.lisaaResepti(resepti1);
        assertEquals(1, reseptikirja.getKaikkiReseptit().size());
    }
    
    @Test
    public void reseptienTulostaminenToimii() {
        reseptikirja.lisaaResepti(resepti1);
        assertEquals(resepti1.toString(), reseptikirja.toString());
    }
    
    @Test
    public void kaikkienReseptienTulostaminenToimii() {
        reseptikirja.lisaaResepti(resepti1);
        reseptikirja.lisaaResepti(resepti2);
        assertEquals(resepti1.toString() + "\n" + resepti2.toString() + "\n", reseptikirja.kaikkiReseptitMerkkijonona());
    }
}
