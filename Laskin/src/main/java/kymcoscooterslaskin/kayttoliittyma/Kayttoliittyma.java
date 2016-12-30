package kymcoscooterslaskin.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import kymcoscooterslaskin.laskinlogiikka.Laskin;

public class Kayttoliittyma implements Runnable{
    
    private JFrame frame;
    private Laskin laskin;

    public Kayttoliittyma(Laskin laskin) {
        this.laskin = laskin;
    }
    
    
    @Override
    public void run() {
        frame = new JFrame("KYMCOLASKIN");
        frame.setPreferredSize(new Dimension(300, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(6, 1));
        
        JLabel naytto = new JLabel("");
        naytto.setEnabled(false);
        container.add(naytto);
        
        JButton m = new JButton("M");
        JButton mplus = new JButton("M+");
        JButton mmiinus = new JButton("M-");
        JButton c = new JButton("C");
        container.add(luopaneeli(m, mplus, mmiinus, c));
        
        JButton ykkonen = new JButton("1");
        JButton kakkonen = new JButton("2");
        JButton kolmonen = new JButton("3");
        JButton plus = new JButton("+");
        container.add(luopaneeli(ykkonen, kakkonen, kolmonen, plus));
        
        JButton nelonen = new JButton("4");
        JButton vitonen = new JButton("5");
        JButton kutonen = new JButton("6");
        JButton miinus = new JButton("-");
        container.add(luopaneeli(nelonen, vitonen, kutonen, miinus));
        
        JButton seiska = new JButton("7");
        JButton kasi = new JButton("8");
        JButton ysi = new JButton("9");
        JButton kertaus = new JButton("*");
        container.add(luopaneeli(seiska, kasi, ysi, kertaus));
        
        JButton pilkku = new JButton(",");
        JButton nolla = new JButton("0");
        JButton yhtakuin = new JButton("=");
        JButton jako = new JButton("/");
        container.add(luopaneeli(pilkku, nolla, yhtakuin, jako));
        
        ArrayList<JButton> napit = new ArrayList<>();
        napit.add(ykkonen);
        napit.add(kakkonen);
        napit.add(kolmonen);
        napit.add(nelonen);
        napit.add(vitonen);
        napit.add(kutonen);
        napit.add(seiska);
        napit.add(kasi);
        napit.add(ysi);
        napit.add(nolla);
        napit.add(m);
        napit.add(mplus);
        napit.add(mmiinus);
        napit.add(c);
        napit.add(pilkku);
        napit.add(yhtakuin);
        napit.add(plus);
        napit.add(miinus);
        napit.add(kertaus);
        napit.add(jako);
        
        Klikkaustenkuuntelija k = new Klikkaustenkuuntelija(laskin, naytto, napit);
        
        for (JButton nappi : napit) {
            nappi.addActionListener(k);
        }
    }
    
    private JPanel luopaneeli(JButton eka, JButton toka, JButton kolmas, JButton neljas) {
        JPanel panel = new JPanel(new GridLayout(1, 4));
        panel.add(eka);
        panel.add(toka);
        panel.add(kolmas);
        panel.add(neljas);
        return panel;
    }
    
}
