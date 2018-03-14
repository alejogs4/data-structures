/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacks;

/**
 *
 * @author alejandro
 */
public class MyStackArray<T> implements IStack<T> {
    
    private int stackSize;
    private T [] array;
    
    public MyStackArray () {
        stackSize = 0;
        array = (T[]) new Object[10];
    }
    

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public int size() {
      return array.length;
    }

    @Override
    public IStack<T> push(T item) {
        if(stackSize + 1 >= array.length) {
            redim(stackSize * 2);
        }
        array[stackSize] = item;
        stackSize++;
        return this;
    }

    @Override
    public T pop() {
        T item = array[stackSize];
        array[stackSize - 1] = null;
        stackSize--;
        return item;
    }

    @Override
    public T peek() {
        return array[stackSize];
    }
    
    private void redim(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for(int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    
}
