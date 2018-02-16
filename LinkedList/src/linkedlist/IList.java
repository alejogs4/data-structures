/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 * Provee las acciones que se pueden realizar con una lista
 * @author ochoscar
 */
public interface IList<T> {
    
    public boolean isEmpty();
    
    public T getFirst();
    
    public T getLast();
    
    public T get(int i); // a[3]   a.get(3)
    
    public void set(T p, int i);
    
    public int size(); // a.length  a.size()
    
    public LinkedList<T> addLast(T p);
    
    public LinkedList<T> add(T p, int i);
    
    public void remove(T p);
    
    public void remove(int i);
    
    public boolean contains(T p);
    
}
