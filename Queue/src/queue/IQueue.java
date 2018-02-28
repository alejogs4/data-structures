/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

/**
 *
 * @author s115e17
 */
public interface IQueue<T> {
      public IQueue<T> add(T item);
      public IQueue<T> remove();
}
