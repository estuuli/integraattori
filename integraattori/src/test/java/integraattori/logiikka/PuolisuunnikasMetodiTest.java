/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integraattori.logiikka;

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
public class PuolisuunnikasMetodiTest {
    private Funktio funktio;

    public PuolisuunnikasMetodiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        funktio = new Funktio("x");
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
    public void puolisuunnikasMetodiLaskeeIntegraalinOikein() {
        PuolisuunnikasMetodi integ = new PuolisuunnikasMetodi(funktio, 1.0, 2.0, 50, 0.001);
        ArrayList<Double> tulos = integ.laskeIntegraali();
        assertEquals(tulos.get(0), 1.5, 0.001);
    }

    @Test
    public void puolisuunnikasMetodiLaskeeIntegraalinOikeallaTarkkuudella() {
        PuolisuunnikasMetodi integ = new PuolisuunnikasMetodi(funktio, 1.0, 2.0, 50, 0.001);
        ArrayList<Double> tulos = integ.laskeIntegraali();
        assertTrue(tulos.get(1) < 0.001);
    }
}
