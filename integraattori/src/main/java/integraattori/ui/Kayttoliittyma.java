package integraattori.ui;

import integraattori.logiikka.AarettomienRajojenMuunnin;
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
//                    System.out.println("Anna funktio: ");
                    String ftio2 = kysyFunktio();
//                    System.out.println("Anna alaraja: ");
                    double alaraja2 = kysyAlaraja();
//                    System.out.println("Anna yläraja: ");
                    double ylaraja2 = kysyYlaraja();
//                    System.out.println("Anna haluttu tarkkuus: ");
                    double tarkkuus2 = kysyTarkkuus();
//                    ArrayList<String> parametrit = kyseleParametrit();
                    //return new Funktio();

                    PuolisuunnikasMetodi psIntegroi = new PuolisuunnikasMetodi(ftio2, alaraja2, ylaraja2, 200, tarkkuus2);
                    ArrayList<Double> vastaus2 = psIntegroi.laskeIntegraali();
                    System.out.println(vastaus2);
                    break;
                case "3":
//                    System.out.println("Anna funktio: ");
                    String ftio3 = kysyFunktio();
//                    System.out.println("Anna alaraja: ");
                    double alaraja3 = kysyAlaraja();
//                    System.out.println("Anna yläraja: ");
                    double ylaraja3 = kysyYlaraja();
//                    System.out.println("Anna haluttu tarkkuus: ");
                    double tarkkuus3 = kysyTarkkuus();
                    //return new Funktio();
////                    ArrayList<String> parametritS = kyseleParametrit();
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

    public double kysyAlaraja() {
        System.out.println("Anna alaraja: ");
        String luettu = lukija.nextLine();
        double alaraja;
        try {
            alaraja = Double.parseDouble(luettu);
        } catch (NumberFormatException e) {

            if (luettu.equals("infinite")) {
                alaraja = Double.POSITIVE_INFINITY;
            } else if (luettu.equals("infinite")) {
                alaraja = Double.NEGATIVE_INFINITY;
            } else {
                System.out.println("Antamasi alaraja ei ole luku!");
                return kysyAlaraja();
            }
        }
        return alaraja;
    }

    public double kysyYlaraja() {
        System.out.println("Anna yläraja: ");
        String luettu = lukija.nextLine();
        double ylaraja;
        try {
            ylaraja = Double.parseDouble(luettu);
        } catch (NumberFormatException e) {

            if (luettu.equals("infinite")) {
                ylaraja = Double.POSITIVE_INFINITY;
            } else if (luettu.equals("infinite")) {
                ylaraja = Double.NEGATIVE_INFINITY;
            } else {
                System.out.println("Antamasi yläraja ei ole luku!");
                return kysyYlaraja();
            }
        }
        return ylaraja;
    }

    public double kysyTarkkuus() {
        System.out.println("Anna tarkkuus: ");
        String luettu = lukija.nextLine();
        double tarkkuus;
        try {
            tarkkuus = Double.parseDouble(luettu);
        } catch (NumberFormatException e) {

            if (luettu.equals("infinite")) {
                tarkkuus = Double.POSITIVE_INFINITY;
            } else if (luettu.equals("infinite")) {
                tarkkuus = Double.NEGATIVE_INFINITY;
            } else {
                System.out.println("Antamasi tarkkuus ei ole luku!");
                return kysyAlaraja();
            }
        }
        return tarkkuus;
    }

    public String kysyFunktio() {
        System.out.println("Anna funktio: ");
        String ftio = lukija.nextLine();
        return ftio;
    }

//    public ArrayList<String> kyseleParametrit() {
//        boolean lukuja = true;
//        System.out.println("Anna funktio: ");
//        String ftio = lukija.nextLine();
//
//        System.out.println("Anna alaraja: ");
//        String alaraja = lukija.nextLine();
//        try {
//            double alaraja2 = Double.parseDouble(alaraja);
//        } catch (NumberFormatException e) {
//            if (!(alaraja.equals("infinite") | alaraja.equals("-infinite"))) {
//                System.out.println("Antamasi alaraja ei ole luku!");
//            }
//            lukuja = false;
//        }
//
//        System.out.println("Anna yläraja: ");
//        String ylaraja = lukija.nextLine();
//        try {
//            double ylaraja2 = Double.parseDouble(ylaraja);
//        } catch (NumberFormatException e) {
//            System.out.println("Antamasi yläraja ei ole luku!");
//            lukuja = false;
//
//        }
//
//        System.out.println("Anna haluttu tarkkuus: ");
//        String tarkkuus = lukija.nextLine();
//        try {
//            double tarkkuus2 = Double.parseDouble(lukija.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Antamasi tarkkuus ei ole luku!");
//            lukuja = false;
//        }
//
//        ArrayList<String> parametrit = new ArrayList<>();
//        if (!lukuja) {
//            AarettomienRajojenMuunnin testeri = new AarettomienRajojenMuunnin(ftio, alaraja, ylaraja);
//            parametrit = testeri.muunna();
//            parametrit.add(tarkkuus);
//        } else {
//            parametrit.add(ftio);
//            parametrit.add(alaraja);
//            parametrit.add(ylaraja);
//            parametrit.add(tarkkuus);
//        }
//
//        return parametrit;
////        return new Funktio(ftio, alaraja, ylaraja, askelia, tarkkuus);
//    }
    public double onkoLuku(String syote) {
        double arvo;
        try {
            arvo = Double.parseDouble(lukija.nextLine());
        } catch (NumberFormatException e) {
            if (syote.equals("infinite")) {
                arvo = Double.POSITIVE_INFINITY;
            } else if (syote.equals("-infinite")) {
                arvo = Double.NEGATIVE_INFINITY;
            } else if (syote.equals("-Math.PI/2")) {
                arvo = -Math.PI / 2;
            } else if (syote.equals("Math.PI/2")) {
                arvo = Math.PI / 2;
            } else {
                System.out.println("Jokin antamasi parametri ei ole luku!");
                arvo = Double.NaN;
            }
        }
        return arvo;
    }
}
