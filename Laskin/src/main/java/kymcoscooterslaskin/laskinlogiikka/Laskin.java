package kymcoscooterslaskin.laskinlogiikka;

public interface Laskin {
    void plus(double arvo);
    void miinus(double arvo);
    void kertaa(double arvo);
    boolean jako(double arvo);
    void mplus(double arvo);
    void mmiinus();
    double memory();
    void nollaa();
    double yhtakuin();
    double getArvo();
    void setOperaatio(Operaatio o);
    Operaatio getOperaatio();
}
