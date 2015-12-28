package drinkkikone.kayttoliittyma;

import drinkkikone.domain.Drinkkikone;
import java.util.Scanner;

public class Kayttoliittyma {

    private Drinkkikone drinkkikone;
    private Scanner lukija;

    public Kayttoliittyma(Drinkkikone drinkkikone, Scanner lukija) {
        this.drinkkikone = drinkkikone;
        this.lukija = lukija;
    }

    public void suorita() {
        System.out.println("*** Bar Kappa's drinkkikone! ***");
        while (true) {
            tulostaOhjeet();
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            if (komento.equals("1")) {
                //drinkkikone.naytaValmistettavatDrinkit();
            } else if (komento.equals("2")) {
                //drinkkikone.satunnainenDrinkki();
            } else if (komento.equals("3")) {
                drinkkikone.kaikkiReseptit();
            } else if (komento.equals("x")) {
                break;
            } else {
                
            }
        }
    }

    public void tulostaOhjeet() {
        System.out.println("Valitse toiminto: ");
        System.out.println("1 -- Näytä valmistettavissa olevat drinkit");
        System.out.println("2 -- Ehdota satunnaista drinkkiä");
        System.out.println("3 -- Näytä drinkkikoneen kaikki drinkkireseptit");
        System.out.println("x -- Lopeta");
    }
}
