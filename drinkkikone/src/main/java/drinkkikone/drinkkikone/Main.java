
package drinkkikone.drinkkikone;

import drinkkikone.domain.Baarikaappi;
import drinkkikone.domain.Drinkkikone;
import drinkkikone.domain.Resepti;
import drinkkikone.domain.Reseptikirja;
import drinkkikone.kayttoliittyma.Kayttoliittyma;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Baarikaappi baarikaappi = new Baarikaappi();
        Reseptikirja reseptikirja = new Reseptikirja();
        Drinkkikone drinkkikone = new Drinkkikone(baarikaappi, reseptikirja);
        Scanner lukija = new Scanner(System.in);
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(drinkkikone, lukija);
        
        kayttoliittyma.suorita();
    }
}
