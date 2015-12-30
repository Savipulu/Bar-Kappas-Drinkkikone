
package drinkkikone.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Baarikaappi -luokka säilyttää baarikaapin sisältämät ainekset, pitäen kirjaa
 * niiden määrästä baarikaapissa
 */
public class Baarikaappi {
    private Map<Ainesosa, Double> ainesosat;
    
    public Baarikaappi() {
        this.ainesosat = new HashMap<>();
    }
    
    public List<Ainesosa> getBaarikaapinAinesosat() {
        ArrayList<Ainesosa> ainekset = new ArrayList();
        ainekset.addAll(this.ainesosat.keySet());
        return ainekset;
    }
    
    public double getAinesosanMaaraBaarikaapissa(Ainesosa a) {
        
        return 0.0;
    }
    
    public boolean onTyhja() {
        if (this.ainesosat.keySet().size() == 0) {
            return true;
        }
        return false;
    }
    
    public void lisaaAinesosa(Ainesosa a, double maara) {
        this.ainesosat.put(a, maara);
    }
    
    public void lisaaUseaAinesosa(Map<Ainesosa, Double> ainesosat) {
        this.ainesosat.putAll(ainesosat);
    }
}
