package kymcoscooterslaskin.laskinlogiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LogiikkaTest {
    
    public LogiikkaTest() {
    }
    
    LaskinLogiikka laskin;
    
    @Before
    public void setUp() {
        laskin = new LaskinLogiikka();
    }

    @Test
    public void plusToimii() {
        laskin.plus(2);
        laskin.plus(3);
        assertEquals(5, laskin.getArvo(), 0.0001);
    }
    
    @Test
    public void miinusTomii() {
        laskin.miinus(3);
        assertEquals(-3, laskin.getArvo(), 0.0001);
    }
    
    @Test
    public void kertaaToimii() {
        laskin.plus(3);
        laskin.kertaa(3);
        assertEquals(9, laskin.getArvo(), 0.0001);
    }
    
    @Test
    public void jakoTomiiKokonasisLuvulla() {
        laskin.plus(4);
        assertTrue(laskin.jako(2));
        assertEquals(2, laskin.getArvo(), 0.0001);
    }
    
    @Test
    public void jakoTomiiDesimaaliLuvulla() {
        laskin.plus(5);
        assertTrue(laskin.jako(2));
        assertEquals(2.5, laskin.getArvo(), 0.0001);
    }
    
    @Test
    public void jakoNollallaPalauttaaFalse() {
        laskin.plus(5);
        assertFalse(laskin.jako(0));
    }
    
    @Test
    public void nollaaTomii() {
        laskin.plus(5);
        laskin.nollaa();
        assertEquals(0, laskin.getArvo(), 0.0001);
    }
    
    @Test
    public void useampiPerakkainTomii() {
        laskin.plus(5);
        laskin.miinus(3);
        laskin.kertaa(2);
        laskin.jako(4);
        assertEquals(1, laskin.getArvo(), 0.0001);
    }
    
    @Test
    public void mplustoimii() {
        laskin.mplus(3);
        assertEquals(3, laskin.memory(), 0.0001);
    }
    
    @Test
    public void mmiinustoimii() {
        laskin.mplus(3);
        laskin.mmiinus();
        assertEquals(0, laskin.memory(), 0.0001);
    }
    
    @Test
    public void operaationlisaystoimii() {
        laskin.setOperaatio(Operaatio.JAKO);
        assertEquals(Operaatio.JAKO, laskin.getOperaatio());
    }
}
