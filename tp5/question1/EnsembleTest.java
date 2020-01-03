package question1;

public class EnsembleTest extends junit.framework.TestCase {

    public void testAdd()
    {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));
        assertEquals(false, e1.add(2));
        assertEquals(false, e1.add(3));


        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));
    }

    public void testUnion() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
                e2 = new question1.Ensemble<Integer>();
        e1.add(1);
        e1.add(3);
        e1.add(2);

        e2.add(3);
        e2.add(4);


        question1.Ensemble<Integer> union = e1.union(e2);
        assertEquals(4, union.size());
        assertTrue(union.contains(1));
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertTrue(union.contains(4));
    }

    public void testInter() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        e2 = new question1.Ensemble<Integer>();

        e1.add(2);
        e1.add(3);

        e2.add(3);
        e2.add(4);

        question1.Ensemble<Integer> inter = e1.inter(e2); // 2 3 vs 3 4
        assertEquals(1, inter.size());
        assertFalse(inter.contains(2));
        assertTrue(inter.contains(3));
        assertFalse(inter.contains(4));

    }
    public void testDif() {

        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        e2 = new question1.Ensemble<Integer>();

        e1.add(2);
        e1.add(3);

        e2.add(3);
        e2.add(4);


        question1.Ensemble<Integer> dif = e1.diff(e2); // 2 3 vs 3 4
        assertEquals(1, dif.size());
        assertTrue(dif.contains(2));
        assertFalse(dif.contains(3));
        assertFalse(dif.contains(4));

        question1.Ensemble<Integer> dif2 = e2.diff(e1); // 2 3 vs 3 4
        assertEquals(1, dif2.size());
        assertFalse(dif2.contains(2));
        assertFalse(dif2.contains(3));
        assertTrue(dif2.contains(4));
    }


    public void testDifSym()
        {


            question1.Ensemble<Integer> e1, e2;
            e1 = new question1.Ensemble<Integer>();
            e2 = new question1.Ensemble<Integer>();

            e1.add(2);
            e1.add(3);
            e1.add(4);
            e1.add(5);
            e1.add(66);


            e2.add(4);
            e2.add(5);
            e2.add(7);
            e2.add(6);
            e2.add(66);


            question1.Ensemble<Integer> diffSym = e1.diffSym(e2); // 2 3 vs 3 4
            assertTrue(diffSym.contains(2));
            assertTrue(diffSym.contains(3));
            assertTrue(diffSym.contains(6));
            assertTrue(diffSym.contains(7));
            assertFalse(diffSym.contains(4));
            assertFalse(diffSym.contains(5));
            assertFalse(diffSym.contains(66));

            assertEquals(4, diffSym.size());
        }
    }

