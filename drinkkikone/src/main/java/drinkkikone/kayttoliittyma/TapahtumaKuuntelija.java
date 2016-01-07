
package drinkkikone.kayttoliittyma;

import drinkkikone.domain.Drinkkikone;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 * Drinkkikoneen graafista käyttöliittymää varten tehty ActionListener
 * 
 */
public class TapahtumaKuuntelija implements ActionListener {
    
    private Drinkkikone drinkkikone;
    private JTextArea kohde;
    
    public TapahtumaKuuntelija(Drinkkikone drinkkikone, JTextArea kohde) {
        this.drinkkikone = drinkkikone;
        this.kohde = kohde;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.toString().contains("mahdolliset")) {
            this.kohde.setText(drinkkikone.naytaValmistettavatDrinkit());
        } else if (e.toString().contains("Satunnainen")) {
            this.kohde.setText(drinkkikone.satunnainenDrinkki().toString());
        } else if (e.toString().contains("kaikki")) {
            this.kohde.setText(drinkkikone.getReseptikirja().toString());
        } else {
            
        }
    }
}
