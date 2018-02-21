package stacks;

/**
 * Clase que representa una pila
 * @author Alejandro Garcia Serna
 */
public class LinkedStack<T> implements IStack<T> {
    
    private Node<T> top;
    
    private int stackSize = 0;

    @Override
    public boolean isEmpty() {
        return stackSize == 0;
    }

    @Override
    public int size() {
        return stackSize;
    }

    @Override
    public LinkedStack<T> push(T item) {   
       top = new Node(item,top);   
       stackSize++;
       return this;
    }

    @Override
    public T pop() {
        T deleted = top.getItem();
        top = top.getNext();
        stackSize--;
        return deleted;
    }

    @Override
    public T peek() {
        return top.getItem();
    }
}
