package question1;

import java.util.*;

public class Ensemble<T> extends AbstractSet<T> 
{

    protected java.util.Vector<T> table = new java.util.Vector<T>();

    public int size() 
    {
        return table.size();
    }

    public Iterator<T> iterator() 
    {
        return table.iterator();
    }

    public boolean add(T t)
    {
        if (this.contains(t))
            return false;

        else return table.add(t);
        }


    public Ensemble<T> union(Ensemble<? extends T> e)
    {

            Ensemble<T> unionE = new Ensemble<T>();
            unionE.addAll(this);
            unionE.addAll(e);
            return unionE;

    }

    public Ensemble<T> inter(Ensemble<? extends T> e)
    {
        Ensemble<T> interE = new Ensemble<T>();


            interE.addAll(this);
            interE.retainAll(e);
            return interE;
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {

            Ensemble<T> interE = new Ensemble<T>();
            interE.addAll(this.union(e));
            interE.removeAll(e);
            return interE;

    }

    Ensemble<T> diffSym(Ensemble<? extends T> e) 
    {
   
            Ensemble<T> ens = this.union(e);
            Ensemble<T> elements = this.inter(e);  
                        
            return ens.diff(elements);

       
    }
    
    }
    

