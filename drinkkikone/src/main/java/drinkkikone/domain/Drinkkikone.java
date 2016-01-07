
package drinkkikone.domain;

import java.util.Random;

/**
 * Drinkkikone -luokka hallinnoi sille luotuja baarikaappia ja reseptikirjaa, 
 * ja huolehtii niiden välisestä yhteistyöstä
 */
public class Drinkkikone {
    private Baarikaappi baarikaappi;
    private Reseptikirja reseptikirja;
    private Random random;
    
    public Drinkkikone(Baarikaappi baarikaappi, Reseptikirja reseptikirja) {
        this.baarikaappi = baarikaappi;
        this.reseptikirja = reseptikirja;
        this.random = new Random();
    }
    
    public Baarikaappi getBaarikaappi() {
        return this.baarikaappi;
    }
    
    public Reseptikirja getReseptikirja() {
        return this.reseptikirja;
    }
    
    /**
     * Metodi lisää drinkkikoneen reseptikirjaan uuden reseptin
     * 
     * @param r Lisättävä resepti 
     */
    public void lisaaResepti(Resepti r) {
        this.reseptikirja.lisaaResepti(r);
    }
    
    /**
     * Metodi palauttaa drinkkikoneen reseptikirjan reseptien nimet merkkijonoesityksenä
     * 
     * @return Drinkkikoneen reseptien nimet
     */
    public String kaikkiReseptit() {
        return this.reseptikirja.kaikkiReseptitMerkkijonona();
    }
    
    /**
     * Metodi palauttaa satunnaisesti valitun drinkin valmistettavissa olevista
     * drinkeistä
     * 
     * @return Satunnainen drinkki
     */
    public Resepti satunnainenDrinkki() {
        Resepti r = null;
        if (!baarikaappi.onTyhja() && onMahdollisiaDrinkkeja()) {
            while (true) {
                int i = random.nextInt(reseptikirja.getKaikkiReseptit().size());
                r = reseptikirja.getResepti(i);
                if (aineksetLoytyy(r)) {
                    break;
                }
            }
        }
        return r;
    }
    
    /**
     * Metodi tarkistaa yksi ainesosa kerrallaan onko baarikaapissa reseptin 
     * valmistamiseen tarvittavia ainesosia tarpeeksi
     * 
     * @param r Tarkistettava resepti
     * 
     * @return Totuusarvo siitä onko drinkki mahdollista valmistaa
     */
    public boolean aineksetLoytyy(Resepti r) {
        if (baarikaappi.onTyhja()) {
            return false;
        }
        
        for (Ainesosa ainesosa : r.getAinesosat()) {
            if (baarikaappi.getAinesosanMaaraBaarikaapissa(ainesosa) < r.getAinesosatJaMaarat().get(ainesosa)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Metodi näyttää merkkijonona kaikki drinkkireseptit, jotka ovat valmistettavissa
     * baarikaapin sisältämillä ainesosilla
     * 
     * @return Merkkijonoesitys mahdollisista drinkeistä 
     */
    public String naytaValmistettavatDrinkit() {
        String drinkit = "---\n";
        for (Resepti resepti : reseptikirja.getKaikkiReseptit()) {
            if (aineksetLoytyy(resepti)) {
                drinkit += resepti.toString();
                drinkit += "\n---\n";
            }
        }
        return drinkit;
    }
    
    /**
     * Metodi tarkistaa onko baarikaapin sisällöstä mahdollista tehdä reseptikirjassa
     * tunnettuja reseptejä
     * 
     * @return Totuusarvo siitä, onko mahdollisia drinkkejä
     */
    public boolean onMahdollisiaDrinkkeja() {
        for (Resepti resepti : reseptikirja.getKaikkiReseptit()) {
            if (aineksetLoytyy(resepti)) {
                return true;
            }
        }
        return false;
    }
}
