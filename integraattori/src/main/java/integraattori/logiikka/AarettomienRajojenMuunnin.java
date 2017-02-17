package integraattori.logiikka;

import java.util.ArrayList;

/**
 * Luokka suorittaa muunnoksen x = tan u, jonka jälkeen integrointirajat ovat
 * taas äärelliset.
 *
 * @author elina
 */
public class AarettomienRajojenMuunnin {

    private String alaraja;
    private String ylaraja;
    private String funktio;

    public AarettomienRajojenMuunnin(String funktio, String alaraja, String ylaraja) {
        this.alaraja = alaraja;
        this.ylaraja = ylaraja;
        this.funktio = funktio;
    }

    /**
     * Metodi tarkistaa, ovatko integrointirajat äärettömiä ja tekee muunnoksen
     * x = tan u.
     *
     * @return alaraja, yläraja ja muunnettu funktio String-muodossa
     */
    public ArrayList<String> muunna() {
        ArrayList<String> tulos = new ArrayList<>();
        if (this.alaraja.equals("-infinite") && this.ylaraja.equals("infinite")) {
            alaraja = "-Math.PI/2";
            ylaraja = "Math.PI/2";
            funktio = funktio.replaceAll("x", "(tan x)");
            funktio += "(1 + (tan x)*(tan x))";
        } else if (this.alaraja.equals("-infinite")) {
            alaraja = "-Math.PI/2";
            //yla = Double.parseDouble(ylaraja);
            funktio = funktio.replaceAll("x", "(tan x)");
            funktio += "(1 + (tan x)*(tan x))";
        } else if (this.ylaraja.equals("infinite")) {
            //ala = Double.parseDouble(alaraja);
            ylaraja = "Math.PI/2";
            funktio = funktio.replaceAll("x", "(tan x)");
            funktio += "(1 + (tan x)*(tan x))";
        }
        tulos.add(funktio);
        tulos.add(alaraja);
        tulos.add(ylaraja);        
        return tulos;
    }

}
