            package question3;
            
            import question3.tp3.PileI;
            import question3.tp3.PilePleineException;
            import question3.tp3.PileVideException;
            
            import java.awt.*;
            import javax.swing.*;
            import java.awt.event.*;
            
            /**
             * Décrivez votre classe Controleur ici.
             * 
             * @author (votre nom)
             * @version (un numéro de version ou une date)
             */
            public class Controleur extends JPanel implements ActionListener 
            {
                private JButton push, add, sub, mul, div, clear;
                private PileModele<Integer> pile;
                private JTextField donnee;
            
                public Controleur(PileModele<Integer> pile)
                {
                    super();
                    this.pile = pile;
                    this.donnee = new JTextField(8);
                    
                    this.push = new JButton("push");
                    this.add = new JButton("+");
                    this.sub = new JButton("-");
                    this.mul = new JButton("*");
                    this.div = new JButton("/");
                    this.clear = new JButton("[]");
            
                    setLayout(new GridLayout(2, 1));
                    add(donnee);
                    
                    donnee.addActionListener(this);
                    
                    JPanel boutons = new JPanel();
                    boutons.setLayout(new FlowLayout());
                    
                    boutons.add(push);
                    push.addActionListener(this );
                    boutons.add(add);
                    add.addActionListener(this );
                    boutons.add(sub);
                    sub.addActionListener(this );
                    boutons.add(mul);
                    mul.addActionListener(this );
                    boutons.add(div);
                    div.addActionListener(this );
                    boutons.add(clear);
                    clear.addActionListener(this );
                    
                    
                    add(boutons);
                    boutons.setBackground(Color.red);
                    actualiserInterface();
                }
            
                public void actionPerformed(ActionEvent e) 
                {
                                
                    if (e.getActionCommand().equals("push") && !donnee.getText().isEmpty())
                    {
                        try 
                        {
                            pile.empiler(operande());
                        }
                        catch(NumberFormatException nfe){  }
                        catch(Exception ex){  ex.printStackTrace();}
                        finally{            actualiserInterface();}     
                }
                                      
            if (e.getActionCommand().equals("+")&& !donnee.getText().isEmpty())
            {
                actualiserInterface();
                try 
                {   
                    int a = pile.depiler();
                    int b = pile.depiler() ;  
                    pile.empiler(a+b);
                }
                catch(Exception ex){donnee.setText("NON");}
                finally{            actualiserInterface();}
       
        }

        if (e.getActionCommand().equals("-")&& !donnee.getText().isEmpty())
        {
                actualiserInterface();
                try 
                {
                    int a = pile.depiler();
                    int b = pile.depiler() ;  
                    
                    pile.empiler(b- a);}
                    catch(NumberFormatException nfe){  }
                catch(Exception ex){ }
                 finally{            actualiserInterface();}
        }
            
         
        if (e.getActionCommand().equals("*")&& !donnee.getText().isEmpty())
        {
                actualiserInterface();
                try 
                {pile.empiler(pile.depiler() * pile.depiler());}
                catch(Exception ex){ }
                 finally{            actualiserInterface();}
        }     
        
        if (e.getActionCommand().equals("/")&& !donnee.getText().isEmpty())
        {       
                actualiserInterface();
                try 
                {
                    int a = pile.depiler() ; 
                    int b = pile.depiler();
                    if (a==0)
                    {/*pile.empiler(b);*/}
                    else
                    {pile.empiler(b/a);}
                }
                catch(Exception ex){ }            
                finally{            actualiserInterface();}

            }
        
        if (e.getActionCommand().equals("[]"))
        {
            actualiserInterface();
            try{pile.clearPile();}
            catch(PileVideException ez){}
            finally{actualiserInterface();}
        }
    }
    
    
    public void actualiserInterface()
    {
        if(pile.estVide())
        {
            sub.setEnabled(false);
            add.setEnabled(false);
            div.setEnabled(false);
            mul.setEnabled(false);
            clear.setEnabled(false);

            
        }
         
        else if (pile.taille()<2)
        {
            sub.setEnabled(false);
            add.setEnabled(false);
            div.setEnabled(false);
            mul.setEnabled(false);
            clear.setEnabled(true);

        }
        
        else if (pile.estPleine())
        {
            push.setEnabled(false);
            clear.setEnabled(true);
        }
        
        else
        {
            push.setEnabled(true);
            sub.setEnabled(true);
            add.setEnabled(true);
            div.setEnabled(true);
            mul.setEnabled(true);
            clear.setEnabled(true);
            
        }
        
    }

    private Integer operande() throws NumberFormatException 
    {
        return Integer.parseInt(donnee.getText());
    }
}
