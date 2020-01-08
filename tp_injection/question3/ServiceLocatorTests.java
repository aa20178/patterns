package question3;


import container.ApplicationContext;
import container.Factory;
import service_locator.*;
import java.util.*;

public class ServiceLocatorTests extends junit.framework.TestCase{

    public void testServiceLocator() throws Exception{
        ApplicationContext ctx = Factory.createApplicationContext("./question3/README.TXT");

        ServiceLocatorI serviceLocator = ctx.getBean("serviceLocator");
        List<String> beans = new ArrayList<>();
        System.out.println("Liste des beans issue du service locator");
        for(String service : ctx){
            System.out.println("\t" + service);
        }

        System.out.println("\nListe des beans accessibles depuis le service locator");
        for(String service : serviceLocator){
            System.out.println("\t" + service);
            beans.add(service);
        }

    
        List<String> beans2 = new ArrayList<>();
        Iterator<ApplicationContext> itContainers = serviceLocator.iteratorContainers();
        while(itContainers.hasNext()){
            ApplicationContext container = itContainers.next();
            Iterator<String> itServices = serviceLocator.iteratorServices(container);
            while(itServices.hasNext()){
                String service = itServices.next();
                System.out.println("\t" + service);
                beans2.add(service);
            }
        }
  
    }

    public void testServiceLocator2() throws Exception{
        ApplicationContext ctx = Factory.createApplicationContext("./question3/README.TXT");
        ServiceLocatorI serviceLocator = ctx.getBean("serviceLocator");
           // sur ce test deux beans avec le même nom, mais de deux conteneurs distincts
        List<Integer> liste1 = serviceLocator.lookup("QUESTION1","liste");
        assertNotNull(liste1);
        assertEquals(2,liste1.size());

        List<Integer> liste2 = serviceLocator.lookup("QUESTION2","liste");
        assertNotNull(liste2);
        assertEquals(2,liste2.size());
    }

}
