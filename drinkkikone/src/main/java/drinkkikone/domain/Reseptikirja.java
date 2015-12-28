
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
    
    public void tulostaReseptit() {
        for (Resepti resepti : reseptit) {
            System.out.println(resepti);
        }
    }
    
    public String toString() {
        String toString = "";
        for (Resepti resepti : reseptit) {
            toString += resepti.toString();
        }
        return toString;
    }
}
