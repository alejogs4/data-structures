package linkedlist;

/**
 * Clase principal para la prueba de las listas enlazadas
 * @author alejandro Garcia Serna
 */
public class LinkedListMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node<String> n1 = new Node(); // La T es un Object
        Node<Person> n2 = new Node();
        Node<Object> n3 = new Node();
        
        Person p1 = new Person(1L, "Batistuta");
        Person p2 = new Person(2L, "Goicochea");
        Person p3 = new Person(3L, "Turing");
        Person p4 = new Person(4L, "Neumann");
        
        LinkedList<Person> people = new LinkedList<Person>();
        
        people.addLast(p1).addLast(p2).addLast(p2).addLast(p1).addLast(p3).deleteRepeat();
        
        //System.out.print(people.toString());
        System.out.println(System.currentTimeMillis());
        
        for(Person p : people) {
            System.out.println(p);
        }
    }
    
}
