package MyInterfaces;

// Defines a generic interface for list , extending Iterable to allow for-each loop capabilities
public interface MyListInterface<T> extends Iterable<T> {
    void add(T item); // Adds an item to the end of the list
    void set(int index, T item); // Sets the item at the specified index, replacing the current item at that position
    void add(int index, T item); // Inserts an item at the specified index, shifting subsequent items right
    void addFirst(T item); // Adds an item to the beginning of the list
    void addLast(T item); // Adds an item to the end of the list, synonymous to add(T item)
    T get(int index); // Retrieves the item at the specified index
    T getFirst(); // Retrieves the first item in the list
    T getLast(); // Retrieves the last item in the list
    void remove(int index); // Removes the item at the specified index, shifting subsequent items left
    void removeFirst(); // Removes the first item in the list
    void removeLast(); // Removes the last item in the list
    void sort(); // Sorts the list according to the natural ordering of its elements or a provided Comparator
    int indexOf(Object object); // Returns the index of the first occurrence of the specified object in the list
    int lastIndexOf(Object object); // Returns the index of the last occurrence of the specified object in the list
    boolean exists(Object object); // Returns true if the specified object exists in the list, otherwise false
    Object[] toArray(); // Returns an array containing all of the elements in the list in proper sequence
    void clear(); // Clears the list, removing all elements
    int size(); // Returns the number of elements in the list
}
