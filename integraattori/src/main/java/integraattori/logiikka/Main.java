package integraattori.logiikka;

//import java.beans.Expression;
import integraattori.ui.Kayttoliittyma;

public class Main {

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
//        Expression e = new ExpressionBuilder("3 * (y) - 2 / (x - 2)")
//                .variables("x", "y")
//                .build().setVariable("x", Double.NEGATIVE_INFINITY)
//                .setVariable("y", Double.POSITIVE_INFINITY);
//        double result = e.evaluate();
//        System.out.println(result);
//        System.out.println("tölkasöfa");
    }

}
