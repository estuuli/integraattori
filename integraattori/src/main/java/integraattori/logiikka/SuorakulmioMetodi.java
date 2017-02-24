package integraattori.logiikka;

import java.util.ArrayList;

/**
 * Luokka tarjoaa integraalien laskemiseen suorakulmiometodilla tarvittavat
 * metodit.
 */
public class SuorakulmioMetodi {

    private double alaraja;
    private double ylaraja;
    private int askeliaAluksi;
    private int askeliaKorkeintaan;
    private double haluttuTarkkuus;
    private double valiTulos;
    private FunktionArvot ftionArvot;

    /**
     * Luokan konstruktori astettaa arvot alarajalle, ylärajalle, funktiolle, 
     * iteraatioiden määrän ylärajalle ja tarkkuudelle.
     *
     * @param funktio käyttäjän antama funktio
     * @param alaraja käyttäjän antama integroinnin alaraja
     * @param ylaraja käyttäjän antama integroinnin yläraja
     * @param askeliaAluksi askelien määrän alkuarvo
     * @param askeliaKorkeintaan askelien määrän yläraja
     * @param haluttuTarkkuus käyttäjän antama integroinnin tarkkuus
     *
     */
    public SuorakulmioMetodi(String funktio, double alaraja, double ylaraja, int askeliaAluksi, int askeliaKorkeintaan, double haluttuTarkkuus) {
        this.alaraja = alaraja;
        this.ylaraja = ylaraja;
        this.askeliaAluksi = askeliaAluksi;
        this.askeliaKorkeintaan = askeliaKorkeintaan;
        this.haluttuTarkkuus = haluttuTarkkuus;
        this.ftionArvot = ftionArvot = new FunktionArvot(funktio);
    }

    /**
     * Metodi laskee integraalin arvoa laskemalla funktion arvojen tasavälein
     * olevissa pisteissä.
     * 
     * @param   askeltenMaara   Pisteiden lkm, joissa integraali lasketaan   
     *
     * @return arvio integraalin arvolle
     */
    public double integraalinArvo(int askeltenMaara) {

//        ArrayList<Double> arvot = ftionArvot.laskeFunktionArvot(pisteet(askeltenMaara));
        double summa = 0;
        double pituus = (this.ylaraja - this.alaraja) / askeltenMaara;
        for (int i = 0; i < askeltenMaara; i++) {
            summa += ftionArvot.funktionArvoPisteessa(alaraja + i * pituus);
        }
        return pituus * summa;
    }

    /**
     * Metodi laskee integraalin arvoa iteratiivisesti vertaamalla arvoa
     * aiemmalla iteraatiolla laskettuun arvoon ja lopettaa laskemisen erotuksen
     * ollessa tarpeeksi pieni.
     *
     * @return integraalin arvo ja laskun virhe
     */
    public ArrayList<Double> iteroidaan() {
        valiTulos = integraalinArvo(this.askeliaAluksi);

        double erotus = 1000000;
        int askelia = askeliaAluksi;

        while (erotus > haluttuTarkkuus) {
            double vanhaTulos = valiTulos;
            askelia = askelia * 2;
            valiTulos = integraalinArvo(askelia);
            erotus = Math.abs(valiTulos - vanhaTulos);

            if (askelia > this.askeliaKorkeintaan) {
                break;
            }
        }
        ArrayList<Double> tulos = new ArrayList<>();
        tulos.add(valiTulos);
        tulos.add(erotus);
        return tulos;
    }

    public double getAlaraja() {
        return alaraja;
    }

    public double getYlaraja() {
        return ylaraja;
    }

    public int getAskeliaAluksi() {
        return askeliaAluksi;
    }

    public int getAskeliaKorkeintaan() {
        return askeliaKorkeintaan;
    }

    public double getHaluttuTarkkuus() {
        return haluttuTarkkuus;
    }


}
