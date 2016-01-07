package drinkkikone.kayttoliittyma;

import drinkkikone.domain.Drinkkikone;
import java.util.Scanner;

public class TekstiKayttoliittyma {

    private Drinkkikone drinkkikone;
    private Scanner lukija;

    public TekstiKayttoliittyma(Drinkkikone drinkkikone, Scanner lukija) {
        this.drinkkikone = drinkkikone;
        this.lukija = lukija;
    }
    
    /**
     * Metodi käynnistää drinkkikoneen
     */
    public void suorita() {
        System.out.println("*** Bar Kappa's drinkkikone! ***");
        while (true) {
            tulostaOhjeet();
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            if (komento.equals("1")) {
                System.out.println("");
                System.out.println(drinkkikone.naytaValmistettavatDrinkit());
            } else if (komento.equals("2")) {
                System.out.println("");
                System.out.println(drinkkikone.satunnainenDrinkki());
            } else if (komento.equals("3")) {
                System.out.println("");
                System.out.println(drinkkikone.getReseptikirja().toString());
            } else if (komento.equals("x")) {
                break;
            } else {
                
            }
        }
    }

    /**
     * Metodi tulostaa drinkkikoneessa käytettävät komennot
     */
    public void tulostaOhjeet() {
        System.out.println("Valitse toiminto: ");
        System.out.println("1 -- Näytä valmistettavissa olevat drinkit");
        System.out.println("2 -- Ehdota satunnaista drinkkiä");
        System.out.println("3 -- Näytä drinkkikoneen kaikki drinkkireseptit");
        System.out.println("x -- Lopeta");
    }
}
