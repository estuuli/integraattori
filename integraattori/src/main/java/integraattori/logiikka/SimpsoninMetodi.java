package integraattori.logiikka;

import java.util.ArrayList;

/**
 * Luokka tarjoaa integraalien laskemiseen Simpsonin metodilla tarvittavat
 * metodit.
 */
public class SimpsoninMetodi extends PuolisuunnikasMetodi {

    private FunktionArvot funktio;
    private double valiTulos;

    public SimpsoninMetodi(String funktio, double alaraja, double ylaraja, int iteraatioitaKorkeintaan, double haluttuTarkkuus) {
        super(funktio, alaraja, ylaraja, iteraatioitaKorkeintaan, haluttuTarkkuus);
        this.funktio = new FunktionArvot(funktio);
    }

    /**
     * Metodi laskee integraalin arvoa iteratiivisesti vertaamalla arvoa
     * aiemmalla iteraatiolla laskettuun arvoon ja lopettaa laskemisen erotuksen
     * ollessa tarpeeksi pieni.
     *
     * @return integraalin arvo ja laskun virhe
     */
    @Override
    public ArrayList<Double> laskeIntegraali() { 
        valiTulos = alustaIntegrointi();
        double erotus = 1000000;
        int lkm = 0;

        while (erotus > haluttuTarkkuus | lkm < 3) {
            double vanhaTulos = valiTulos;
            double vanhaArvo = arvo;
            valiTulos = (4 * integraalinArvo() - vanhaArvo) / 3;
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

}
