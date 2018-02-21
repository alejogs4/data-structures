/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

/**
 * Clase autoreferenciada para construir la estructura
 * tipo lista enlazada que contendra tanto el item almacenado
 * como la referencia al siguiente elemento de la lista
 * @author ochoscar
 */
public class Node<T> {
    
    ////////////////////
    // Atributos
    ////////////////////
    
    /** Referencia al tipo T que ocupa el nodo */
    private T item;
    
    /** Autoreferencia al siguiente elemento */
    private Node<T> next;
    
    ////////////////////
    // Metodos
    ////////////////////
    
    /**
     * Constructor por defecto
     */
    public Node() {
        
    }
    
    /**
     * Constructor con parametros
     * @param pItem Item a almacenar en el nodo
     * @param pNext Siguiente elemento en la lista
     */
    public Node(T pItem, Node<T> pNext) {
        item = pItem;
        next = pNext;
    }
    
    /**
     * Constructor de copia
     * @param pNode Objeto que servira para realizar la copia de los 
     * atributos del nodo
     */
    public Node(Node<T> pNode) {
        item = pNode.getItem();
        next = pNode.getNext();
    }
    
    /**
     * Metodo que devuelve el nodo en su
     * representacion de string
     * @return Devuelve la representacion en String
     */
    @Override
    public String toString() {
        return item.toString();
    }

    /**
     * @return the item
     */
    public T getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(T item) {
        this.item = item;
    }

    /**
     * @return the next
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
}
