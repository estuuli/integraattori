package integraattori.logiikka;

import java.util.ArrayList;

public class SuorakulmioMetodi {

    private double alaraja;
    private double ylaraja;
    private int askeliaAluksi;
    private int askeliaKorkeintaan;
    private double haluttuTarkkuus;
    private String funktio;
    private double valiTulos;

    public SuorakulmioMetodi(String funktio, double alaraja, double ylaraja, int askeliaAluksi, int askeliaKorkeintaan, double haluttuTarkkuus) {
        this.alaraja = alaraja;
        this.ylaraja = ylaraja;
        this.askeliaAluksi = askeliaAluksi;
        this.askeliaKorkeintaan = askeliaKorkeintaan;
        this.haluttuTarkkuus = haluttuTarkkuus;
        this.funktio = funktio;
    }

    private ArrayList<Double> pisteet(int askeltenMaara) {
        ArrayList<Double> pisteet = new ArrayList<>();
        double pituus = (this.ylaraja - this.alaraja) / askeltenMaara;
        for (int i = 0; i <= askeltenMaara; i++) {
            pisteet.add(i, alaraja + i * pituus);
        }
        return pisteet;
    }

    public double integraalinArvo(int askeltenMaara) {
        FunktionArvot ftionArvot = new FunktionArvot(this.funktio);
        ArrayList<Double> arvot = ftionArvot.laskeFunktionArvot(pisteet(askeltenMaara));
        double summa = 0;
        for (int i = 0; i < arvot.size(); i++) {
            summa += arvot.get(i);
        }
        return (this.ylaraja - this.alaraja) / askeltenMaara * summa;
    }

    public ArrayList<Double> iteroidaan() {
        valiTulos = integraalinArvo(this.askeliaAluksi);

        int lkm = 0;
        double erotus = 1000000;
        int askelia = askeliaAluksi;

        while (erotus > haluttuTarkkuus | lkm < askeliaKorkeintaan) {
            double vanhaTulos = valiTulos;
            askelia = askelia * 2;
            valiTulos = integraalinArvo(askelia);
            erotus = Math.abs(valiTulos - vanhaTulos);
            lkm++;
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

    public String getFunktio() {
        return funktio;
    }
    
    

}
