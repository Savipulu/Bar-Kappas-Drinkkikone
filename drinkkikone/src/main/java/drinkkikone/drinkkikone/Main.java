
package drinkkikone.drinkkikone;

import drinkkikone.domain.Baarikaappi;
import drinkkikone.domain.Resepti;

public class Main {

    public static void main(String[] args) {
        Baarikaappi baarikaappi = new Baarikaappi();
        Resepti r = new Resepti("resepti");
        System.out.println(r.getAinesosat());
    }
}
