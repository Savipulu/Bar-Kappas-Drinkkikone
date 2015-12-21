
package drinkkikone.domain;

import java.util.ArrayList;
import java.util.List;

public class Reseptikirja {
    private List<Resepti> reseptit;
    
    public Reseptikirja() {
        this.reseptit = new ArrayList<>();
    }
    
    public List<Resepti> getReseptit() {
        return this.reseptit;
    }
}
