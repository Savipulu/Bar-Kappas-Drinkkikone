
package drinkkikone.drinkkikone;

import drinkkikone.domain.Ainesosa;
import drinkkikone.domain.Baarikaappi;
import drinkkikone.domain.Drinkkikone;
import drinkkikone.domain.Resepti;
import drinkkikone.domain.Reseptikirja;
import drinkkikone.kayttoliittyma.Kayttoliittyma;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Baarikaappi baarikaappi = new Baarikaappi();
        Reseptikirja reseptikirja = new Reseptikirja();
        Drinkkikone drinkkikone = new Drinkkikone(baarikaappi, reseptikirja);
        Scanner lukija = new Scanner(System.in);
        
        HashMap ainesosat = new HashMap<Ainesosa, Integer>();
        ainesosat.put(new Ainesosa("Vermutti", 20), 6);
        ainesosat.put(new Ainesosa("Gin", 15), 1);
        Resepti r = new Resepti("Gin & Tonic", ainesosat);
        
        drinkkikone.lisaaResepti(r);
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(drinkkikone, lukija);
        
        kayttoliittyma.suorita();
    }
}
