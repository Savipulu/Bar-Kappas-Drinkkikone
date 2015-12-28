
package drinkkikone.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    
    public List<Ainesosa> getAinesosat() {
        ArrayList<Ainesosa> ainesosat = new ArrayList<>();
        ainesosat.addAll(this.ainesosat.keySet());
        return ainesosat;
    }
    
    public void lisaaAinesosa(Ainesosa ainesosa, int maara) {
        this.ainesosat.put(ainesosa, maara);
    }
    
    public String toString() {
        String resepti = this.nimi + ": \n";
        int i = 0;
        
        for (Ainesosa ainesosa : this.ainesosat.keySet()) {
            resepti += "  " + ainesosa.toString() + ": " + this.ainesosat.get(ainesosa) + " cl";
            if (i != (this.ainesosat.keySet().size() - 1)) {
                resepti += ", \n";
            }
            i++;
        }
        
        return resepti;
    }
}
