/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import integraattori.logiikka.SuorakulmioMetodi;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author elina
 */
public class SuorakulmioMetodiTest {

    public SuorakulmioMetodiTest() {
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
    public void suorakulmioMetodiAsettaaAlkuarvotOikein() {
        SuorakulmioMetodi integ = new SuorakulmioMetodi ("x^3 + 68", 1.0, 5.0, 100, 1000, 0.00076);
        assertEquals(integ.getFunktio(), "x^3 + 68");
        assertEquals(integ.getAlaraja(), 1.0, 0.0001);
        assertEquals(integ.getYlaraja(), 5.0, 0.0001);
        assertEquals(integ.getAskeliaAluksi(), 100);
        assertEquals(integ.getAskeliaKorkeintaan(), 1000);
        assertEquals(integ.getHaluttuTarkkuus(), 0.00076, 0.00001);
    }
    
    @Test
    public void suorakulmioMetodiLaskeeIntegraalinOikein() {
        SuorakulmioMetodi integ = new SuorakulmioMetodi ("x", 1.0, 2.0, 4, 10, 0.001);
        ArrayList<Double> tulos = integ.iteroidaan();
        assertEquals(tulos.get(0), 1.5, 0.001);
    }
    
    @Test
    public void suorakulmioMetodiLaskeeIntegraalinOikeallaTarkkuudella() {
        SuorakulmioMetodi integ = new SuorakulmioMetodi ("x", 1.0, 2.0, 4, 10, 0.001);
        ArrayList<Double> tulos = integ.iteroidaan();
        assertTrue(tulos.get(1) < 0.001);
    }
}

