
package drinkkikone.domain;

public class Ainesosa {
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
}
