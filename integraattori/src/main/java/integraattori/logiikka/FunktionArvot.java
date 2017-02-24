package integraattori.logiikka;

import java.util.ArrayList;
import java.util.HashMap;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * Luokka muuntaa käyttäjän syöttämän String-muotoisen funktion Expressioniksi 
 * ja laskee sen arvoja annetuissa pisteissä.
 *
 * @author elina
 */
public class FunktionArvot {

    private String funktio;
    private ArrayList<Double> arvot;

    /**
     * Luokan konstruktori.
     *
     * @param funktio käyttäjän antama funktio
     * 
     */
    public FunktionArvot(String funktio) {
        this.funktio = funktio;
        this.arvot = new ArrayList<>();

    }

    /**
     * Metodi määrittelee funktion Expressioniksi annetun String-muuttujan mukaan.
     *
     * @return Expression e
     */
    private Expression maaritteleFunktio() {
        Expression e = new ExpressionBuilder(funktio)
                .variables("x")
                .build();
        return e;
    }

    /**
     * Metodi laskee funktion arvon annetussa pisteessä.
     *
     * @param piste piste, jossa funktion arvo lasketaan
     * 
     * @return funktion arvo doublena
     */
    public double funktionArvoPisteessa(double piste) {
        Expression e = maaritteleFunktio();
        e.setVariable("x", piste);
        return e.evaluate();
    }

    /**
     * Metodi laskee funktion arvon annetuissa pisteissä.
     *
     * @param pisteet pisteet, jossa funktion arvo lasketaan ArrayListinä
     * 
     * @return funktion arvot doubleja sisältävänä ArrayListinä
     */
    public ArrayList<Double> laskeFunktionArvot(ArrayList<Double> pisteet) {
        Expression e = maaritteleFunktio();
        for (int i = 0; i < pisteet.size(); i++) {
            e.setVariable("x", pisteet.get(i));
            this.arvot.add(e.evaluate());
        }

        return this.arvot;
    }


}
