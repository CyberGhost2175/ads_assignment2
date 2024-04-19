package MyInterfaces;

public interface MyQueueInterface<T> {
    void enqueue(T item);
    void dequeue();
    T peek();
    boolean isEmpty();
    int size();
}
