
package Drinkkikone;

import drinkkikone.domain.Baarikaappi;
import drinkkikone.domain.Drinkkikone;
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
    private Reseptikirja Reseptikirja;
    
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
        drinkkikone =  new Drinkkikone(new Baarikaappi(), new Reseptikirja());
    }
    
    @After
    public void tearDown() {
    }
    
    
}
