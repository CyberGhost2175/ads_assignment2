package MyInterfaces;
// A stack operates under a LIFO  principle.
public interface   MyStackInterface<T> {
    void push(T item); // Pushes an item onto the top of the stack.
    void pop(); // Pops the top item off the stack.
    T get();  // return the item at the top of the stack
    void clear(); // Clears all items from the stack.
}
