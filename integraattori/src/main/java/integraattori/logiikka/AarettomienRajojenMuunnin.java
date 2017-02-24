package integraattori.logiikka;

import java.util.ArrayList;

/**
 * Luokka suorittaa muunnoksen x = tan u, jonka jälkeen integrointirajat ovat
 * taas äärelliset.
 *
 * @author elina
 */
public class AarettomienRajojenMuunnin {

    private double alaraja;
    private double ylaraja;
    private Funktio funktio;

    /**
     * Luokan konstruktori astettaa arvot alarajalle, ylärajalle ja funktiolle.
     *
     * @param funktio käyttäjän antama funktio
     * @param alaraja käyttäjän antama integroinnin alaraja
     * @param ylaraja käyttäjän antama integroinnin yläraja
     * 
     */
    public AarettomienRajojenMuunnin(Funktio funktio, double alaraja, double ylaraja) {
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
        public ArrayList<Double> muunna() {
        ArrayList<Double> tulos = new ArrayList<>();
        String funktionNimi = funktio.getFunktionNimi();
        if (this.alaraja == Double.NEGATIVE_INFINITY && this.ylaraja == Double.POSITIVE_INFINITY) {
            alaraja = -Math.PI/2;
            ylaraja = Math.PI/2;
            funktionNimi = funktionNimi.replaceAll("x", "(tan x)");
            funktionNimi += "(1 + (tan x)*(tan x))";
            funktio.setFunktionNimi(funktionNimi);
            funktio.paivitaFunktio();
            
        } else if (this.alaraja == Double.NEGATIVE_INFINITY) {
            alaraja = -Math.PI/2;
            //yla = Double.parseDouble(ylaraja);
            funktionNimi = funktionNimi.replaceAll("x", "(tan x)");
            funktionNimi += "(1 + (tan x)*(tan x))";
            funktio.setFunktionNimi(funktionNimi);
            funktio.paivitaFunktio();
        } else if (this.ylaraja == Double.POSITIVE_INFINITY) {
            //ala = Double.parseDouble(alaraja);
            ylaraja = Math.PI/2;
            funktionNimi = funktionNimi.replaceAll("x", "(tan x)");
            funktionNimi += "(1 + (tan x)*(tan x))";
            funktio.setFunktionNimi(funktionNimi);
            funktio.paivitaFunktio();
        }
        //tulos.add(funktio);
        tulos.add(alaraja);
        tulos.add(ylaraja);        
        return tulos;
    }
    
    
    
//    public ArrayList<String> muunna() {
//        ArrayList<String> tulos = new ArrayList<>();
//        if (this.alaraja.equals("-infinite") && this.ylaraja.equals("infinite")) {
//            alaraja = "-Math.PI/2";
//            ylaraja = "Math.PI/2";
//            funktio = funktio.replaceAll("x", "(tan x)");
//            funktio += "(1 + (tan x)*(tan x))";
//            
//        } else if (this.alaraja.equals("-infinite")) {
//            alaraja = "-Math.PI/2";
//            //yla = Double.parseDouble(ylaraja);
//            funktio = funktio.replaceAll("x", "(tan x)");
//            funktio += "(1 + (tan x)*(tan x))";
//        } else if (this.ylaraja.equals("infinite")) {
//            //ala = Double.parseDouble(alaraja);
//            ylaraja = "Math.PI/2";
//            funktio = funktio.replaceAll("x", "(tan x)");
//            funktio += "(1 + (tan x)*(tan x))";
//        }
//        tulos.add(funktio);
//        tulos.add(alaraja);
//        tulos.add(ylaraja);        
//        return tulos;
//    }

}
