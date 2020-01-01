package question1; 

public class PatternObservateur extends junit.framework.TestCase
{

    public void testNotify() 
    {
        ConcreteSubject subject = new ConcreteSubject();           // cr�ation d'un "observ�" constitu� d'une liste
        question1.ConcreteObserver observer = new ConcreteObserver();      // cr�ation d'un observateur
        subject.addObserver(observer);             // ajouter cet observateur � la liste
        subject.insert("il fait beau, ce matin");  // modification de cette liste, l'observateur doit
                                                // (ervrait) �tre notifi�

        // "v�rification" :
        assertFalse(observer.senders().empty());                            // elle ne doit pas �tre vide,
        assertEquals(subject, observer.senders().pop());                       // est-ce le bon �metteur ?
        assertEquals("il fait beau, ce matin", observer.arguments().pop()); // le param�tre re�u est-il correct ?
    }

    // une liste, 2 observateurs
    public void test1() 
    {
        ConcreteSubject l1 = new ConcreteSubject();
        ConcreteObserver o1 = new ConcreteObserver();
        ConcreteObserver o2 = new ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);

        l1.insert("test");
        l1.insert(" 1 ");


        assertEquals(l1, o1.senders().pop());
        assertEquals(" 1 ", o1.arguments().pop());

        assertEquals(l1, o1.senders().pop());
        assertEquals("test", o1.arguments().pop());
        
        assertEquals(l1, o2.senders().pop());
        assertEquals(" 1 ", o2.arguments().pop());

        assertEquals(l1, o2.senders().pop());
        assertEquals("test", o2.arguments().pop());
        
        

        // ne pas modifier ces lignes, derni�res assertions vraies de cette
        // m�thode
        assertTrue(o1.senders().empty() && o1.arguments().empty());
        assertTrue(o2.senders().empty() && o2.arguments().empty());
    }

    
    // deux listes, 1 observateur
    public void test2()
    {
        ConcreteSubject l1 = new ConcreteSubject();
        ConcreteSubject l2 = new ConcreteSubject();

        ConcreteObserver o = new ConcreteObserver();
        l1.addObserver(o);
        l2.addObserver(o);
        
        l1.insert("testA1");
        l1.insert("testA2");
        
        l2.insert("testB1");
        l2.insert("testB2");



        assertFalse(o.senders().empty());
        assertFalse(o.arguments().empty());

        
        
        assertEquals(l2, o.senders().pop());
        assertEquals("testB2", o.arguments().pop());
        
        assertEquals(l2, o.senders().pop());
        assertEquals("testB1", o.arguments().pop());

        
        assertEquals(l1, o.senders().pop());
        assertEquals("testA2", o.arguments().pop());
        
        
        assertEquals(l1, o.senders().pop());
        assertEquals("testA1", o.arguments().pop());
        

        



        // ne pas modifier cette ligne, derni�re assertion vraie de cette
        // m�thode
        assertTrue(o.senders().empty() && o.arguments().empty());
    }

    // deux listes, 2 observateurs
    public void test3() 
    {
    
        ConcreteSubject l1 = new ConcreteSubject();
        ConcreteSubject l2 = new ConcreteSubject();
        ConcreteObserver o1 = new ConcreteObserver();
        ConcreteObserver o2 = new ConcreteObserver();
    
        l1.addObserver(o1);
        l1.addObserver(o2);
    
        l2.addObserver(o1);
        l2.addObserver(o2);

        // � compl�ter � partir de la ligne 81
        // v�rifier le bon fonctionnement de countObservers(), de deleteObserver
        // et deleteObservers()

        assertEquals(2, l1.countObservers() );
        assertEquals(2, l2.countObservers() );

        l1.deleteObserver(o1);
        assertEquals(1, l1.countObservers() );

        l2.deleteObserver(o1);
        assertEquals(1, l2.countObservers() );

        l2.deleteObservers();
        assertEquals(0, l2.countObservers() );
        
        l1.deleteObservers();
        assertEquals(0, l1.countObservers() );



        // � compl�ter !!

        // ne pas modifier ces lignes, derni�res assertions vraies de cette
        // m�thode
        assertTrue(o1.senders().empty());
        assertTrue(o2.senders().empty());
        assertTrue(l1.countObservers() == 0);
        assertTrue(l2.countObservers() == 0);
    }
    
}
