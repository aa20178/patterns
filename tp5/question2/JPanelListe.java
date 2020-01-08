package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class JPanelListe extends JPanel implements ActionListener, ItemListener 
{

    private JPanel cmd = new JPanel();
    private JLabel afficheur = new JLabel();
    private JTextField saisie = new JTextField();

    private JPanel panelBoutons = new JPanel();
    private JButton boutonRechercher = new JButton("rechercher");
    private JButton boutonRetirer = new JButton("retirer");

    private CheckboxGroup mode = new CheckboxGroup();
    private Checkbox ordreCroissant = new Checkbox("croissant", mode, false);
    private Checkbox ordreDecroissant = new Checkbox("dï¿½croissant", mode, false);

    private JButton boutonOccurrences = new JButton("occurrence");

    private TextArea texte = new TextArea();

    private List<String> liste;
    private Map<String, Integer> occurrences;

    public JPanelListe(List<String> liste, Map<String, Integer> occurrences)
    {
        this.liste = liste;
        this.occurrences = occurrences;

        cmd.setLayout(new GridLayout(3, 1));

        cmd.add(afficheur);
        cmd.add(saisie);

        panelBoutons.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBoutons.add(boutonRechercher);
        panelBoutons.add(boutonRetirer);
        panelBoutons.add(new JLabel("tri du texte :"));
        panelBoutons.add(ordreCroissant);
        panelBoutons.add(ordreDecroissant);
        panelBoutons.add(boutonOccurrences);
        cmd.add(panelBoutons);

        if(liste!=null && occurrences!=null)
        {
            afficheur.setText(liste.getClass().getName() + " et "+ occurrences.getClass().getName());
            texte.setText(liste.toString());
        }else{
            texte.setText("la classe Chapitre2CoreJava semble incomplï¿½te");
        }

        setLayout(new BorderLayout());

        add(cmd, "North");
        add(texte, "Center");

        boutonRechercher.addActionListener(this);
        boutonRetirer.addActionListener(this);
        boutonOccurrences.addActionListener(this);
        ordreCroissant.addItemListener(this);
        ordreDecroissant.addItemListener(this);

    }

    /** ne pas modifier les affichages, les classes de tests en ont besoin ... */
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            boolean res = false;
            if (ae.getSource() == boutonRechercher || ae.getSource() == saisie)
            {
                res = liste.contains(saisie.getText());
                Integer occur = occurrences.get(saisie.getText());
                afficheur.setText("rï¿½sultat de la recherche de : "+ saisie.getText() + " -->  " + res);
            }
            else if (ae.getSource() == boutonRetirer)
            {
                res = retirerDeLaListeTousLesElementsCommencantPar(saisie
                    .getText());
                afficheur.setText("rï¿½sultat du retrait de tous les ï¿½lï¿½ments commenï¿½ant par -->  "+ saisie.getText() + " : " + res);
            }
            else if (ae.getSource() == boutonOccurrences)
            {
                Integer occur = occurrences.get(saisie.getText());
                if (occur != null)
                    afficheur.setText(" -->  " + occur + " occurrence(s)");
                else
                    afficheur.setText(" -->  ??? ");
            }
            texte.setText(liste.toString());
        }
        catch (Exception e)
        {
            afficheur.setText(e.toString());
        }
    }


    public void itemStateChanged(ItemEvent ie)
    {


        if (ie.getSource() == ordreCroissant)
            liste.sort(Comparator.naturalOrder());
        else if (ie.getSource() == ordreDecroissant)
            liste.sort(Comparator.reverseOrder());

        texte.setText(liste.toString());
    }


    private boolean retirerDeLaListeTousLesElementsCommencantPar(String prefixe) {
        boolean resultat = false;
        // à compléter
        for (Iterator<String> mot = liste.iterator(); mot.hasNext();) {
            String currentMot = mot.next();
            if (currentMot.startsWith(prefixe)) {
                mot.remove();
                this.occurrences.put(currentMot,this.occurrences.get(currentMot)-1);
                resultat = true;
            }
        }
        return resultat;
    }
  

}
