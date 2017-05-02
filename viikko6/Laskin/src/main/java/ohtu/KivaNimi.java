/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

public abstract class KivaNimi implements Komento {
    protected Sovelluslogiikka sovellus;
    protected JTextField tuloskentta;
    protected JTextField syotekentta;
    protected int sopivaNimi;
    
    KivaNimi(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sopivaNimi = 0;
    }

    @Override
    public void suorita() {
        sopivaNimi = 0;
        
        try {
            sopivaNimi = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        
        this.laske(sopivaNimi);
         
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        this.peruLaske(sopivaNimi);
        tuloskentta.setText("" + sovellus.tulos());
    }
    
    protected abstract void laske(int i);
    protected abstract void peruLaske(int i);
    
}
