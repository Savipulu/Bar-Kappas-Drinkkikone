
package drinkkikone.domain;

import java.util.HashMap;
import java.util.Map;

public class Resepti {
    private String nimi;
    private Map<Ainesosa, Integer> ainesosat;
    
    public Resepti(String nimi) {
        this.nimi = nimi;
        this.ainesosat = new HashMap<>();
    }
    
    public Resepti(String nimi, Map<Ainesosa, Integer> ainesosat) {
        this(nimi);
        this.ainesosat.putAll(ainesosat);
    }
    
    public Map<Ainesosa, Integer> getAinesosat() {
        return this.ainesosat;
    }
    
    public void lisaaAinesosa(Ainesosa ainesosa, int maara) {
        this.ainesosat.put(ainesosa, maara);
    }
    
    public String toString() {
        String resepti = this.nimi + ": \n";
        
        for (Ainesosa ainesosa : this.ainesosat.keySet()) {
            resepti += ainesosa.toString() + ": " + this.ainesosat.get(ainesosa) + " cl";
        }
        
        return resepti;
    }
}
