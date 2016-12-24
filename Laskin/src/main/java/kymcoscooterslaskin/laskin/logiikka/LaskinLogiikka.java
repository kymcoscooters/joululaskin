package kymcoscooterslaskin.laskin.logiikka;

public class LaskinLogiikka {
    private double arvo;

    public LaskinLogiikka() {
        this.arvo = 0;
    }

    public double getArvo() {
        return arvo;
    }
    
    public void plus(double luku) {
        arvo += luku;
    }
    
    public void miinus(double luku) {
        arvo -= luku;
    }
    
    public void kertaa(double luku) {
        arvo *= luku;
    }
    
    public void jako(double luku) {
        arvo /= luku;
    }
    
    public void nollaa() {
        arvo = 0;
    }
    
    
}
