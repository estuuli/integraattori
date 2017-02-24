/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integraattori.logiikka;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * Luokka määrittelee funktion annetusta syötteestä.
 *
 * @author elina
 */
public class Funktio {
    
    private Expression funktio;
    private String funktionNimi;

    /**
     * Luokan konstruktori määrittelee annetusta String-syötteestä funktion.
     *
     * @param funktio käyttäjän antama funktio
     * 
     */
    public Funktio(String funktio) {
        this.funktionNimi = funktio;
        this.funktio = new ExpressionBuilder(funktio)
                .variables("x")
                .build();
    }
    
    /**
     * Metodi laskee funktion arvon annetussa pisteessä.
     *
     * @param piste piste, jossa funktion arvo lasketaan
     * 
     * @return funktion arvo doublena
     */
    public double funktionArvoPisteessa(double piste) {
        this.funktio.setVariable("x", piste);
        return this.funktio.evaluate();
    }
    
    /**
     * Metodi määrittää expressionin uudelleen funktion nimen perusteella.
     *
     * 
     */
    public void paivitaFunktio() {
        this.funktio = new ExpressionBuilder(funktionNimi)
                .variables("x")
                .build();
    }

    public void setFunktio(Expression funktio) {
        this.funktio = funktio;
    }

    public String getFunktionNimi() {
        return funktionNimi;
    }

    public void setFunktionNimi(String ftionNimi) {
        this.funktionNimi = ftionNimi;
    }

    public Expression getFunktio() {
        return funktio;
    }
    
    
    
    
    
    
    
}
