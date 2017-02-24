package integraattori.ui;

import integraattori.logiikka.AarettomienRajojenMuunnin;
import integraattori.logiikka.Funktio;
import integraattori.logiikka.PuolisuunnikasMetodi;
import integraattori.logiikka.SimpsoninMetodi;
import integraattori.logiikka.SuorakulmioMetodi;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Komentorivikäyttöliittymäluokka.
 *
 * @author elina
 */
public class Kayttoliittyma {

    private Scanner lukija;

    /**
     * Luokan konstruktori.
     *
     */
    public Kayttoliittyma() {
        lukija = new Scanner(System.in);
    }

    /**
     * Metodi käynnistää käyttöliittymän, kysyy integroinnissa tarvittavia
     * parametreja, kutsuu integroivaa metodia ja antaa vastauksen.
     *
     */
    public void kaynnista() {

        System.out.println("Tervetuloa integroimaan!");
        luuppi:
        while (true) {
            System.out.println("Valitse käytettävä metodi:");
            System.out.println("1 - suorakulmiometodi");
            System.out.println("2 - puolisuunnikasmetodi");
            System.out.println("3 - Simpsonin metodi");
            System.out.println("X - lopeta");

            String komento = lukija.nextLine();
            System.out.println("");

            switch (komento) {
                case "1":
                    System.out.println("Anna funktio: ");
                    String ftio = lukija.nextLine();
                    System.out.println("Anna alaraja: ");
                    double alaraja = Double.parseDouble(lukija.nextLine());
                    System.out.println("Anna yläraja: ");
                    double ylaraja = Double.parseDouble(lukija.nextLine());
                    System.out.println("Anna askelten lukumäärä: ");
                    int askelia = Integer.parseInt(lukija.nextLine());
                    System.out.println("Anna haluttu tarkkuus: ");
                    double tarkkuus = Double.parseDouble(lukija.nextLine());
                    SuorakulmioMetodi integroi = new SuorakulmioMetodi(ftio, alaraja, ylaraja, askelia, 20, tarkkuus);
                    ArrayList<Double> vastaus = integroi.iteroidaan();
                    System.out.println(vastaus);
                    break;
                case "2":
                    Funktio ftio2 = kysyFunktio();
                    double alaraja2 = kysyAlaraja();
                    double ylaraja2 = kysyYlaraja();
                    double tarkkuus2 = kysyTarkkuus();
                    AarettomienRajojenMuunnin muunnin = new AarettomienRajojenMuunnin(ftio2, alaraja2, ylaraja2);
                    ArrayList<Double> muunnetut = muunnin.muunna();

                    PuolisuunnikasMetodi psIntegroi = new PuolisuunnikasMetodi(ftio2, muunnetut.get(0), muunnetut.get(1), 200, tarkkuus2);
                    ArrayList<Double> vastaus2 = psIntegroi.laskeIntegraali();
                    System.out.println(vastaus2);
                    break;
                case "3":
                    Funktio ftio3 = kysyFunktio();
                    double alaraja3 = kysyAlaraja();
                    double ylaraja3 = kysyYlaraja();
                    double tarkkuus3 = kysyTarkkuus();
                    SimpsoninMetodi simpsonIntegroi = new SimpsoninMetodi(ftio3, alaraja3, ylaraja3, 200, tarkkuus3);
                    ArrayList<Double> vastaus3 = simpsonIntegroi.laskeIntegraali();
                    System.out.println(vastaus3);
                    break;
                case "X":
                    break luuppi;
                default:
                    System.out.println("En tunne annettua komentoa: " + komento + ". Yritä uudelleen.");
                    break;

            }
            System.out.println("");
        }

    }

    /**
     * Metodi kysyy integroinnin alarajaa ja varmistaa, että annettu syöte on
     * luku.
     *
     * @return alaraja doublena
     */
    public double kysyAlaraja() {
        System.out.println("Anna alaraja: ");
        String luettu = lukija.nextLine();
        double alaraja;
        try {
            alaraja = Double.parseDouble(luettu);
        } catch (NumberFormatException e) {

            if (luettu.equals("infinite")) {
                alaraja = Double.POSITIVE_INFINITY;
            } else if (luettu.equals("-infinite")) {
                alaraja = Double.NEGATIVE_INFINITY;
            } else {
                System.out.println("Antamasi alaraja ei ole luku!");
                return kysyAlaraja();
            }
        }
        return alaraja;
    }

    /**
     * Metodi kysyy integroinnin ylarajaa ja varmistaa, että annettu syöte on
     * luku.
     *
     * @return yläraja doublena
     */
    public double kysyYlaraja() {
        System.out.println("Anna yläraja: ");
        String luettu = lukija.nextLine();
        double ylaraja;
        try {
            ylaraja = Double.parseDouble(luettu);
        } catch (NumberFormatException e) {

            if (luettu.equals("infinite")) {
                ylaraja = Double.POSITIVE_INFINITY;
            } else if (luettu.equals("-infinite")) {
                ylaraja = Double.NEGATIVE_INFINITY;
            } else {
                System.out.println("Antamasi yläraja ei ole luku!");
                return kysyYlaraja();
            }
        }
        return ylaraja;
    }

    /**
     * Metodi kysyy integroinnin haluttua tarkkuutta ja varmistaa, että annettu
     * syöte on luku.
     *
     * @return tarkkuus doublena
     */
    public double kysyTarkkuus() {
        System.out.println("Anna tarkkuus: ");
        String luettu = lukija.nextLine();
        double tarkkuus;
        try {
            tarkkuus = Double.parseDouble(luettu);
        } catch (NumberFormatException e) {

            System.out.println("Antamasi tarkkuus ei ole luku!");
            return kysyAlaraja();
        }
        return tarkkuus;
    }

    /**
     * Metodi kysyy integroitavaa funktiota ja varmistaa, että funktio on
     * määriteltävissä.
     *
     *
     * @return funktio
     */
    public Funktio kysyFunktio() {
        System.out.println("Anna funktio: ");
        String ftio = lukija.nextLine();
        Funktio funktio;
        try {
            funktio = new Funktio(ftio);
        } catch (RuntimeException e) {
            System.out.println("Antamasi funktio ei ole luettavissa!");
            return kysyFunktio();
        }
        return funktio;
    }

}
