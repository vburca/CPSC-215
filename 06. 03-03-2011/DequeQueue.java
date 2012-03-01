/*
   Implements a Queue using dequeue.
   
   Date: 03-03-2011.
   File: DequeQueue.java
*/

/**
 * @author: Vlad Burca, Steve Petkovsek
 * @version: 03-03-2011
 */

public class DequeQueue<E> implements Queue<E> {

	protected Deque<E> deque;
	
  /**
   * Constructs a new Queue based on a dequeue.
   */
  public DequeQueue() {
	 deque = new NodeDeque<E>();
  }
	
  /**
   * Checks the size of the queue.
   * @return the size of the dequeue.
   */
  public int size() {
	 return deque.size();
  }
	
  /**
   * Inspects if the queue is empty or not.
   * @return true/false.
   * @exception EmptyQueueException if the queue is empty.
   */
  public boolean isEmpty() {
	 return deque.isEmpty();
  }

  /**
   * Inspects the element at the front of the queue.
   * @return element at the front of the queue.
   * @exception EmptyQueueException if the queue is empty.
   */
  public E front() {
  		return deque.getFirst();
  	}

  /** 
   * Inserts an element at the rear of the queue.
   * @param element new element to be inserted.
   */
  public void enqueue (E element) {
  		deque.addLast(element);
  	}

  /** 
   * Removes the element at the front of the queue.
   * @return element removed.
   * @exception EmptyQueueException if the queue is empty.
   */
  public E dequeue() {
     return deque.removeFirst();
  }
	
}
