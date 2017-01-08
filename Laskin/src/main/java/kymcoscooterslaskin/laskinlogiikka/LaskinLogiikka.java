package kymcoscooterslaskin.laskinlogiikka;

/**
 * Luokka tarjoaa laskuoperaatiot ja muu toiminta klikkaustenkuuntelijalle.
 * 
 * @author holmbrob
 */
public class LaskinLogiikka implements Laskin {
    private double arvo;
    private double memory;
    private Operaatio operaatio;
    
    /**
     * Konstruktori alustaa oliomuuttujat arvo ja memory.
     */
    public LaskinLogiikka() {
        arvo = 0;
        memory = 0;
    }
    
    /**
     * Metodi lisää laskimen arvoon parametrina annetun arvon.
     * 
     * @param arvo arvo jonka käyttäjä on syöttänyt numeronäppäimillä
     */
    @Override
    public void plus(double arvo) {
        this.arvo += arvo;
    }
    
    /**
     * Metodi poistaa laskimen arvosta parametrina annetun arvon.
     * 
     * @param arvo arvo jonka käyttäjä on syöttänyt numeronäppäimillä
     */
    @Override
    public void miinus(double arvo) {
        this.arvo -= arvo;
    }
    
    /**
     * Metodi kertaa laskimen arvon parametrina annetulla arvolla.
     * 
     * @param arvo arvo jonka käyttäjä on syöttänyt numeronäppäimillä
     */
    @Override
    public void kertaa(double arvo) {
        this.arvo *= arvo;
    }
    
    /**
     * Metodi jakaa laskimen arvon parametrina annetulla arvolla.
     * 
     * @param arvo arvo jonka käyttäjä on syöttänyt numeronäppäimillä
     * 
     * @return palauttaa false jos käyttäjä on syöttänyt nollan, muuten palauttaa true
     */
    @Override
    public boolean jako(double arvo) {
        if (arvo != 0) {
            this.arvo /= arvo;
            return true;
        } else {
            this.arvo = 0;
            return false;
        }
    }
    
    /**
     * Metodi lisää laskimen ns muistiin arvon myöhempää käyttöä varten.
     * 
     * @param arvo arvo jonka käyttäjä on syöttänyt numeronäppäimillä
     */
    @Override
    public void mplus(double arvo) {
        memory = arvo;
    }
    
    /**
     * Metodi poistaa arvon muistista.
     */
    @Override
    public void mmiinus() {
        memory = 0;
    }
    
    /**
     * Metodi palauttaa muistissa olevan arvon käyttöä varten.
     * 
     * @return palauttaa muistissa olevan arvon
     */
    @Override
    public double memory() {
        return memory;
    }
    
    /**
     * Metodi nollaa laskimen.
     */
    @Override
    public void nollaa() {
        arvo = 0;
    }
    
    @Override
    public double getArvo() {
        return arvo;
    }
    
    @Override
    public void setOperaatio(Operaatio o) {
        operaatio = o;
    }

    @Override
    public Operaatio getOperaatio() {
        return operaatio;
    }
    
}
