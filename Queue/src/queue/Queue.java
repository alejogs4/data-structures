package queue;
public class Queue {
    public static void main(String[] args) {
        QueueLinked<Personas> personas = new QueueLinked<Personas>();
        personas.add(new Personas(1L,"Alejandro"))
                .add(new Personas(2L,"Miguel"))
                .remove()
                .add(new Personas(3L,"Ingrid munera"));
        
        System.out.print(personas.toString());
    }    
}