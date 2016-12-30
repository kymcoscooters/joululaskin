package kymcoscooterslaskin.kayttoliittyma;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import kymcoscooterslaskin.laskinlogiikka.Laskin;

public class Klikkaustenkuuntelija implements ActionListener{
    private Laskin laskin;
    private JLabel naytto;
    private JButton ykkonen;
    private JButton kakkonen;
    private JButton kolmonen;
    private JButton nelonen;
    private JButton vitonen;
    private JButton kutonen;
    private JButton seiska;
    private JButton kasi;
    private JButton ysi;
    private JButton nolla;
    private JButton m;
    private JButton mplus;
    private JButton mmiinus;
    private JButton c;
    private JButton pilkku;
    private JButton yhtakuin;
    private JButton plus;
    private JButton miinus;
    private JButton kertaus;
    private JButton jako;

    public Klikkaustenkuuntelija(Laskin laskin, JLabel naytto, List<JButton> napit) {
        this.laskin = laskin;
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
        m = napit.get(10);
        mplus = napit.get(11);
        mmiinus = napit.get(12);
        c = napit.get(13);
        pilkku = napit.get(14);
        yhtakuin = napit.get(15);
        plus = napit.get(16);
        miinus = napit.get(17);
        kertaus = napit.get(18);
        jako = napit.get(19);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ykkonen || e.getSource() == kakkonen || e.getSource() == kolmonen
                || e.getSource() == nelonen || e.getSource() == vitonen ||
                e.getSource() == kutonen || e.getSource() == seiska || 
                e.getSource() == kasi || e.getSource() == ysi || e.getSource() == nolla) {
            numerot(e);
        }
    }
    
    private void numerot(ActionEvent e) {
        StringBuilder sb = new StringBuilder();
        if (!naytto.getText().equals("")) {
            sb.append(naytto.getText());
        }
        if (e.getSource() == ykkonen) {
            sb.append("1");
        } else if (e.getSource() == kakkonen) {
            sb.append("2");
        } else if (e.getSource() == kolmonen) {
            sb.append("3");
        } else if (e.getSource() == nelonen) {
            sb.append("4");
        } else if (e.getSource() == vitonen) {
            sb.append("5");
        } else if (e.getSource() == kutonen) {
            sb.append("6");
        } else if (e.getSource() == seiska) {
            sb.append("7");
        } else if (e.getSource() == kasi) {
            sb.append("8");
        } else if (e.getSource() == ysi) {
            sb.append("9");
        } else if (e.getSource() == nolla) {
            sb.append("0");
        }
        naytto.setText(sb.toString());
    }
    
}
