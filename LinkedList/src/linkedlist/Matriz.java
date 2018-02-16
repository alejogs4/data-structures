/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author s115e17
 */
public class Matriz<T> {
    
    private Node<T> first;
    private int listSize = 0;
    
    public T getFirst() {
        return first == null ? null : first.getItem();
    }
    
    public void add (T item) {
        Node<T> newNode = new Node();
        newNode.setItem(item);
        if( this.first == null ) {
            first = newNode;
        }
        else {
            Node iterator = first;
            while(iterator != null) {
                if(iterator.getNext() == null) {
                    iterator.setNext(newNode);
                    break;
                }
                iterator = iterator.getNext();
            }
        }
        listSize++;
    }

    public T get(int i) {
        if( i >= 0 && i <= this.listSize ) {
            T node = getNode(i).getItem();
            return node;
        }
        return null;
    }
    
    private Node<T> getNode(int pos) {
        int i = 0;
        Node<T> iterator = first;
        while(iterator != null) {
            if(i == pos) {
                return iterator;
            } 
            i++;
            iterator = iterator.getNext();
        }
        return null;
    }
}
