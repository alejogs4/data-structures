package Queue;
public class Queue {
    public static void main(String[] args) {
        QueueLinked<Personas> p = new QueueLinked<Personas>();
        p.add(new Personas(1L,"Hola",18))
                .add(new Personas(2L,"Miguel",25))
                .add(new Personas(3L,"Ingrid munera",16));
        p = p.sortByAge();
        
        System.out.print(p.toString());
    }    
}