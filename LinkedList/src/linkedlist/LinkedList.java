/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 * Clase que encapsula las diferentes acciones de una lista enlazada
 * @author ochoscar
 * @param <T> Tipo generico que contra los item de la lista
 */
public class LinkedList<T> implements IList<T> {
    
    ////////////////////
    // Atributos
    ////////////////////
    
    /** Referencia al primer nodo de la lista */
    private Node<T> first;
    
    /** Tamaño de la lista */
    private int listSize = 0;
    
    ////////////////////
    // Metodos
    ////////////////////

    /**
     * Obtiene el primer item de la lista
     * @return Devuelve la Clase al principio de la lista
     * null en caso que la lista este vacia
     */
    @Override
    public T getFirst() {
        return first != null ? first.getItem() : null;
    }

    /**
     * Obtiene el ultimo elemento de la lista
     * @return Devuelve la ultima Clase en la lista
     * null si la lista esta vacia
     */
    @Override
    public T getLast() {
        return listSize == 0 ? null : getNode(listSize - 1).getItem();
    }

    /**
     * Devuelve el iesimo elemento de la lista
     * @param i Posicion del elemento a devolver (comienza en 0)
     * @return Devuelve la Clase en la posicion i
     */
    @Override
    public T get(int i) {
        if(i >= 0 && i < listSize) {
            return getNode(i).getItem();
        }
        return null;
    }

    @Override
    public void set(T p, int i) {
        if(i >= 0 && i < listSize) {
            getNode(i).setItem(p);
        }
    }

    /**
     * Metodo que determina el tamaño de la lista
     * @return Devuelve un entero que indica el tamaño de la lista
     */
    @Override
    public int size() {
        return listSize;
    }

    /**
     * Metodo que inserta al final de la lista
     * @param p Objeto a insertar
     * @return Devuelve la propia lista enlazada
     */
    @Override
    public LinkedList<T> addLast(T p) {
        add(p, listSize);
        return this;
    }

    /**
     * Metodo que permite agregar un objeto en un posicion
     * arbitraria de la lista
     * @param p Objeto que se quiere agregar a la lista
     * @param i posicion en la cual se quiere agregar
     * @return Devuelve la propia lista enlazada
     */
    @Override
    public LinkedList<T> add(T p, int i) {
        if(i >= 0 && i <= listSize) {
            Node<T> newNode = new Node();
            newNode.setItem(p);
            // La lista esta vacia
            if(first == null) {
                first = newNode;
            } else {
                // La lista no esta vacia, y van a inserta
                // en la posicion 0
                if(i == 0) {
                    newNode.setNext(first);
                    first = newNode;
                } else if(i == listSize) {
                    // Se quiere insertar al final de la lista
                    Node<T> last = getNode(listSize - 1);
                    last.setNext(newNode);
                } else {
                    Node<T> previous = getNode(i - 1);
                    Node<T> current = previous.getNext();
                    newNode.setNext(current);
                    previous.setNext(newNode);
                }
            }
            listSize++;
        }
        return this;
    }

    /**
     * Metodo que elimina un elemento dado un objeto
     * @param p Objeto a eliminar
     */
    @Override
    public void remove(T p) {
        Node<T> aux = first;
        int i = 0;
        boolean find = false;
        if(contains(p)){
            while(true){
                if(aux.getItem().equals(p)){
                    break;
                }else{
                    aux = aux.getNext();
                    i++;
                }
            }
            remove(i);
        }
    }

    /**
     * Metodo que remueve un elemento de la lista
     * @param i Posicion o indice a eliminar de la lista
     */
    @Override
    public void remove(int i) {
        if(i >= 0 && i < listSize) {
            // La posicion a eliminar es valida, se procede a eliminar
            if(i == 0) {
                first = first.getNext();
            } else {
                Node<T> previous = getNode(i - 1);
                previous.setNext(previous.getNext().getNext());
            }
            // Disminuye el tamaño de la lista
            listSize--;
        }
    }

    /**
     * Devuleve si esta o no
     * @param p Objeto a verificar si esta en la lista
     * @return Devuelve true si p esta en la lista false sino
     */
    @Override
    public boolean contains(T p) {
        Node<T> iterator = first;
        while(iterator != null) {
            if(iterator.getItem().equals(p)) {
                return true;
            }
            iterator = iterator.getNext();
        }
        return false;
    }

    /**
     * Metodo que verifica si la lista esta vacia
     * @return Devuelve true si la lista esta 
     * vacia y false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }
    
    /**
     * Metodo que devuelve la lista en su
     * representacion de string
     * @return Devuelve la representacion en String
     */
    @Override
    public String toString() {
        String strToReturn = "[ ";
        Node<T> iterator = first;
        while(iterator != null) {
            strToReturn += iterator.toString() + " ";
            iterator = iterator.getNext();
        }
        return strToReturn + "]";
    }
    
    /**
     * Metodo que devuelve un nodo dada una posicion
     * @param pos Posicion de la lista para retornar el nodo
     * @return Devuelve el nodo indicado en el parametro pos
     */
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
    
    public int indexOf(T item) {
        int index = 0;
        
        Node<T> iterator = first;
        
        while( iterator != null ){
            if(iterator.getItem().equals(item)){
                return index;
            }
            else {
                index++;
            }
            iterator = iterator.getNext();
        }
        return -1;
    }
    
    public void swap (int i , int j) {
        if( i >= 0 && i < listSize && j >= 0 && j < listSize && i != j   ) {
            Node<T> firstItem = getNode(i);
            Node<T> secondItem = getNode(j);
            
            T aux = firstItem.getItem();
            firstItem.setItem(secondItem.getItem());
            secondItem.setItem(aux);
        }

    }
    
    public IList<T> clone() {
        IList<T> newList = new LinkedList<>();
        for(int i = 0; i < this.size();i++) {
            newList.addLast(this.get(i));
        }
        return newList;
    }
    
    public IList<T> deleteRepeat() {
        for(int i = 0 ; i < this.size();i++) {
            Node<T> node = getNode(i); 
            for(int j = 0 ; j < this.size();j++) {
                if(i != j){
                    Node<T> nodeToView = getNode(j);
                    if(nodeToView.getItem().equals(node.getItem())){
                        remove(j);
                    }
                }                               
            }
        }        
        return this;
    }
}
    
