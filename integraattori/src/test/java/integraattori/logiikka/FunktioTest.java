/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integraattori.logiikka;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;
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
public class FunktioTest {

    public FunktioTest() {
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
        Funktio siniFunktio = new Funktio("sin x");
        double vastaus = siniFunktio.funktionArvoPisteessa(0);
        assertEquals(0.0, vastaus, 0.00001);
    }
    
        @Test
    public void sinFunktioLaskeeArvonOikein2() {
        Funktio siniFunktio = new Funktio("sin x");
        double vastaus = siniFunktio.funktionArvoPisteessa(Math.PI/12);
        assertEquals(0.25881, vastaus, 0.00001);
    }
    
    @Test
    public void polynomiFunktionArvoLasketaanOikein() {
        Funktio funktio = new Funktio("x^5 + 6x^4 + 3x -5");
        double vastaus = funktio.funktionArvoPisteessa(0);
        assertEquals(-5.0, vastaus, 0.00001);
    }
    
    @Test
    public void polynomiFunktionArvoLasketaanOikein2() {
        Funktio funktio = new Funktio("x^5 + 6x^4 + 3x -5");
        double vastaus = funktio.funktionArvoPisteessa(Math.sqrt(2));
        assertEquals(28.89949, vastaus, 0.00001);
    }

    @Test
    public void validaatioTesti() {
        Expression e = new ExpressionBuilder("x")
                .variable("x")
                .build();

        ValidationResult res = e.validate(false);
        assertTrue(res.isValid());
        assertNull(res.getErrors());
    }

    @Test
    public void validaatioTesti2() {
        Expression e = new ExpressionBuilder("x")
                .variable("x")
                .build();

        ValidationResult res = e.validate();
        assertFalse(res.isValid());
        assertEquals(1, res.getErrors().size());

        e.setVariable("x", 1d);
        res = e.validate();
        assertTrue(res.isValid());
    }
    
    @Test
    public void muuttaaFunktionOikein() {
        Funktio siniFunktio = new Funktio("sin x");
        Expression kosiniFunktio = new ExpressionBuilder("cos x")
                .variable("x")
                .build();
        
        siniFunktio.setFunktio(kosiniFunktio);
        
        double vastaus = siniFunktio.funktionArvoPisteessa(0);
        assertEquals(1.0, vastaus, 0.00001);        
    }
    
    @Test
    public void palauttaaOikeanFunktion() {
        Funktio siniFunktio = new Funktio("sin x");
        Expression e = siniFunktio.getFunktio();
        
        e.setVariable("x", 0);
        assertEquals(0.0, e. evaluate(), 0.001);
        
        e.setVariable("x", Math.PI/2);
        assertEquals(1.0, e. evaluate(), 0.001);
    }
}
