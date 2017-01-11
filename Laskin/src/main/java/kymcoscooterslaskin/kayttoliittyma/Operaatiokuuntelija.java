package kymcoscooterslaskin.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import kymcoscooterslaskin.laskinlogiikka.Laskin;
import kymcoscooterslaskin.laskinlogiikka.Operaatio;

/**
 * Operaatiokuuntelija hoitaa operaationäppäimiin liittyvät toiminnot ja kaikki laskut.
 * @author holmbrob
 */
public class Operaatiokuuntelija implements ActionListener {
    private final JLabel naytto;
    private final JButton m;
    private final JButton mplus;
    private final JButton c;
    private final JButton mmiinus;
    private final JButton plus;
    private final JButton miinus;
    private final JButton kertaus;
    private final JButton jako;
    private final JButton yhtakuin;
    private final Laskin laskin;
    
    /**
     * Konstruktori alustaa laskimen, näytön ja kaikki napit.
     * @param laskin Laskin-rajapintaa toteuttava olio
     * @param naytto JLabel näyttö johon kirjoitetaan vastaukset
     * @param napit lista JButton-napeista
     */
    public Operaatiokuuntelija(Laskin laskin, JLabel naytto, List<JButton> napit) {
        this.laskin = laskin;
        this.naytto = naytto;
        this.m = napit.get(0);
        this.mplus = napit.get(1);
        this.mmiinus = napit.get(2);
        this.c = napit.get(3);
        this.plus = napit.get(4);
        this.miinus = napit.get(5);
        this.kertaus = napit.get(6);
        this.jako = napit.get(7);
        this.yhtakuin = napit.get(8);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "M" :
                memory();
                break;
            case "M+" :
                mplus();
                break;
            case "M-" :
                mmiinus();
                break;
            case "C" :
                nollaa();
                break;
            case "+" :
                operaatio("plus");
                break;
            case "-" : 
                operaatio("miinus");
                break;
            case "*" :
                operaatio("kertaus");
                break;
            case "/" :
                operaatio("jako");
                break;
            case "=" :
                yhtakuin();
                break;
        }
    }
    
    private void memory() {
        if (laskin.memory() != 0) {
            naytto.setText(Double.toString(laskin.memory()));
        }
    }
    
    private void mplus() {
        if (!naytto.getText().isEmpty() && !naytto.getText().equals("ERROR")) {
            if (laskin.memory() == 0) {
                laskin.mplus(Double.parseDouble(naytto.getText()));
                naytto.setText("");
            }
        }
    }
    
    private void mmiinus() {
        laskin.mmiinus();
    }
    
    private void nollaa() {
        laskin.nollaa();
        naytto.setText("");
    }
    
    private void operaatio(String oper) {
        laskin.plus(Double.parseDouble(naytto.getText()));
        naytto.setText("");
        switch (oper) {
            case "plus" :
                laskin.setOperaatio(Operaatio.PLUS);
                break;
            case "miinus" :
                laskin.setOperaatio(Operaatio.MIINUS);
                break;
            case "kertaus" :
                laskin.setOperaatio(Operaatio.KERTAUS);
                break;
            case "jako" :
                laskin.setOperaatio(Operaatio.JAKO);
                break;
        }
    }
    
    private void yhtakuin() {
        if (!naytto.getText().isEmpty()) {
            double arvo = Double.parseDouble(naytto.getText());
            boolean totuus = true;
            if (laskin.getOperaatio() == (Operaatio.PLUS)) {
                laskin.plus(arvo);
            }
            if (laskin.getOperaatio() == Operaatio.MIINUS) {
                laskin.miinus(arvo);
            }
            if (laskin.getOperaatio() == Operaatio.KERTAUS) {
                laskin.kertaa(arvo);
            }
            if (laskin.getOperaatio() == Operaatio.JAKO) {
                if (!laskin.jako(arvo)) {
                    totuus = false;
                }
            }
            if (laskin.getOperaatio() == null) {
                return;
            }
            if (totuus) {
                String vastaus = Double.toString(laskin.getArvo());
                if (vastaus.length() > 12) {
                    if (vastaus.contains("E")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(vastaus.substring(0, 8));
                        sb.append(vastaus.substring(vastaus.length() - 3, vastaus.length()));
                        vastaus = sb.toString();
                    } else {
                        vastaus = vastaus.substring(0, 11);
                    }
                }
                naytto.setText(vastaus);
            } else {
                naytto.setText("ERROR");
            }
            laskin.setOperaatio(null);
            laskin.nollaa();
        }
    }    
}
