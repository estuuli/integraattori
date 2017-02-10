package integraattori.ui;

import integraattori.logiikka.PuolisuunnikasMetodi;
import integraattori.logiikka.SimpsoninMetodi;
import integraattori.logiikka.SuorakulmioMetodi;
import java.util.ArrayList;
import java.util.Scanner;

public class Kayttoliittyma {

    private Scanner lukija;

    public Kayttoliittyma() {
        lukija = new Scanner(System.in);
    }

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
                    //return new Funktio();
                    SuorakulmioMetodi integroi = new SuorakulmioMetodi(ftio, alaraja, ylaraja, askelia, 20, tarkkuus);
                    ArrayList<Double> vastaus = integroi.iteroidaan();
                    System.out.println(vastaus);
                    break;
                case "2":
                    System.out.println("Anna funktio: ");
                    String ftio2 = lukija.nextLine();
                    System.out.println("Anna alaraja: ");
                    double alaraja2 = Double.parseDouble(lukija.nextLine());
                    System.out.println("Anna yläraja: ");
                    double ylaraja2 = Double.parseDouble(lukija.nextLine());
                    System.out.println("Anna haluttu tarkkuus: ");
                    double tarkkuus2 = Double.parseDouble(lukija.nextLine());
                    //return new Funktio();
                    PuolisuunnikasMetodi psIntegroi = new PuolisuunnikasMetodi(ftio2, alaraja2, ylaraja2, 200, tarkkuus2);
                    ArrayList<Double> vastaus2 = psIntegroi.laskeIntegraali();
                    System.out.println(vastaus2);
                    break;
                case "3":
                    System.out.println("Anna funktio: ");
                    String ftio3 = lukija.nextLine();
                    System.out.println("Anna alaraja: ");
                    double alaraja3 = Double.parseDouble(lukija.nextLine());
                    System.out.println("Anna yläraja: ");
                    double ylaraja3 = Double.parseDouble(lukija.nextLine());
                    System.out.println("Anna haluttu tarkkuus: ");
                    double tarkkuus3 = Double.parseDouble(lukija.nextLine());
                    //return new Funktio();
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

//    public Funktio kyseleParametrit() {
//        System.out.println("Anna funktio: ");
//        String ftio = lukija.nextLine();
//        System.out.println("Anna alaraja: ");
//        double alaraja = Double.parseDouble(lukija.nextLine());
//        System.out.println("Anna yläraja: ");
//        double ylaraja = Double.parseDouble(lukija.nextLine());
//        System.out.println("Anna askelten lukumäärä: ");
//        int askelia = Integer.parseInt(lukija.nextLine());
//        System.out.println("Anna haluttu tarkkuus: ");
//        int tarkkuus = Integer.parseInt(lukija.nextLine());
//        return new Funktio(ftio, alaraja, ylaraja, askelia, tarkkuus);
//    }
}
