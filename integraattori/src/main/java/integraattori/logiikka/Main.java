package integraattori.logiikka;

//import java.beans.Expression;
import integraattori.ui.Kayttoliittyma;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * Ohjelman Main-luokka.
 *
 * @author elina
 */
public class Main {

    /**
     * Main-metodi käynnistää ohjelman.
     *
     * @param args
     */
    public static void main(String[] args) {

        //Graafinen käyttis ei vielä tee mitään, koska actionlistenerit puuttuvat!
//        GraafinenKayttis kayttis = new GraafinenKayttis();
//        kayttis.run();
//
        Kayttoliittyma kayttis = new Kayttoliittyma();
        kayttis.kaynnista();

//        String luku = "-Math.PI/2";
//        double arvo = Double.parseDouble(luku);
//        System.out.println(arvo);
//        SuorakulmioMetodi integraattori = new SuorakulmioMetodi("x", 1.0, 2.0, 1, 10, 0.0001);
//        ArrayList<Double> tulos = integraattori.iteroidaan();
//        System.out.println(tulos);
//        System.out.println(laskuri.funktionArvoPisteessa());
//
//    try {
//        Expression e = new ExpressionBuilder("taöfaöskf)")
//                .variables("x", "y")
//                .build();
//    }catch (RuntimeException e) {
//        System.out.println("Virhe!");
//    }
//setVariable("x", Double.NEGATIVE_INFINITY)
//                .setVariable("y", Double.POSITIVE_INFINITY);
//        double result = e.evaluate();
//        System.out.println(result);
//        System.out.println("tölkasöfa");
        

//setVariable("x", Double.NEGATIVE_INFINITY)
//                .setVariable("y", Double.POSITIVE_INFINITY);
//        double result = e.evaluate();
//        System.out.println(result);
//        System.out.println("tölkasöfa");
    }

}
