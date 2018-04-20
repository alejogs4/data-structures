/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 * Clase que permite encapsular los items en un arbol binario
 * @author ochoscar
 */
public class BinaryNode<T> {
    
    ////////////////////////
    // Atributos
    ////////////////////////
    
    private T item;
    
    private BinaryNode<T> left;
    
    private BinaryNode<T> right;
    
    ////////////////////////
    // Metodos
    ////////////////////////
    
    /**
     * Metodo contructor por defecto
     */
    public BinaryNode() {}
    
    /**
     * Metodo constructor con parametros
     * @param item Item contenido en el arbol
     * @param left Referencia al nodo hijo izquierdo
     * @param right Referencia al nodo hijo derecho
     */
    public BinaryNode(T item, BinaryNode<T> left, BinaryNode<T> right) {
        this.item = item;
        this.left = left;
        this.right = right;
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
     * @return the left
     */
    public BinaryNode<T> getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public BinaryNode<T> getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
    
}
