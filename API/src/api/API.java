package api;
import java.util.*;
import java.util.function.Consumer;
/**
 * @author Alejandro Garcia Serna
 */
public class API {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persons p1 = new Persons(1L,"Puskas");
        Persons p2 = new Persons(2L,"Barbosa");
        Persons p3 = new Persons(3L,"Miguel");
        ArrayList<Persons> personsList = new ArrayList<>();
        
        personsList.add(p1);
        personsList.add(p2);
        personsList.add(p2);
        
        personsList.remove(0);
        System.out.print(personsList.toString());
    }
    
}
