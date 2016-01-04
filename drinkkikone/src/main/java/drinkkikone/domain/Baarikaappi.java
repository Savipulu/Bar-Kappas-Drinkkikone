
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
    
    public Map<Ainesosa, Double> getBaarikaapinSisalto() {
        return this.ainesosat;
    }
    
    public List<Ainesosa> getBaarikaapinAinesosienNimet() {
        ArrayList<Ainesosa> ainekset = new ArrayList();
        ainekset.addAll(this.ainesosat.keySet());
        return ainekset;
    }
    
    public double getAinesosanMaaraBaarikaapissa(Ainesosa a) {
        if (this.ainesosat.containsKey(a)) {
            return this.ainesosat.get(a);
        }
        return 0.0;
    }
    
    /**
     * metodi kertoo onko baarikaappi tyhjä
     * 
     * @return onko baarikappi tyhjä
     */
    public boolean onTyhja() {
        if (this.ainesosat.keySet().size() == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Metodi lisaa baarikaapin hajautustauluun ainesosan ja ainesosan määrän 
     * baarikaapissa
     * 
     * @param ainesosa baarikaappiin lisättävä ainesosa
     * @param maara ainesosan määrä baarikaapissa
     */
    public void lisaaAinesosa(Ainesosa ainesosa, double maara) {
        if (this.ainesosat.containsKey(ainesosa)) {
            double alkuperainenMaara = this.ainesosat.get(ainesosa);
            this.ainesosat.put(ainesosa, (maara + alkuperainenMaara));
        } else {
            this.ainesosat.put(ainesosa, maara);
        }
    }
    
    /**
     * Metodi lisaa kokonaisen hajautustaulun sisällön baarikaappiin
     * 
     * @param ainesosat baarikaappiin lisättävien ainesosien hajautustaulu
     */
    public void lisaaUseaAinesosa(Map<Ainesosa, Double> ainesosat) {
        for (Ainesosa ainesosa : ainesosat.keySet()) {
            lisaaAinesosa(ainesosa, ainesosat.get(ainesosa));
        }
    }
}
