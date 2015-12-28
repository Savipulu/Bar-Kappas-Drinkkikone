
package drinkkikone.domain;

import java.util.ArrayList;
import java.util.List;

public class Resepti {
    private String nimi;
    private List<Ainesosa> ainesosat;
    
    public Resepti(String nimi) {
        this.nimi = nimi;
        this.ainesosat = new ArrayList<>();
    }
    
    public Resepti(String nimi, List<Ainesosa> ainesosat) {
        this.nimi = nimi;
        this.ainesosat = new ArrayList<>();
        this.ainesosat.addAll(ainesosat);
    }
    
    public List<Ainesosa> getAinesosat() {
        return this.ainesosat;
    }
    
    public void lisaaAinesosa(Ainesosa ainesosa) {
        this.ainesosat.add(ainesosa);
    }
    
    public String toString() {
        String resepti = this.nimi + ": \n";
        
        for (Ainesosa ainesosa : ainesosat) {
            resepti += "  " + ainesosa.getNimi() + ": " + ainesosa.getMaara() + " cl";
        }
        
        return resepti;
    }
}
