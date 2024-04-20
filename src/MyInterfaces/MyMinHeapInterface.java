package MyInterfaces;

public interface MyMinHeapInterface<T> {
    void insert(T item); // Inserts an item into the heap.
    void removeSmallest(); // Removes the smallest item from the heap.
    T get(int index);  // returns the item at a specific index.
    T getSmallest();   // return the smallest item in the heap without removing it.
    void clear(); // Clears all the items from the heap.
}
