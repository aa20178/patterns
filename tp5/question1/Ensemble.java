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
        if (table.contains(t))
            return false;

        else
        {
            table.add(t);
            return true;
        }
    
    }


    public Ensemble<T> union(Ensemble<? extends T> e)
    {
        if (!e.isEmpty())
        {
            Ensemble<T> unionE = new Ensemble<T>();
            unionE.addAll(this);
            unionE.addAll(e);
            return unionE;
        }
        else return this; // la réunion avec un ensemble vide redonne l'ensemble non vide

    }

    public Ensemble<T> inter(Ensemble<? extends T> e)
    {
        if (!e.isEmpty())
        {
            Ensemble<T> interE = new Ensemble<T>();
            interE.addAll(this);
            interE.retainAll(e);
            return interE;
        }
        else return new Ensemble<T>(); // l'intersection avec un ensemble vide est un ensebmble vide*/
    }

    public Ensemble<T> diff(Ensemble<? extends T> e) {
        if (!e.isEmpty())
        {
            Ensemble<T> interE = new Ensemble<T>();
            interE.addAll(this);
            interE.addAll(e);
            interE.removeAll(e);
            return interE;
        }
        else return this;
    }

    Ensemble<T> diffSym(Ensemble<? extends T> e) 
    {
        if (!e.isEmpty())
        {
            return this.union(e).diff(this.inter(e));

        }
        else return this;
    }
    }
    

