package MyInterfaces;

public interface MyMinHeapInterface<T> {
    void insert(T item);
    void removeSmallest();
    T get(int index);
    T getSmallest();
    void clear();
}
