package integraattori.logiikka;

import java.util.ArrayList;

/**
 * Luokka tarjoaa integraalien laskemiseen puolisuunnikasmetodilla tarvittavat
 * metodit.
 */
public class PuolisuunnikasMetodi {

    double alaraja;
    double ylaraja;
    int iteraatioitaKorkeintaan;
    double haluttuTarkkuus;
    private double valiTulos;
    private Funktio funktio;
    double askeleenPituus;
    double arvo;

    /**
     * Luokan konstruktori astettaa arvot alarajalle, ylärajalle, funktiolle, 
     * iteraatioiden määrän ylärajalle ja tarkkuudelle.
     *
     * @param funktio käyttäjän antama funktio
     * @param alaraja käyttäjän antama integroinnin alaraja
     * @param ylaraja käyttäjän antama integroinnin yläraja
     * @param iteraatioitaKorkeintaan iteraatioiden määrän yläraja
     * @param haluttuTarkkuus käyttäjän antama integroinnin tarkkuus
     *
     */
    public PuolisuunnikasMetodi(Funktio funktio, double alaraja, double ylaraja, int iteraatioitaKorkeintaan, double haluttuTarkkuus) {
        this.alaraja = alaraja;
        this.ylaraja = ylaraja;
        this.iteraatioitaKorkeintaan = iteraatioitaKorkeintaan;
        this.haluttuTarkkuus = haluttuTarkkuus;
        this.funktio = funktio;
    }

    /**
     * Metodi laskee integraalin arvoa laskemalla funktion arvojen summaa
     * pisteissä, jotka ovat askeleen välein, ja pienentää lopuksi askeleen
     * pituuden puoleen.
     *
     * @return arvio integraalin arvolle
     */
    public double integraalinArvo() {
        double summa = 0;

        double paikka = alaraja + 0.5 * askeleenPituus;
        while (paikka < ylaraja) {
            summa += funktio.funktionArvoPisteessa(paikka);
            paikka += askeleenPituus;
        }
        arvo = (askeleenPituus * summa + arvo) / 2;
        askeleenPituus /= 2;
        return arvo;
    }

    /**
     * Metodi laskee integraalin arvoa iteratiivisesti vertaamalla arvoa
     * aiemmalla iteraatiolla laskettuun arvoon ja lopettaa laskemisen erotuksen
     * ollessa tarpeeksi pieni.
     *
     * @return integraalin arvo ja laskun virhe
     */
    public ArrayList<Double> laskeIntegraali() {
        valiTulos = alustaIntegrointi();
        double erotus = 1000000;
        int lkm = 0;

        while (erotus > haluttuTarkkuus | lkm < 3) {
            double vanhaTulos = valiTulos;
            valiTulos = integraalinArvo();
            erotus = Math.abs(valiTulos - vanhaTulos);
            lkm++;
            if (lkm > iteraatioitaKorkeintaan) {
                break;
            }
        }
        ArrayList<Double> tulos = new ArrayList<>();
        tulos.add(valiTulos);
        tulos.add(erotus);
        return tulos;
    }

    /**
     * Metodi toteuttaa ennen ensimmäistä iteraatiota tarvittavat alustukset.
     *
     * @return ensimmäinen arvio integraalin arvolle
     */
    public double alustaIntegrointi() {
        askeleenPituus = (this.ylaraja - this.alaraja);
        return (funktio.funktionArvoPisteessa(alaraja) + funktio.funktionArvoPisteessa(ylaraja)) * askeleenPituus / 2;
    }

}
