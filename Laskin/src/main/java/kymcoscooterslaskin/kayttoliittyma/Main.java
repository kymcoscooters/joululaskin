package kymcoscooterslaskin.kayttoliittyma;

import javax.swing.SwingUtilities;
import kymcoscooterslaskin.laskinlogiikka.LaskinLogiikka;

/**
 * Main-luokka käynnistää laskimen.
 * 
 * @author holmbrob
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Kayttoliittyma(new LaskinLogiikka()));
    }
}
