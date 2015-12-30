
package drinkkikone.domain;

/**
 * Ainesosa -luokka tallettaa ainesosan nimen ja alkoholipitoisuuden (alkoholittomillekin
 * ainesosille merkataan alkoholipitoisuudeksi 0.0)
 */
public class Ainesosa implements Comparable<Ainesosa>{
    private String nimi;
    private double alkoholipitoisuus;
    
    public Ainesosa(String nimi, double alkoholipitoisuus) {
        this.nimi = nimi;
        this.alkoholipitoisuus = alkoholipitoisuus;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public double getAlkoholipitoisuus() {
        return this.alkoholipitoisuus;
    }
    
    public String toString() {
        return this.nimi;
    }

    @Override
    public int compareTo(Ainesosa a) {
        return this.nimi.compareToIgnoreCase(a.getNimi());
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        
        if (this.getClass() != o.getClass()) {
            return false;
        }
        
        Ainesosa verrattava = (Ainesosa) o;
        
        if (!this.nimi.equals(verrattava.getNimi())) {
            return false;
        }
        
        return true;
    }
}
