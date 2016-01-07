
package drinkkikone.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Resepti -luokka säilyttää tiedot yksittäisen drinkin valmistamiseen tarvittavien
 * ainesosien määrästä ja ohjeen drinkin valmistamiseen
 */
public class Resepti {
    private String nimi;
    private Map<Ainesosa, Double> ainesosat;
    private String valmistusohje;
    
    public Resepti(String nimi) {
        this.nimi = nimi;
        this.ainesosat = new HashMap<>();
        this.valmistusohje = "";
    }
    
    public Resepti(String nimi, Map<Ainesosa, Double> ainesosat) {
        this(nimi);
        lisaaUseaAinesosa(ainesosat);
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public void setValmistusohje(String valmistusohje) {
        this.valmistusohje = valmistusohje;
    }
    
    public String getValmistusohje() {
        return this.valmistusohje;
    }
    
    public List<Ainesosa> getAinesosat() {
        ArrayList<Ainesosa> ainesosat = new ArrayList<>();
        ainesosat.addAll(this.ainesosat.keySet());
        return ainesosat;
    }
    
    public Map<Ainesosa, Double> getAinesosatJaMaarat() {
        return this.ainesosat;
    }
    
    /**
     * Metodi tallettaa hajautustauluun avaimeksi ainesosan, ja arvopariksi
     * reseptin valmistamiseen tarvittavan aineosan määrän
     * 
     * @param ainesosa Lisättävä ainesosa
     * @param maara Määrä liukulukuna
     */
    public void lisaaAinesosa(Ainesosa ainesosa, double maara) {
        this.ainesosat.put(ainesosa, maara);
    }
    
    /**
     * Metodi lisää sille annetun hajautustaulun aineosat ja määrät yksi kerrallaan
     * reseptin ainesosiin
     * 
     * @param ainesosat Lisättävien ainesosien hajautustaulu
     */
    public void lisaaUseaAinesosa(Map<Ainesosa, Double> ainesosat) {
        for (Ainesosa ainesosa : ainesosat.keySet()) {
            lisaaAinesosa(ainesosa, ainesosat.get(ainesosa));
        }
    }
    
    public String toString() {
        String resepti = this.nimi + ":\n";
        int i = 0;
        List<Ainesosa> ainekset = getAinesosat();
        ainekset.sort(null);
        
        for (Ainesosa ainesosa : ainekset) {
            resepti += "  " + ainesosa.toString() + ": " + this.ainesosat.get(ainesosa) + " cl";
            if (i != (this.ainesosat.keySet().size() - 1)) {
                resepti += ",";
            }
            resepti += "\n";
            i++;
        }
        resepti += "\n  Valmistusohje: " + this.getValmistusohje() + "\n";
        
        return resepti;
    }
}
