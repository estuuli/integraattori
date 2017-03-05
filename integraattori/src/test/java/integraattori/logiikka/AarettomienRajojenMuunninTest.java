package integraattori.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AarettomienRajojenMuunninTest {

    private Funktio funktio;

    public AarettomienRajojenMuunninTest() {
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
    public void muuntaaAarettomanAlarajanOikein() {
        AarettomienRajojenMuunnin muunnin = new AarettomienRajojenMuunnin(funktio, Double.NEGATIVE_INFINITY, 0);
        ArrayList<Double> tulos = muunnin.muunna();
        assertEquals(tulos.get(0), -Math.PI / 2, 0.0001);
        assertEquals(tulos.get(1), 0, 0.0001);
        assertEquals(funktio.getFunktionNimi(), "(tan x)*(1 + (tan x)*(tan x))");
    }

    @Test
    public void muuntaaAarettomanYlarajanOikein() {
        AarettomienRajojenMuunnin muunnin = new AarettomienRajojenMuunnin(funktio, 0, Double.POSITIVE_INFINITY);
        ArrayList<Double> tulos = muunnin.muunna();
        assertEquals(tulos.get(0), 0, 0.00001);
        assertEquals(tulos.get(1), Math.PI / 2, 0.0001);
        assertEquals(funktio.getFunktionNimi(), "(tan x)*(1 + (tan x)*(tan x))");
    }

    @Test
    public void muuntaaAarettomatRajatOikein() {
        AarettomienRajojenMuunnin muunnin = new AarettomienRajojenMuunnin(funktio, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        ArrayList<Double> tulos = muunnin.muunna();
        assertEquals(tulos.get(0), -Math.PI / 2, 0.00001);
        assertEquals(tulos.get(1), Math.PI / 2, 0.00001);
        assertEquals(funktio.getFunktionNimi(), "(tan x)*(1 + (tan x)*(tan x))");
    }
}
