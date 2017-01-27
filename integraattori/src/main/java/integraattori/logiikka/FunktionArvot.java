package integraattori.logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class FunktionArvot {

    private String funktio;
    //private double alaraja;
    //private double ylaraja;
    //private double valinPituus;
    //private int valienMaara;
    //private ArrayList<Double> pisteet;
    private ArrayList<Double> arvot;
    //private Expression e;

    public FunktionArvot(String funktio) {
        this.funktio = funktio;
        this.arvot = new ArrayList<>();

    }

    private Expression maaritteleFunktio() {
        Expression e = new ExpressionBuilder(funktio)
                .variables("x")
                .build();
        return e;
    }

    public double funktionArvoPisteessa(double piste) {
        Expression e = maaritteleFunktio();
        e.setVariable("x", piste);
        return e.evaluate();
    }

    public ArrayList<Double> laskeFunktionArvot(ArrayList<Double> pisteet) {
        Expression e = maaritteleFunktio();
        for (int i = 0; i < pisteet.size(); i++) {
            e.setVariable("x", pisteet.get(i));
            this.arvot.add(e.evaluate());
        }

        return this.arvot;
    }

//    public void setValienMaara(int uusiMaara) {
//        this.valienMaara = uusiMaara;
//        this.valinPituus = (this.ylaraja - this.alaraja) / this.valienMaara;
//    }
}
