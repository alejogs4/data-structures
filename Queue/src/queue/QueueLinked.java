package queue;

/**
 *
 * @author s115e17
 */
public class QueueLinked<T> implements IQueue<T> {

    private Node<T> back;
    private int queueSize = 0;
    
    private Node<T> getFront() {
        Node<T> previousFront = back;
        while(previousFront != null) {
            if(previousFront.getNext().getNext() == null) return previousFront;
            previousFront = previousFront.getNext();
        }
        return null;
    }
    public int size() {
        return queueSize;
    }
    @Override
    public IQueue add(T item) {
        back = new Node(item,back);           
        queueSize++;
        return this;
    }

    @Override
    public IQueue remove() {
        Node<T> previousFront = getFront();
        previousFront.setNext(null);
         queueSize--;
        return this;
    }
    
    public String toString() {
        String strReturn = "";
        Node<T> node = back;
        while(back != null) {
            strReturn += back.getItem().toString() + " ";
            back = back.getNext();
        }
        return strReturn;
    }
    
}
