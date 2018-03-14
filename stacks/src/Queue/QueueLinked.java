package Queue;

/**
 * @author Alejandro Garcia Serna
 * @param <T>
 */
public class QueueLinked< T extends Comparable<T> > implements IQueue<T> {

    private Node<T> back;
    private int queueSize = 0;

    private Node<T> getFront() {
        Node<T> previousFront = back;
        while (previousFront != null) {
            if (previousFront.getNext().getNext() == null) {
                return previousFront;
            }
            previousFront = previousFront.getNext();
        }
        return null;
    }

    public int size() {
        return queueSize;
    }

    @Override
    public IQueue add(T item) {
        back = new Node(item, back);
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

    public QueueLinked sortByAge() {
        QueueLinked<T> aux = new QueueLinked<>();
        T ages[] = getSortArray(getTArray());
        for (int i = 0; i < ages.length; i++) aux.add(ages[i]);
        return aux;
    }
    private T[] getTArray() {
        T ages[] = (T[]) new Comparable[queueSize];
        int index = 0;
        Node<T> iterator = back;
        while (iterator != null) {
            ages[index] = iterator.getItem();
            index++;
            iterator = iterator.getNext();
        }
        return ages;
    }

    private T[] getSortArray(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int before = i - 1;
            while (before > -1 && (key.compareTo(array[before]) == 1)) {
                array[before + 1] = array[before];
                before--;
            }
            array[before + 1] = key;
        }
        return array;
    }
    
    public String toString() {
        String strReturn = "";
        Node<T> node = back;
        while (back != null) {
            strReturn += back.getItem().toString() + " ";
            back = back.getNext();
        }
        return strReturn;
    }

}
