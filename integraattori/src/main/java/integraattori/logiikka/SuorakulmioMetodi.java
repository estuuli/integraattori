package integraattori.logiikka;

import java.util.ArrayList;

public class SuorakulmioMetodi {

    private double alaraja;
    private double ylaraja;
    private int askeliaAluksi;
    private int askeliaKorkeintaan;
    private double haluttuTarkkuus;
//    private String funktio;
    private double valiTulos;
    private FunktionArvot ftionArvot;

    public SuorakulmioMetodi(String funktio, double alaraja, double ylaraja, int askeliaAluksi, int askeliaKorkeintaan, double haluttuTarkkuus) {
        this.alaraja = alaraja;
        this.ylaraja = ylaraja;
        this.askeliaAluksi = askeliaAluksi;
        this.askeliaKorkeintaan = askeliaKorkeintaan;
        this.haluttuTarkkuus = haluttuTarkkuus;
//        this.funktio = funktio;
        this.ftionArvot = ftionArvot = new FunktionArvot(funktio);
    }

//    private ArrayList<Double> pisteet(int askeltenMaara) {
//        ArrayList<Double> pisteet = new ArrayList<>();
//        double pituus = (this.ylaraja - this.alaraja) / askeltenMaara;
//        for (int i = 0; i <= askeltenMaara; i++) {
//            pisteet.add(i, alaraja + i * pituus);
//        }
//        return pisteet;
//    }
    public double integraalinArvo(int askeltenMaara) {

//        ArrayList<Double> arvot = ftionArvot.laskeFunktionArvot(pisteet(askeltenMaara));
        double summa = 0;
        double pituus = (this.ylaraja - this.alaraja) / askeltenMaara;
        for (int i = 0; i < askeltenMaara; i++) {
            summa += ftionArvot.funktionArvoPisteessa(alaraja + i * pituus);
        }
        return pituus * summa;
    }

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

//    public String getFunktio() {
//        return funktio;
//    }
}
