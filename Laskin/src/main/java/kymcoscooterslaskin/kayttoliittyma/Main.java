package kymcoscooterslaskin.kayttoliittyma;

import javax.swing.SwingUtilities;
import kymcoscooterslaskin.laskinlogiikka.LaskinLogiikka;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Kayttoliittyma(new LaskinLogiikka()));
    }
}
