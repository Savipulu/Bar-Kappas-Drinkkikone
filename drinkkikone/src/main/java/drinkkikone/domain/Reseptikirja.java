
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
    
    public void lisaaResepti(Resepti r) {
        this.reseptit.add(r);
    }
    
    public String kaikkiReseptit() {
        String kaikki = "";
        for (Resepti resepti : reseptit) {
            kaikki += resepti.toString() + "\n";
        }
        return kaikki;
    }
    
    public String toString() {
        String toString = "";
        for (Resepti resepti : reseptit) {
            toString += resepti.toString();
        }
        return toString;
    }
}
