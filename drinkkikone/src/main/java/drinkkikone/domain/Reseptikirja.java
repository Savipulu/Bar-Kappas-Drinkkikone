
package drinkkikone.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Reseptikirja -luokka pitää kirjaa tunnetuista resepteistä
 */
public class Reseptikirja {
    private List<Resepti> reseptit;
    
    public Reseptikirja() {
        this.reseptit = new ArrayList<>();
    }
    
    public List<Resepti> getKaikkiReseptit() {
        return this.reseptit;
    }
    
    public Resepti getResepti(int i) {
        return this.reseptit.get(i);
    } 
    
    /**
     * Metodi lisaa uuden reseptin reseptikirjaan
     * 
     * @param r lisättävä resepti
     */
    public void lisaaResepti(Resepti r) {
        this.reseptit.add(r);
    }
    
    /**
     * Metodi palauttaa reseptien nimet yhtenä merkkijonona
     * 
     * @return kaikki  
     */
    public String kaikkiReseptitMerkkijonona() {
        String kaikki = "Reseptit:\n\n";
        for (Resepti resepti : reseptit) {
            kaikki += resepti.getNimi() + "\n";
        }
        return kaikki;
    }
    
    @Override
    public String toString() {
        String toString = "";
        for (Resepti resepti : reseptit) {
            toString += resepti.toString() + "\n";
        }
        return toString;
    }
}
