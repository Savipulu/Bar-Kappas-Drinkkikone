
package drinkkikone.domain;

public class Drinkkikone {
    private Baarikaappi baarikaappi;
    private Reseptikirja reseptikirja;
    
    public Drinkkikone(Baarikaappi baarikaappi, Reseptikirja reseptikirja) {
        this.baarikaappi = baarikaappi;
        this.reseptikirja = reseptikirja;
    }
    
    public Baarikaappi getBaarikaappi() {
        return this.baarikaappi;
    }
    
    public Reseptikirja getReseptikirja() {
        return this.reseptikirja;
    }
}
