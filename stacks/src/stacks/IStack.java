package stacks;
/**
 * Interfaz basica de la pila y los metodos que toda clase que sea representante de la pila debe implementar
 * @author Alejandro García Serna
 */
public interface IStack<T> {
    
    public boolean isEmpty();
    
    public int size();
    
    public IStack<T> push(T item);
    
    public T pop();
    
    public T peek();
        
}
