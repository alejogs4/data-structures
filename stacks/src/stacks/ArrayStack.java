package stacks;
/**
 *
 * @author Alejandro Garcia Serna
 */
public class ArrayStack<T> implements IStack<T> {
    
    private T array[];
    
    private int stackSize;

    public ArrayStack() {
        array = (T[]) new Object[10];
        stackSize = 0;
    }
    
    @Override
    public boolean isEmpty() {
        return stackSize == 0;
    }

    @Override
    public int size() {
        return stackSize;
    }

    @Override
    public IStack<T> push(T item) {
        if(stackSize + 1 >= array.length) {
            redim(array.length * 2);
        }
        array[stackSize] = item;
        stackSize++;
        return this;
    }
    
    private void redim(int capacity) {
        T newArray[] = (T[]) new Object[capacity];
        for(int i = 0;i< array.length;i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    @Override
    public T pop() {
        T item =  stackSize == 0 ? null : array[stackSize - 1];
        array[stackSize - 1] = null;
        stackSize--; 
        return item;
    }

    @Override
    public T peek() {
        return stackSize == 0 ? null : array[stackSize - 1];
    }
    
    
}
