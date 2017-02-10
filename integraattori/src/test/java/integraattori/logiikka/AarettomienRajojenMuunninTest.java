package integraattori.logiikka;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AarettomienRajojenMuunninTest {
    
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
        AarettomienRajojenMuunnin muunnin = new AarettomienRajojenMuunnin("-infinite", "0", "x");
        ArrayList<String> tulos = muunnin.muunna();
        assertEquals(tulos.get(0), "-Math.PI/2");
        assertEquals(tulos.get(1), "0");
        assertEquals(tulos.get(2), "(tan x)(1 + (tan x)*(tan x))");
    }
    
    @Test
    public void muuntaaAarettomanYlarajanOikein() {
        AarettomienRajojenMuunnin muunnin = new AarettomienRajojenMuunnin("0","infinite", "x");
        ArrayList<String> tulos = muunnin.muunna();
        assertEquals(tulos.get(0), "0");
        assertEquals(tulos.get(1), "Math.PI/2");
        assertEquals(tulos.get(2), "(tan x)(1 + (tan x)*(tan x))");
    }
    
    @Test
    public void muuntaaAarettomatRajatOikein() {
        AarettomienRajojenMuunnin muunnin = new AarettomienRajojenMuunnin("-infinite","infinite", "x");
        ArrayList<String> tulos = muunnin.muunna();
        assertEquals(tulos.get(0), "-Math.PI/2");
        assertEquals(tulos.get(1), "Math.PI/2");
        assertEquals(tulos.get(2), "(tan x)(1 + (tan x)*(tan x))");
    }
}
