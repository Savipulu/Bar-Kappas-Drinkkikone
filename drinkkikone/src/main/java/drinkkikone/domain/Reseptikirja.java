
package drinkkikone.domain;

import java.util.ArrayList;
import java.util.List;

public class Reseptikirja {
    private List<Resepti> reseptit;
    
    public Reseptikirja() {
        this.reseptit = new ArrayList<>();
    }
    
    public List<Resepti> getReseptit() {
        return this.reseptit;
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
