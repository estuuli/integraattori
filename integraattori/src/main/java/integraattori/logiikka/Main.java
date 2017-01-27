package integraattori.logiikka;

//import java.beans.Expression;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SuorakulmioMetodi integraattori = new SuorakulmioMetodi("x", 1.0, 2.0, 1, 10, 0.0001);
        ArrayList<Double> tulos = integraattori.iteroidaan();
        System.out.println(tulos);
//        System.out.println(laskuri.funktionArvoPisteessa());
        
//        Expression e = new ExpressionBuilder("3 * sin(y) - 2 / (x - 2)")
//                .variables("x", "y")
//                .build().setVariable("x", 2.3)
//                .setVariable("y", 3.14);
//        double result = e.evaluate();
//        System.out.println(result);
//        System.out.println("tölkasöfa");
    }

}
