package stacks;

/**
 *
 * @author Alejandro García Serna
 */
public class Stacks {
    public static void main(String[] args) {
       LinkedStack<Person> stackPerson = new LinkedStack<>();       
       stackPerson.push(new Person(1l,"Alejandro")).push(new Person(2l,"Ingrid")).push(new Person(3l,"carlos"));       
       System.out.print(stackPerson.pop().toString());
    }
    
}
