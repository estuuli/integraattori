/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integraattori.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Graafinen käyttöliittymä.
 *
 * @author elina
 */
public class GraafinenKayttis implements Runnable {

    private JFrame frame;

    /**
     * Luokan konstruktori.
     *
     */
    public GraafinenKayttis() {
    }

    @Override
    public void run() {

        frame = new JFrame("Integraattori");
        frame.setPreferredSize(new Dimension(500, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Luo graafisen käyttöliittymän komponenetit.
     *
     */
    private void luoKomponentit(Container container) {

        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(new JLabel("Valitse käytettävä integrointimenetelmä:"));

        JRadioButton kulmio = new JRadioButton("Suorakulmiometodi");
        JRadioButton suunnikas = new JRadioButton("Puolisuunnikasmetodi");
        JRadioButton simpson = new JRadioButton("Simpsonin metodi");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(kulmio);
        buttonGroup.add(suunnikas);
        buttonGroup.add(simpson);

        JLabel funktioTeksti = new JLabel("Funktio: ");
        JTextField funktioKentta = new JTextField();
        JLabel muuttujaTeksti = new JLabel("Muuttuja: ");
        JTextField muuttujaKentta = new JTextField();
        JLabel alarajaTeksti = new JLabel("Alaraja: ");
        JTextField alarajaKentta = new JTextField();
        JLabel ylarajaTeksti = new JLabel("Yläraja: ");
        JTextField ylarajaKentta = new JTextField();
        JLabel tarkkuusTeksti = new JLabel("Haluttu tarkkuus: ");
        JTextField tarkkuusKentta = new JTextField();

        JButton integroijaNappi = new JButton("Integroi!");

        JLabel tulosTeksti = new JLabel("Tulos: ");
        JTextField tulosKentta = new JTextField();
        JLabel virheTeksti = new JLabel("Virhe: ");
        JTextField virheKentta = new JTextField();

        container.add(kulmio);
        container.add(suunnikas);
        container.add(simpson);
        container.add(funktioTeksti);
        container.add(funktioKentta);
        container.add(muuttujaTeksti);
        container.add(muuttujaKentta);
        container.add(alarajaTeksti);
        container.add(alarajaKentta);
        container.add(ylarajaTeksti);
        container.add(ylarajaKentta);
        container.add(tarkkuusTeksti);
        container.add(tarkkuusKentta);
        container.add(integroijaNappi);

        container.add(tulosTeksti);
        container.add(tulosKentta);
        container.add(virheTeksti);
        container.add(virheKentta);
    }

    public JFrame getFrame() {
        return frame;
    }

}
