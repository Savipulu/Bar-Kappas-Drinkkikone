
package drinkkikone.drinkkikone;

import drinkkikone.domain.Baarikaappi;
import drinkkikone.domain.Drinkkikone;
import drinkkikone.domain.Resepti;
import drinkkikone.domain.Reseptikirja;

public class Main {

    public static void main(String[] args) {
        Baarikaappi baarikaappi = new Baarikaappi();
        Reseptikirja reseptikirja = new Reseptikirja();
        Drinkkikone drinkkikone = new Drinkkikone(baarikaappi, reseptikirja);
        Resepti r = new Resepti("resepti");
        System.out.println(r.getAinesosat());
    }
}
