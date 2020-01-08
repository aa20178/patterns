package question3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math ;
import java.util.Observable;
import java.util.Observer;

public class Vue extends JPanel implements Observer
{// à compléter
       
    private int min, max, random ; 
    private JLabel etatPile;
    private PileModele<Integer> pile;
    private String nomVue; 
    private double random_double = 0;

    public Vue(PileModele<Integer> pile)
    {
        super();
        min = 0 ; 
        max = 20;
        random = (int)java.lang.Math.random() * (1 + (max - min));
        
        this.nomVue = "vue" + random;
        this.pile = pile;
        this.etatPile = new JLabel("entrez des nombres entiers");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(etatPile);
        setBackground(Color.green);
        pile.addObserver(this);
    }

    public Vue(PileModele<Integer> pile, String vue)
    {
        super();
        this.nomVue = vue ; 
        this.pile = pile;
        this.etatPile = new JLabel("entrez des nombres entiers");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(etatPile);
        setBackground(Color.green);
        pile.addObserver(this);
    }

    public void update(Observable obs, Object arg)
    {
            etatPile.setText(pile.toString()); // ou obs.toString()  
    }

}
