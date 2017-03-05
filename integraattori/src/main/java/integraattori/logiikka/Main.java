package integraattori.logiikka;

//import java.beans.Expression;
import integraattori.gui.GraafinenKayttis;
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
     * @param args args
     */
    public static void main(String[] args) {

        //Käynnistää graafisen käyttöliittymän.
        GraafinenKayttis kayttis = new GraafinenKayttis();
        kayttis.run();
//
//      Seuraavat kaksi riviä käynnistävät komentorivikäyttöliittymän.
//        Kayttoliittyma kayttis = new Kayttoliittyma();
//        kayttis.kaynnista();
    }
}
