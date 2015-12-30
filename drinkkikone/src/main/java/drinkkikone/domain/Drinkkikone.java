
package drinkkikone.domain;

import java.util.Random;

/**
 * Drinkkikone -luokka hallinnoi sille luotuja baarikaappia ja reseptikirjaa, 
 * ja huolehtii niiden välisestä yhteistyöstä
 */
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
        Resepti r = null;
        if (!this.baarikaappi.onTyhja()) {
            while (true) {
                int i = random.nextInt(this.reseptikirja.getKaikkiReseptit().size());
                r = this.reseptikirja.getResepti(i);
                if (aineksetLoytyy(r)) {
                    break;
                }
            }
        }
        return r;
    }
    
    public boolean aineksetLoytyy(Resepti r) {
        if (this.baarikaappi.getBaarikaapinAinesosat().size() == 0) {
            return false;
        }
        
        for (Ainesosa ainesosa : r.getAinesosat()) {
            if (r.getAinesosatJaMaarat().get(ainesosa) < this.baarikaappi.getAinesosanMaaraBaarikaapissa(ainesosa)) {
                return false;
            }
        }
        return true;
    }
}
