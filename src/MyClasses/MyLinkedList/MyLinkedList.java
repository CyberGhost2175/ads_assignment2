package MyClasses.MyLinkedList;

import MyExceptions.MyNoSuchElementException;
import MyExceptions.MyIndexOutOfBoundsException;
import MyInterfaces.MyListInterface;
import MySorting.QuickSort;

import java.util.Iterator;

@SuppressWarnings("unchecked")// commonly needed when dealing with generics in Java
public class   MyLinkedList<T> implements MyListInterface<T> {
    private MyNode<T> head; //  first node in the list
    private MyNode<T> tail; //  last node in the list
    private int size; // The number of elements in the list


    /**
     * Initializes an empty list.
     * Time Complexity: O(1)
     */
    public MyLinkedList() {    // Constructor initializes the list as empty
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element to the end of the list.
     * Time Complexity: O(1)
     */
    @Override
    // Adds an element to the end of the list
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(null, item, null);
        if (head == null) head = newNode; // If the list is empty, the new node becomes the head
        else {
            newNode.prev = tail; // Link the new node with the current last node
            tail.next = newNode;
        }
        tail = newNode; // Update the reference to the last node
        size++;
    }


    /**
     * Replaces the element at the specified position.
     * Time Complexity: O(n), as it requires traversing to the position.
     */
    // Replaces the element at the specified position
    @Override
    public void set(int index, T item) {
        getNode(index).element = item;
    }

    // Inserts an element at the specified position, shifting other elements as necessary
    /**
     * Inserts an element at the specified position.
     * Time Complexity: O(n), involves traversal up to the index.
     */
    @Override
    public void add(int index, T item) {
        checkIndex(index); // Validates the index
        MyNode<T> prevNode = getNode(index).prev;
        MyNode<T> newNode = new MyNode<>(prevNode, item, getNode(index));

        if (prevNode != null) prevNode.next = newNode; // Inserting between nodes
        else head = newNode; // New node becomes the head

        if (newNode.next != null) newNode.next.prev = newNode;
        else tail = newNode; // New node becomes the tail
        size++;
    }

    // Adds an element at the start of the list
    /**
     * Adds an element to the beginning of the list.
     * Time Complexity: O(1)
     */
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * Adds an element to the end of the list (similar to add method).
     * Time Complexity: O(1)
     */
    // Adds an element at the end of the list
    @Override
    public void addLast(T item) {
        add(item);
    }

    /**
     * Retrieves an element by its index.
     * Time Complexity: O(n), as it may traverse the whole list.
     */
    // returns the element by its index
    @Override
    public T get(int index) {
        return getNode(index).element;
    }

    /**
     * Returns the first element in the list, or null if empty.
     * Time Complexity: O(1)
     */
    // Returns the first element of the list

    @Override
    public T getFirst() {
        if (head == null) return null;
        return head.element;
    }

    /**
     * Returns the last element in the list, or null if empty.
     * Time Complexity: O(1)
     */
    // Returns the last element of the list
    @Override
    public T getLast() {
        if (tail == null) return null;
        return tail.element;
    }

    /**
     * Removes the element at the specified index.
     * Time Complexity: O(n), due to traversal to the index.
     */
    // Removes the element at the specified index
    @Override
    public void remove(int index) {
        MyNode<T> nodeToRemove = getNode(index);
        if (nodeToRemove.prev != null) nodeToRemove.prev.next = nodeToRemove.next;
        else head = nodeToRemove.next; // Update the head if removing the first element

        if (nodeToRemove.next != null) nodeToRemove.next.prev = nodeToRemove.prev;
        else tail = nodeToRemove.prev; // Update the tail if removing the last element
        size--;
    }


    /**
     * Removes the first element of the list.
     * Time Complexity: O(1)
     */
    // Removes the first element of the list
    @Override
    public void removeFirst() {
        if (head == tail) {
            clear();
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }


    /**
     * Removes the last element of the list.
     * Time Complexity: O(1)
     */
    // Removes the last element of the list
    @Override
    public void removeLast() {
        if (tail == head) {
            clear();
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    // Sorts the list using the quicksort algorithm
    /**
     * Sorts the list using the quicksort algorithm. It converts the linked list to an array, sorts it,
     * and then rebuilds the linked list from the sorted array.
     * Time Complexity: O(n log n) on average due to the quicksort algorithm.
     */
    @Override
    public void sort() {
        Object[] array = toArray();
        QuickSort.quickSort(array);
        arrayToLinkedList(array);  // Convert the array back to a linked list after sorting
    }



    /**
     * Returns the index of the first occurrence of the specified object in the list.
     * Time Complexity: O(n), as it requires linear traversal to find the object.
     */    // Returns the index of the first occurrence of the specified object in the list
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) if (get(i).equals(object)) return i;
        return -1;
    }

    // Returns the index of the last occurrence of the specified object in the list
    /**
     * Returns the index of the last occurrence of the specified object in the list.
     * Time Complexity: O(n), as it may require scanning the entire list in reverse.
     */
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) if (get(i).equals(object)) return i;
        return -1;
    }

    // Checks if the specified object exists in the list
    /**
     * Checks if the specified object exists in the list by linear search.
     * Time Complexity: O(n), as it requires scanning the entire list.
     */
    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) if (get(i).equals(object)) return true;
        return false;
    }

    // Converts the linked list into an array of objects
    /**
     * Converts the linked list into an array of objects.
     * Time Complexity: O(n), as it involves iterating through all elements to place them in an array.
     */

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) result[i] = get(i);
        return result;
    }

    // Clears the list, resetting head and tail references and size to zero
    /**
     * Clears the list, resetting head and tail references and size to zero.
     * Time Complexity: O(1), direct reset of a few variables.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Returns the number of elements in the list
    /**
     * Returns the number of elements in the list.
     * Time Complexity: O(1), as it just returns the size variable.
     */
    @Override
    public int size() {
        return size;
    }

    // Helper method to retrieve the node at a specific index
    /**
     * Retrieves the node at a specific index in the list.
     * Time Complexity: O(n), as it potentially requires traversing up to the index.
     */
    private MyNode<T> getNode(int index) {
        checkIndex(index);
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) currentNode = currentNode.next;
        return currentNode;
    }

    // Validates that the index is within the bounds of the list
    /**
     * Validates that the index is within the bounds of the list and throws an exception if not.
     * Time Complexity: O(1), checks two conditions.
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new MyIndexOutOfBoundsException(index);
    }

    // Converts an array back to the linked list after sorting
    /**
     * Converts an array back to the linked list after sorting.
     * Time Complexity: O(n), as it involves iterating over the array and adding elements to the list.
     */
    private void arrayToLinkedList(Object[] arr) {
        clear();
        for (Object item : arr) add((T) item);
    }

    // Provides an iterator over elements of type T
    /**
     * Provides an iterator over elements of type T.
     * Time Complexity: Iterator creation is O(1), iterating over elements will be O(n).
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    // Inner class to define the structure of a node in the linked list
    private static class MyNode<E> {
        private E element; // The element stored in this node
        private MyNode<E> prev; // Reference to the previous node in the list
        private MyNode<E> next; // Reference to the next node in the list

        MyNode(MyNode<E> prev, E element, MyNode<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    // Inner class to implement the Iterator interface
    private class MyIterator<E> implements Iterator<E> {
        private int currentIndex = 0;

        // Returns true if the next element exists in the list
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        // Returns the next element in the list and increments the index
        @Override
        public E next() {
            if (!hasNext()) throw new MyNoSuchElementException("No such element exception.");
            return (E) get(currentIndex++);
        }
    }
}
