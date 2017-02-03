package integraattori.logiikka;

import java.util.ArrayList;

public class PuolisuunnikasMetodi {

    double alaraja;
    double ylaraja;
    int iteraatioitaKorkeintaan;
    double haluttuTarkkuus;
    private double valiTulos;
    private FunktionArvot funktio;
    double askeleenPituus;
    double arvo;

    public PuolisuunnikasMetodi(String funktio, double alaraja, double ylaraja, int iteraatioitaKorkeintaan, double haluttuTarkkuus) {
        this.alaraja = alaraja;
        this.ylaraja = ylaraja;
        this.iteraatioitaKorkeintaan = iteraatioitaKorkeintaan;
        this.haluttuTarkkuus = haluttuTarkkuus;
        this.funktio = new FunktionArvot(funktio);
    }

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

    public ArrayList<Double> laskeIntegraali() {
        askeleenPituus = (this.ylaraja - this.alaraja);
        arvo = (funktio.funktionArvoPisteessa(alaraja) + funktio.funktionArvoPisteessa(ylaraja)) * askeleenPituus / 2;

        valiTulos = arvo;

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

}
