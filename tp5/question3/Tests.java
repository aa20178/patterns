package question3;

import java.util.Set;

public class Tests extends junit.framework.TestCase {

    public void test1(question3.Factory/* � compl�ter */f) throws Exception {
        // Set<Integer> set = f.create();
        // for (int i = 20; i > 0; i--)
            // set.add(i);
    }

    public void testCreation() {
        try {
            // test1(new TreeSetFactory<Integer>());
            // test1(new HashSetFactory<Integer>());
        } catch (NoSuchMethodError e) {
            fail("NoSuchMethodError : " + e.getMessage());
        } catch (Exception e) {
            fail(" exception inattendue : " + e.getMessage());
        }
    }
    
       public void test_TreeSetFactory(){
        try{
            // question3.TreeSetFactory<Integer> treeSetF1 = new question3.TreeSetFactory<Integer>();
            // java.util.Set<Integer> ts = treeSetF1.create();
            // assertNotNull("appel de create retourne null ???", ts);
            // assertEquals(" un TreeSet est attendu ???", ts.getClass().getName(), "java.util.TreeSet");
            // assertEquals(true, ts.add(5));
            // assertEquals(true, ts.add(3));
            // assertEquals(false, ts.add(3));
            // assertEquals("[3, 5]", ts.toString());
        }catch(NoSuchMethodError e){
            fail(" exception : " + e.getMessage());
        }catch(NoClassDefFoundError e){
            fail(" exception : " + e.getMessage());
        }catch(Exception e){
            fail(" exception inattendue : " + e.getMessage());
        }
    }



}
