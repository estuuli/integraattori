package integraattori.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import integraattori.logiikka.FunktionArvot;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elina
 */
public class FunktionArvotTest {
    
    public FunktionArvotTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void sinFunktioLaskeeArvonOikein() {
        FunktionArvot siniFunktio = new FunktionArvot("sin x");
        double vastaus = siniFunktio.funktionArvoPisteessa(0);
        assertEquals(0.0, vastaus, 0.00001);
    }
    
    @Test
    public void sinFunktioLaskeeArvonOikein2() {
        FunktionArvot siniFunktio = new FunktionArvot("sin x");
        double vastaus = siniFunktio.funktionArvoPisteessa(Math.PI/12);
        assertEquals(0.25881, vastaus, 0.00001);
    }
    
    @Test
    public void polynomiFunktionArvoLasketaanOikein() {
        FunktionArvot funktio = new FunktionArvot("x^5 + 6x^4 + 3x -5");
        double vastaus = funktio.funktionArvoPisteessa(0);
        assertEquals(-5.0, vastaus, 0.00001);
    }
    
    @Test
    public void polynomiFunktionArvoLasketaanOikein2() {
        FunktionArvot funktio = new FunktionArvot("x^5 + 6x^4 + 3x -5");
        double vastaus = funktio.funktionArvoPisteessa(Math.sqrt(2));
        assertEquals(28.89949, vastaus, 0.00001);
    }
    
    @Test
    public void funktionArvotLasketaanKaikissaAnnetuissaPisteissa() {
        FunktionArvot funktio = new FunktionArvot("sin x + 5");
        ArrayList<Double> pisteet = new ArrayList<>();
        pisteet.add(0.0); 
        pisteet.add(Math.PI/2);
        pisteet.add(Math.PI);
        pisteet.add(3*Math.PI/2);
        ArrayList<Double> vastaus = funktio.laskeFunktionArvot(pisteet);
        assertEquals(vastaus.size(), pisteet.size());
    }
    
    @Test
    public void funktionArvotLasketaanOikeinKaikissaAnnetuissaPisteissa1() {
        FunktionArvot funktio = new FunktionArvot("sin (x) + 5");
        ArrayList<Double> pisteet = new ArrayList<>();
        pisteet.add(0.0); 
        pisteet.add(Math.PI/2);
        pisteet.add(Math.PI);
        pisteet.add(3*Math.PI/2);
        ArrayList<Double> vastaus = funktio.laskeFunktionArvot(pisteet);
        assertEquals(vastaus.get(0), 5.0, 0.0001);
    }
    
    @Test
    public void funktionArvotLasketaanOikeinKaikissaAnnetuissaPisteissa2() {
        FunktionArvot funktio = new FunktionArvot("sin (x) + 5");
        ArrayList<Double> pisteet = new ArrayList<>();
        pisteet.add(0.0); 
        pisteet.add(Math.PI/2);
        pisteet.add(Math.PI);
        pisteet.add(3*Math.PI/2);
        ArrayList<Double> vastaus = funktio.laskeFunktionArvot(pisteet);
        assertEquals(vastaus.get(1), 6.0, 0.0001);
    }
    
    @Test
    public void funktionArvotLasketaanOikeinKaikissaAnnetuissaPisteissa3() {
        FunktionArvot funktio = new FunktionArvot("sin (x) + 5");
        ArrayList<Double> pisteet = new ArrayList<>();
        pisteet.add(0.0); 
        pisteet.add(Math.PI/2);
        pisteet.add(Math.PI);
        pisteet.add(3*Math.PI/2);
        ArrayList<Double> vastaus = funktio.laskeFunktionArvot(pisteet);
        assertEquals(vastaus.get(2), 5.0, 0.0001);
    }
    
    @Test
    public void funktionArvotLasketaanOikeinKaikissaAnnetuissaPisteissa4() {
        FunktionArvot funktio = new FunktionArvot("sin (x) + 5");
        ArrayList<Double> pisteet = new ArrayList<>();
        pisteet.add(0.0); 
        pisteet.add(Math.PI/2);
        pisteet.add(Math.PI);
        pisteet.add(3*Math.PI/2);
        ArrayList<Double> vastaus = funktio.laskeFunktionArvot(pisteet);
        assertEquals(vastaus.get(3), 4.0, 0.0001);
    }
}
