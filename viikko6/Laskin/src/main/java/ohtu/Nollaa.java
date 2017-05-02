/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int ennenNollausta;

    Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.ennenNollausta = 0;
    }

    @Override
    public void suorita() {
        ennenNollausta = sovellus.tulos();
        sovellus.nollaa();

        syotekentta.setText("");
        tuloskentta.setText("0");
    }

    @Override
    public void peru() {
        sovellus.plus(ennenNollausta);
        tuloskentta.setText("" + sovellus.tulos());
    }
    
}
