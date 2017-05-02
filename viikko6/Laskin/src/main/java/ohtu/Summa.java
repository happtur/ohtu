/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

public class Summa extends KivaNimi {

    Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }

    @Override
    protected void laske(int i) {
        sovellus.plus(i);
    }

    @Override
    protected void peruLaske(int i) {
        sovellus.miinus(i);
    }
    
}
