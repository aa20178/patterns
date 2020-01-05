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
    private Checkbox ordreDecroissant = new Checkbox("d�croissant", mode, false);

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
            texte.setText("la classe Chapitre2CoreJava semble incompl�te");
        }

        setLayout(new BorderLayout());

        add(cmd, "North");
        add(texte, "Center");

        boutonRechercher.addActionListener(this);
        boutonRetirer.addActionListener(this);
        boutonOccurrences.addActionListener(this);

// � compl�ter;

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
                afficheur.setText("r�sultat de la recherche de : "+ saisie.getText() + " -->  " + res);
            }
            else if (ae.getSource() == boutonRetirer)
            {
                res = retirerDeLaListeTousLesElementsCommencantPar(saisie
                    .getText());
                afficheur.setText("r�sultat du retrait de tous les �l�ments commen�ant par -->  "+ saisie.getText() + " : " + res);
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
        TriDecroissant td = new TriDecroissant();
        TriCroissant tc = new TriCroissant();

        if (ie.getSource() == ordreCroissant)
        Collections.sort(liste,tc  );
        else if (ie.getSource() == ordreDecroissant)
        Collections.sort(liste,td  );

        texte.setText(liste.toString());
    }

    private boolean retirerDeLaListeTousLesElementsCommencantPar(String prefixe)
    {
        boolean resultat = false;
        resultat = liste.removeIf(Pattern.compile(saisie.getText()+"*").asPredicate());
        return resultat;

    }

    class TriCroissant implements Comparator<String>
    {
        public int compare(String obj1, String obj2)
        {
            if (obj1 == obj2)
            {
                return 0;
            }
            if (obj1 == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj1.compareTo(obj2);
        }


    }

    private class TriDecroissant implements Comparator<String>
    {
        public int compare(String obj1, String obj2)
        {
            if (obj1 == obj2)
            {
                return 0;
            }
            if (obj1 == null)
            {
                return -1;
            }
            if (obj2 == null)
            {
                return 1;
            }
            return -obj1.compareTo(obj2);
        
    }


}
}