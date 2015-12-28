
package drinkkikone.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Baarikaappi {
    private Map<Ainesosa, Integer> ainesosat;
    
    public Baarikaappi() {
        this.ainesosat = new HashMap<>();
    }
    
    public List<Ainesosa> getBaarikaapinAinesosat() {
        ArrayList<Ainesosa> ainesosat = new ArrayList();
        ainesosat.addAll(this.ainesosat.keySet());
        return ainesosat;
    }
    
    public boolean onTyhja() {
        if (this.ainesosat.keySet().size() == 0) {
            return true;
        }
        return false;
    }
    
    public void lisaaAinesosa(Ainesosa a, int maara) {
        this.ainesosat.put(a, maara);
    }
    
    public void lisaaUseaAinesosa(Map<Ainesosa, Integer> ainesosat) {
        this.ainesosat.putAll(ainesosat);
    }
}
