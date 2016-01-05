
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
        //Perjantain demoa varten Mainiin lisätty pientä testidataa
        Baarikaappi baarikaappi = new Baarikaappi();
        Reseptikirja reseptikirja = new Reseptikirja();
        Scanner lukija = new Scanner(System.in);
        
        Ainesosa vermutti = new Ainesosa("Vermutti", 15.0);
        Ainesosa gin = new Ainesosa("Gin", 40.0);
        Ainesosa tonic = new Ainesosa("Tonic -vesi", 0.0); 
        Ainesosa rommi = new Ainesosa("Rommi", 35.0);
        Ainesosa kola = new Ainesosa("Coca-cola", 0.0);
        
        baarikaappi.lisaaAinesosa(gin, 5.0);
        baarikaappi.lisaaAinesosa(tonic, 20.0);
        baarikaappi.lisaaAinesosa(vermutti, 1.0);
        baarikaappi.lisaaAinesosa(rommi, 100.0);
        baarikaappi.lisaaAinesosa(kola, 100.0);
        
        HashMap<Ainesosa, Double> rommikolanAinesosat = new HashMap<>();
        rommikolanAinesosat.put(rommi, 2.0);
        rommikolanAinesosat.put(kola, 2.0);
        
        Resepti resepti1 = new Resepti("Martini");
        resepti1.lisaaAinesosa(gin, 6.0);
        resepti1.lisaaAinesosa(vermutti, 1.0);
        resepti1.setValmistusohje("Laita ravistimeen jäitä, lisää ainekset ja hämmennä.");
        
        Resepti resepti2 = new Resepti("Gin & Tonic");
        resepti2.lisaaAinesosa(gin, 4.0);
        resepti2.lisaaAinesosa(tonic, 12.0);
        resepti2.setValmistusohje("Täytä lasi puolilleen jäitä, lisää gini ja pidennä tonic-vedellä.");
        
        Resepti resepti3 = new Resepti("Rommikola");
        resepti3.lisaaUseaAinesosa(rommikolanAinesosat);
        resepti3.setValmistusohje("Täytä highball-lasi jääpaloilla. Kaada lasiin ensin rommi ja sitten cola. Sekoita baarilusikalla.");
        
        Drinkkikone drinkkikone = new Drinkkikone(baarikaappi, reseptikirja);
        drinkkikone.lisaaResepti(resepti1);
        drinkkikone.lisaaResepti(resepti2);
        drinkkikone.lisaaResepti(resepti3);
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(drinkkikone, lukija);
        
        kayttoliittyma.suorita();
    }
}
