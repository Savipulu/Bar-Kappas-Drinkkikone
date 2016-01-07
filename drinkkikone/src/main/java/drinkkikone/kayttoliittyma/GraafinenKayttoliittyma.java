package drinkkikone.kayttoliittyma;

import drinkkikone.domain.Drinkkikone;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 * GraafinenKayttoliittyma -luokka on vaihtoehtoinen käyttöliittymä drinkkikoneelle
 * 
 */
public class GraafinenKayttoliittyma implements Runnable{
    private Drinkkikone drinkkikone;
    private JFrame frame;
    private JTextArea ulostulo;

    public GraafinenKayttoliittyma(Drinkkikone drinkkikone) {
        this.drinkkikone = drinkkikone;
        this.ulostulo = new JTextArea();
    }

    @Override
    public void run() {
        frame = new JFrame("Drinkkikone");
        frame.setPreferredSize(new Dimension(750, 600));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());
        
        container.add(luoKeskiNakyma());
        container.add(luoAlaValikko(), BorderLayout.SOUTH);
    }
    
    private JPanel luoAlaValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        
        JButton mahdolliset = new JButton("Näytä mahdolliset drinkit");
        JButton satunnainen = new JButton("Satunnainen drinkki");
        JButton kaikki = new JButton("Näytä kaikki reseptit");
        
        mahdolliset.addActionListener(new TapahtumaKuuntelija(drinkkikone, ulostulo));
        satunnainen.addActionListener(new TapahtumaKuuntelija(drinkkikone, ulostulo));
        kaikki.addActionListener(new TapahtumaKuuntelija(drinkkikone, ulostulo));
        
        panel.add(mahdolliset);
        panel.add(satunnainen);
        panel.add(kaikki);
        
        return panel;
    }
    
    private JPanel luoKeskiNakyma() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        
        panel.add(luoVasenPalkki());
        panel.add(ulostulo);
        
        return panel;
    }
    
    private JPanel luoVasenPalkki() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        
        JTextArea baarikaapinSisalto = new JTextArea(drinkkikone.getBaarikaappi().tulostaAinesosatMerkkijonona());
        JLabel otsikkoLaatikko =  new JLabel("Bar Kappa's Drinkkikone");
        JTextArea reseptienNimet = new JTextArea(drinkkikone.getReseptikirja().kaikkiReseptitMerkkijonona());
        
        panel.add(otsikkoLaatikko);
        panel.add(baarikaapinSisalto);
        panel.add(reseptienNimet);
        
        return panel;
    }
    
    public JFrame getFrame() {
        return this.frame;
    }
}

