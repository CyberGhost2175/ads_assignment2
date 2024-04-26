package MyClasses.MyArrayList;

import MyExceptions.MyNoSuchElementException;
import MyExceptions.MyIndexOutOfBoundsException;
import MyInterfaces.MyListInterface;
import MySorting.QuickSort;

import java.util.Iterator;

/**
 * Custom implementation of an ArrayList. It manages an array internally to store elements of type T.
 * Suppresses unchecked warnings related to casting Object[] to T[].
 */
@SuppressWarnings("unchecked")
public class MyArrayList<T> implements MyListInterface<T> {
    private T[] arr; // Internal array to store elements.
    private int size; // Current number of elements.
    private final int DEFAULT_SIZE = 5; // Default capacity of the array.

    /**
     * Constructor initializes the list with a default capacity.
     * Time Complexity: O(1), as it initializes the array with a fixed size.
     */
    public MyArrayList() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * Adds an item to the end of the list. Expands the list if necessary.
     * Time Complexity: Amortized O(1), might trigger a buffer increase causing O(n) in worst case.
     */
    @Override
    public void add(T item) {
        checkSize(); // Ensure capacity
        arr[size++] = item;
    }

    /**
     * Replaces the element at the specified index with the new item.
     * Time Complexity: O(1), as direct index access is used.
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item;
    }

    /**
     * Inserts an item at a specific index, shifting subsequent elements.
     * Time Complexity: O(n), due to the shifting of elements.
     */
    @Override
    public void add(int index, T item) {
        checkSize();
        checkIndex(index);
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
    }

    /**
     * Adds an item at the start of the list.
     * Time Complexity: O(n), as it may shift all elements.
     */
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    /**
     * Adds an item to the end of the list. Uses the add method for simplicity.
     * Time Complexity: Amortized O(1), might trigger a buffer increase causing O(n) in worst case.
     */
    @Override
    public void addLast(T item) {
        add(item);
    }

    /**
     * Returns the element at a specific index.
     * Time Complexity: O(1), direct index access.
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    /**
     * Returns the first element of the list.
     * Time Complexity: O(1), direct index access.
     */
    @Override
    public T getFirst() {
        return get(0);
    }

    /**
     * Returns the last element of the list.
     * Time Complexity: O(1), direct index access.
     */
    @Override
    public T getLast() {
        return get(size - 1);
    }

    /**
     * Removes the element at the specified index, shifting subsequent elements to the left.
     * Time Complexity: O(n), due to the shifting of elements.
     */
    @Override
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
    }

    /**
     * Removes the first element of the list.
     * Time Complexity: O(n), as it shifts all elements to the left.
     */
    @Override
    public void removeFirst() {
        remove(0);
    }

    /**
     * Removes the last element of the list.
     * Time Complexity: O(1), direct access and no shifting required.
     */
    @Override
    public void removeLast() {
        remove(size - 1);
    }

    /**
     * Sorts the list using the QuickSort algorithm.
     * Time Complexity: O(n log n) on average for QuickSort.
     */
    @Override
    public void sort() {
        QuickSort.quickSort(arr);
    }

    /**
     * Finds the index of the first occurrence of the specified object.
     * Time Complexity: O(n), linear search through the array.
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) return i;
        }
        return -1;
    }

    /**
     * Finds the index of the last occurrence of the specified object.
     * Time Complexity: O(n), linear search through the array from the end.
     */
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(object)) return i;
        }
        return -1;
    }

    /**
     * Checks if the specified object exists in the list.
     * Time Complexity: O(n), linear search through the array.
     */
    @Override
    public boolean exists(Object object) {
        for (T item : arr) {
            if (item.equals(object)) return true;
        }
        return false;
    }

    /**
     * Returns an array containing all elements in the list.
     * Time Complexity: O(1), returns a reference to the internal array.
     */
    @Override
    public Object[] toArray() {
        return arr.clone(); // Returns a copy of the array
    }

    /**
     * Clears the list, resetting it to its default capacity.
     * Time Complexity: O(1), as it reinitializes the array.
     */
    @Override
    public void clear() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * Returns the number of elements in the list.
     * Time Complexity: O(1), direct access to the size field.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Ensures there is enough capacity in the array, expanding it if necessary.
     * Time Complexity: O(n), due to array resizing and copying elements.
     */
    private void checkSize() {
        if (size == arr.length) increaseBuffer();
    }

    /**
     * Checks if the index is within the valid range for access or modification.
     * Time Complexity: O(1), direct comparison operations.
     */
    protected void checkIndex(int index) {
        if (index < 0 || index >= size) throw new MyIndexOutOfBoundsException(index);
    }

    /**
     * Swaps elements at the specified indices.
     * Time Complexity: O(1), direct index access and swap.
     */
    protected void swapElements(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Expands the internal array when more space is needed.
     * Time Complexity: O(n), due to array resizing and copying elements.
     */
    public void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length + 1];  // Typically, the array should expand by a larger factor than 1 for efficiency.
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    /**
     * Returns an iterator over elements of type T.
     * Time Complexity: O(1), returns an instance of the iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    /**
     * Inner class to implement iterator functionality. Provides methods to check the presence of and retrieve the next element.
     */
    private class MyIterator<E> implements Iterator<E> {
        private int currentIndex = 0;

        /**
         * Checks if there is a next element in the list.
         * Time Complexity: O(n), worst case, as it may skip null elements.
         */
        @Override
        public boolean hasNext() {
            while (currentIndex < size && arr[currentIndex] == null) currentIndex++;
            return currentIndex < size;
        }

        /**
         * Returns the next element in the list and increments the index.
         * Time Complexity: O(1), returns the next element directly.
         */
        @Override
        public E next() {
            if (!hasNext()) throw new MyNoSuchElementException("No such element exception.");
            return (E) arr[currentIndex++];
        }
    }
}
