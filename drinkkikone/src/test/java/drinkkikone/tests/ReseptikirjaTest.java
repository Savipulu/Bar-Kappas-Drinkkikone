/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.tests;

import drinkkikone.domain.Resepti;
import drinkkikone.domain.Reseptikirja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReseptikirjaTest {
    private Reseptikirja reseptikirja;
    private Resepti resepti1;
    
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
        resepti1 = new Resepti("Cuba Libre");
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
}
