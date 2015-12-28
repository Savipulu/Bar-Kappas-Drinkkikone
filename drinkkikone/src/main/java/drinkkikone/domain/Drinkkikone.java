
package drinkkikone.domain;

import java.util.Random;

public class Drinkkikone {
    private Baarikaappi baarikaappi;
    private Reseptikirja reseptikirja;
    private Random random;
    
    public Drinkkikone(Baarikaappi baarikaappi, Reseptikirja reseptikirja) {
        this.baarikaappi = baarikaappi;
        this.reseptikirja = reseptikirja;
        this.random = new Random();
    }
    
    public Baarikaappi getBaarikaappi() {
        return this.baarikaappi;
    }
    
    public Reseptikirja getReseptikirja() {
        return this.reseptikirja;
    }
    
    public void lisaaResepti(Resepti r) {
        this.reseptikirja.lisaaResepti(r);
    }
    
    public String kaikkiReseptit() {
        return this.reseptikirja.kaikkiReseptit();
    }
    
    public Resepti satunnainenDrinkki() {
        if (!this.baarikaappi.onTyhja()) {
            this.reseptikirja.getReseptit().get(random.nextInt(this.reseptikirja.getReseptit().size()));
        }
        return null;
    }
    
    
}
