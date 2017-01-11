package kymcoscooterslaskin.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *Numerokuuntelija hoitaa numeronäppäimiin sekä pilkku-näppäimeen liittyvät toimenpiteet. 
 * @author holmbrob
 */
public class Numerokuuntelija implements ActionListener {
    private final JLabel naytto;
    private final JButton ykkonen;
    private final JButton kakkonen;
    private final JButton kolmonen;
    private final JButton nelonen;
    private final JButton vitonen;
    private final JButton kutonen;
    private final JButton seiska;
    private final JButton kasi;
    private final JButton ysi;
    private final JButton nolla;
    private final JButton pilkku;
    
    /**
     * Konstruktori alustaa JLabel näytön ja kaikki JButton napit.
     * 
     * @param naytto laskimen näyttö josta otetaan tekstiä ja lisätään tekstiä
     * @param napit lista kaikista numeronäppäimistä sekä pilkku-näppäimestä
     */
    public Numerokuuntelija(JLabel naytto, List<JButton> napit) {
        this.naytto = naytto;
        ykkonen = napit.get(0);
        kakkonen = napit.get(1);
        kolmonen = napit.get(2);
        nelonen = napit.get(3);
        vitonen = napit.get(4);
        kutonen = napit.get(5);
        seiska = napit.get(6);
        kasi = napit.get(7);
        ysi = napit.get(8);
        nolla = napit.get(9);
        pilkku = napit.get(10);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "1" :
                lisaaNumero(1);
                break;
            case "2" :
                lisaaNumero(2);
                break;
            case "3" :
                lisaaNumero(3);
                break;
            case "4" :
                lisaaNumero(4);
                break;
            case "5" :
                lisaaNumero(5);
                break;
            case "6" :
                lisaaNumero(6);
                break;
            case "7" :
                lisaaNumero(7);
                break;
            case "8" :
                lisaaNumero(8);
                break;
            case "9" :
                lisaaNumero(9);
                break;
            case "0" :
                lisaaNolla();
                break;
            case "," :
                lisaaPilkku();
                break;
        }
    }
    
    private void lisaaNumero(int i) {
        if (naytto.getText().length() < 12) {
            StringBuilder sb = new StringBuilder();
            if (!naytto.getText().equals("")) {
                sb.append(naytto.getText());
            }
            sb.append(Integer.toString(i));
            naytto.setText(sb.toString());
        }
    }
    
    private void lisaaNolla() {
        if (!naytto.getText().equals("0") && naytto.getText().length() < 12) {
            StringBuilder sb = new StringBuilder();
            sb.append(naytto.getText());
            sb.append("0");
            naytto.setText(sb.toString());
        }
    }
    
    private void lisaaPilkku() {
        if (!naytto.getText().contains(".") && naytto.getText().length() < 12) {
            StringBuilder sb = new StringBuilder();
            sb.append(naytto.getText());
            sb.append(".");
            naytto.setText(sb.toString());
        }
    }
}
