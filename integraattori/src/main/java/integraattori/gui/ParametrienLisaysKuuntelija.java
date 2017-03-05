/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integraattori.gui;

import integraattori.logiikka.AarettomienRajojenMuunnin;
import integraattori.logiikka.Funktio;
import integraattori.logiikka.PuolisuunnikasMetodi;
import integraattori.logiikka.SimpsoninMetodi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * Luokka  kuuntelee käyttöliittymän integroi-nappia ja lukee sen painamisen 
 * jälkeen käyttöliittymän tekstikentät ja kutsuu valittua integroivaa metodia.
 * 
 * @author elina
 */
public class ParametrienLisaysKuuntelija implements ActionListener {

    private double alaraja;
    private Funktio funktio;
    private double ylaraja;
    private double tarkkuus;
    private JTextField funktioKentta;
    private JTextField alarajaKentta;
    private JTextField ylarajaKentta;
    private JTextField tarkkuusKentta;
    private JTextField virheilmoitusKentta;
    private JTextField tulosKentta;
    private JTextField virheKentta;
    private String virheilmoitus;
    private MetodinValinnanKuuntelija kuuntelija;
//    private String komento;

    /**
     * Luokan konstruktori.
     *
     * @param funktioKentta Käyttöliittymän funktiokenttä
     * @param alarajaKentta Käyttöliittymän alarajakenttä
     * @param ylarajaKentta Käyttöliittymän ylärajakenttä
     * @param tarkkuusKentta Käyttöliittymän tarkkuuskenttä
     * @param virheilmoitusKentta Käyttöliittymän virheilmoituskenttä
     * @param vastausKentta Käyttöliittymän vastauskenttä
     * @param virheKentta Käyttöliittymän virhekenttä
     * @param kuuntelija Monivalintojen kuuntelija
     */
    public ParametrienLisaysKuuntelija(JTextField funktioKentta, JTextField alarajaKentta, JTextField ylarajaKentta, JTextField tarkkuusKentta, JTextField virheilmoitusKentta, JTextField vastausKentta, JTextField virheKentta, MetodinValinnanKuuntelija kuuntelija) {
        this.funktioKentta = funktioKentta;
        this.alarajaKentta = alarajaKentta;
        this.ylarajaKentta = ylarajaKentta;
        this.tarkkuusKentta = tarkkuusKentta;
        this.virheilmoitusKentta = virheilmoitusKentta;
        this.tulosKentta = vastausKentta;
        this.virheKentta = virheKentta;
        this.kuuntelija = kuuntelija;
        this.virheilmoitus = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        this.virheilmoitusKentta.setText("");
        this.tulosKentta.setText("");
        this.virheKentta.setText("");

        lueFunktio();
        lueAlaraja();
        lueYlaraja();
        lueTarkkuus();
        if (!(this.virheilmoitus.equals(""))) {
            this.virheilmoitusKentta.setText(virheilmoitus);
            this.virheilmoitus = "";
        } else {
            try {
                AarettomienRajojenMuunnin muunnin = new AarettomienRajojenMuunnin(this.funktio, this.alaraja, this.ylaraja);
                ArrayList<Double> muunnetut = muunnin.muunna();

                if ((this.kuuntelija.getKomento().equals("puolisuunnikas"))) {
                    try {
                        PuolisuunnikasMetodi psIntegroi = new PuolisuunnikasMetodi(this.funktio, muunnetut.get(0), muunnetut.get(1), 100, this.tarkkuus);
                        ArrayList<Double> vastaus2 = psIntegroi.laskeIntegraali();
                        this.tulosKentta.setText(Double.toString(vastaus2.get(0)));
                        this.virheKentta.setText(Double.toString(vastaus2.get(1)));
                        if (vastaus2.get(0) > 1000000) {
                            this.virheilmoitusKentta.setText("On mahdollista, että integraali hajaantuu.");
                        }
                    } catch (RuntimeException virhe) {
                        this.virheilmoitusKentta.setText("Jaat ehkä nollalla!");
                    }
                } else if (this.kuuntelija.getKomento().equals("simpson")) {
                    try {
                        SimpsoninMetodi simpsonIntegroi = new SimpsoninMetodi(this.funktio, muunnetut.get(0), muunnetut.get(1), 100, this.tarkkuus);
                        ArrayList<Double> vastaus3 = simpsonIntegroi.laskeIntegraali();
                        this.tulosKentta.setText(Double.toString(vastaus3.get(0)));
                        this.virheKentta.setText(Double.toString(vastaus3.get(1)));
                        if (vastaus3.get(0) > 1000000) {
                            this.virheilmoitusKentta.setText("On mahdollista, että integraali hajaantuu.");
                        }
                    } catch (RuntimeException virhe) {
                        this.virheilmoitusKentta.setText("Jaat ehkä nollalla!");
                    }
                }
            } catch (NullPointerException virhe) {
                this.virheilmoitusKentta.setText("Valitse integrointimenetelmä!");
            }

        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void lueFunktio() {
        try {
            funktio = new Funktio(funktioKentta.getText());
        } catch (RuntimeException virhe) {
            this.virheilmoitus += "Antamasi funktio ei ole luettavissa! \n";
        }
    }

    private void lueAlaraja() {
        try {
            alaraja = Double.parseDouble(this.alarajaKentta.getText());
        } catch (NumberFormatException virhe) {
            if (this.alarajaKentta.getText().equals("infinite")) {
                alaraja = Double.POSITIVE_INFINITY;
            } else if (this.alarajaKentta.getText().equals("-infinite")) {
                alaraja = Double.NEGATIVE_INFINITY;
            } else {
                this.virheilmoitus += "Antamasi alaraja ei ole luku! \n";
            }
        }
    }

    private void lueYlaraja() {
        try {
            ylaraja = Double.parseDouble(this.ylarajaKentta.getText());
            if (ylaraja < alaraja) {
                this.virheilmoitus += "Yläraja on pienempi kuin alaraja! \n";
            }
        } catch (NumberFormatException e) {

            if (this.ylarajaKentta.getText().equals("infinite")) {
                ylaraja = Double.POSITIVE_INFINITY;
            } else if (this.ylarajaKentta.getText().equals("-infinite")) {
                ylaraja = Double.NEGATIVE_INFINITY;
            } else {
                this.virheilmoitus += "Antamasi yläraja ei ole luku! \n";
            }
        }
    }

    private void lueTarkkuus() {
        try {
            tarkkuus = Double.parseDouble(this.tarkkuusKentta.getText());
            if (tarkkuus <= 0 | tarkkuus >= 1) {
                this.virheilmoitus += "Tarkkuuden täytyy olla nollan ja yhden välillä. \n";
            }
        } catch (NumberFormatException e) {
            this.virheilmoitus += "Antamasi tarkkuus ei ole luku! \n";
        }
    }

}
