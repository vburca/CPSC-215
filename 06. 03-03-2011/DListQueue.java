public class DListQueue<E> implements Queue<E> {

    private DList<E> dlist = new DList<E>();

    //    public DListQueue<E>() {
    //	dlist = new DList<E>();
    //    }


 /** 
  * Returns the number of elements in the queue.
  * @return number of elements in the queue.
  */
    public int size() {
	return dlist.size();
    }  

 /** 
  * Returns whether the queue is empty.
  * @return true if the queue is empty, false otherwise.
  */
    public boolean isEmpty() {
	return dlist.isEmpty();
    }

 /**
  * Inspects the element at the front of the queue.
  * @return element at the front of the queue.
  * @exception EmptyQueueException if the queue is empty.
  */
    public E front() throws EmptyQueueException {
	DLNode<E> node = dlist.getFirst();
	return node.getElement();
    }

 /** 
  * Inserts an element at the rear of the queue.
  * @param element new element to be inserted.
  */
    public void enqueue (E element) {
	DLNode<E> node = new DLNode(element, null, null);
	dlist.addLast(node);
    }
 
 /** 
  * Removes the element at the front of the queue.
  * @return element removed.
  * @exception EmptyQueueException if the queue is empty.
  */
    public E dequeue() throws EmptyQueueException {
	DLNode<E> node = dlist.getFirst();
	dlist.remove(node);
	return node.getElement();
    }

    public String toString() {
	return dlist.toString();
    }


    public static void main(String args[]) {
	DListQueue q = new DListQueue<String>();

	for (int k = 0; k < 5; k++) {  // Insert 5 numbers
	    q.enqueue("" + k);
	    System.out.println(q.toString());
	}

	while (!q.isEmpty()) {         // Empty the queue
	    System.out.println(q.dequeue());
	}

    }

}