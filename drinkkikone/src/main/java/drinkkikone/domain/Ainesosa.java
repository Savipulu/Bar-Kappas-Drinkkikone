
package drinkkikone.domain;

public class Ainesosa {
    private String nimi;
    private double alkoholipitoisuus;
    private double maara;
    
    public Ainesosa(String nimi, double alkoholipitoisuus, double maara) {
        this.nimi = nimi;
        this.alkoholipitoisuus = alkoholipitoisuus;
        this.maara = maara;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public double getAlkoholipitoisuus() {
        return this.alkoholipitoisuus;
    }
    
    public double getMaara() {
        return this.maara;
    }
    
    
}
