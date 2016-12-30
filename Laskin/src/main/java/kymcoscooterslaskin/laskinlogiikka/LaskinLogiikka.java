package kymcoscooterslaskin.laskinlogiikka;

public class LaskinLogiikka implements Laskin{
    private double arvo;
    private double memory;

    public LaskinLogiikka() {
        arvo = 0;
        memory = 0;
    }
    
    @Override
    public void plus(double arvo) {
        this.arvo += arvo;
    }

    @Override
    public void miinus(double arvo) {
        this.arvo -= arvo;
    }

    @Override
    public void kertaa(double arvo) {
        this.arvo *= arvo;
    }

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

    @Override
    public void mplus(double arvo) {
        memory = arvo;
    }

    @Override
    public void mmiinus() {
        memory = 0;
    }

    @Override
    public double memory() {
        return memory;
    }

    @Override
    public void nollaa() {
        arvo = 0;
    }

    @Override
    public double yhtakuin() {
        return arvo;
    }
    
    
    
}
