/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integraattori.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokka kuuntelee monivalintanappien valintaa.
 *
 * @author elina
 */
public class MetodinValinnanKuuntelija implements ActionListener {

    private String komento;

    /**
     * Luokan konstruktori.
     *
     */
    public MetodinValinnanKuuntelija() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.komento = e.getActionCommand();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getKomento() {
        return komento;
    }

}
