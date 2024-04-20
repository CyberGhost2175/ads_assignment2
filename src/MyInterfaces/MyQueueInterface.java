package MyInterfaces;
// A queue operates under a FIFO  principle.
public interface MyQueueInterface<T> {
    void enqueue(T item);  // Enqueues an item at the back of the queue.
    void dequeue();  // Dequeues an item from the front of the queue.
    T peek(); // Peeks at the front item of the queue without removing it.
    boolean isEmpty(); // Checks if the queue is empty.
    int size(); // Returns the number of items in the queue.
}
