package kymcoscooterslaskin.kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import kymcoscooterslaskin.laskinlogiikka.Laskin;

/**
 * Käyttöliittymä piirtää laskimen ja tarjoaa näppäimet ja näytön
 * käyttäjää varten, napinpainallukset lähetetään eteenpäin
 * klikkaustenkuuntelijalle.
 * 
 * @author holmbrob
 */
public class Kayttoliittyma implements Runnable {
    
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
        frame.setResizable(false);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(6, 1));
        
        JLabel naytto = new JLabel("");
        naytto.setFont(new Font("Serif", Font.PLAIN, 40));
        container.add(naytto);
        
        List<JButton> numer = luoNumeroNapit();
        List<JButton> oper = luoOperaatioNapit();
        
        container.add(luopaneeli(oper.get(0), oper.get(1), oper.get(2), oper.get(3)));
        container.add(luopaneeli(numer.get(0), numer.get(1), numer.get(2), oper.get(4)));
        container.add(luopaneeli(numer.get(3), numer.get(4), numer.get(5), oper.get(5)));
        container.add(luopaneeli(numer.get(6), numer.get(7), numer.get(8), oper.get(6)));
        container.add(luopaneeli(numer.get(10), numer.get(9), oper.get(8), oper.get(7)));
        
        Numerokuuntelija nk = new Numerokuuntelija(naytto, numer);
        Operaatiokuuntelija ok = new Operaatiokuuntelija(laskin, naytto, oper);
        
        for (JButton jb : numer) {
            jb.addActionListener(nk);
        }
        for (JButton jb : oper) {
            jb.addActionListener(ok);
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
    
    private List<JButton> luoNumeroNapit() {
        List<JButton> lista = new ArrayList<>();
        lista.add(new JButton("1"));
        lista.add(new JButton("2"));
        lista.add(new JButton("3"));
        lista.add(new JButton("4"));
        lista.add(new JButton("5"));
        lista.add(new JButton("6"));
        lista.add(new JButton("7"));
        lista.add(new JButton("8"));
        lista.add(new JButton("9"));
        lista.add(new JButton("0"));
        lista.add(new JButton(","));
        return lista;
    }
    
    private List<JButton> luoOperaatioNapit() {
        List<JButton> lista = new ArrayList<>();
        lista.add(new JButton("M"));
        lista.add(new JButton("M+"));
        lista.add(new JButton("M-"));
        lista.add(new JButton("C"));
        lista.add(new JButton("+"));
        lista.add(new JButton("-"));
        lista.add(new JButton("*"));
        lista.add(new JButton("/"));
        lista.add(new JButton("="));
        return lista;
    }
    
}
