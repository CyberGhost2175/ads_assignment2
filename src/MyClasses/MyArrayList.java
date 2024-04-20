package MyClasses;

import MyExceptions.MyNoSuchElementException;
import MyExceptions.MyIndexOutOfBoundsException;
import MyInterfaces.MyListInterface;
import MySorting.QuickSort;

import java.util.Iterator;


@SuppressWarnings("unchecked")// Suppresses unchecked warnings related to casting Object[] to T[]
public class MyArrayList<T> implements MyListInterface<T> {
    private T[] arr;// Internal list to store list elements
    private int size; // size of list
    private final int DEFAULT_SIZE = 5; // initial capacity

    public MyArrayList(){ // Constructor initializes the list with the default capacity and sets size  0
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    //add items to end of list
    public void add(T item) {
        checkSize();
        arr[size++] = item;
    }

    @Override
    // Sets the element at specified index, replacing its current value
    public void set(int index, T item) {
        checkSize();
        checkIndex(index);
        arr[index] = item;
    }

    @Override
    // Inserts an item at the specified index, shifting elements as necessary
    public void add(int index, T item) {
        checkSize();
        checkIndex(index);
        System.arraycopy(arr, index, arr, index + 1, size - index);// Shift elements right
        arr[index] = item;
        size++;
    }

    @Override
    // add item at the start of list
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    // add item at the end of list
    public void addLast(T item) {
        add(item);
    }

    @Override
    // return the element at the specified index
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    // return the first element of list
    public T getFirst() {
        checkIndex(0);
        return get(0);
    }

    @Override
    // return the last element of list
    public T getLast() {
        checkIndex(size - 1);
        return get(size - 1);
    }

    @Override
    // remove element of an list by index , shifting elements  left
    public void remove(int index) {
        checkIndex(index);
        for(int i = index + 1; i < size; i++) arr[i - 1] = arr[i];
        size--;
    }

    @Override
    // Removes the first element of the list
    public void removeFirst() {
        remove(0);
    }

    @Override
    // Removes the last element of the list
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    // Sorts the list using QuickSort
    public void sort() {
        QuickSort.quickSort(arr);
    }

    @Override
    // Finds the index of the first occurrence of the specified object in the arr
    public int indexOf(Object object) {
        for(int i = 0; i < size; i++) if(arr[i].equals(object)) return i;
        return -1;
    }

    @Override
    // Finds the index of the last occurrence of the specified object in the arr
    public int lastIndexOf(Object object) {
        for(int i = size - 1; i >= 0; i--) if(arr[i].equals(object)) return i;
        return -1;
    }

    @Override
    // Checks if the  object exists in the list
    public boolean exists(Object object) {
        for(T item : arr) if(item.equals(object)) return true;
        return false;
    }

    @Override
    // Returns the array containing all elements in the list
    public Object[] toArray() {
        return arr;
    }

    @Override
    // Clears the list, resetting the array to the default size
    public void clear() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    //return the number of elements
    public int size() {
        return size;
    }


    private void checkSize(){ // Ensures there is enough capacity in the array, expanding it if necessary

        if(size == arr.length) increaseBuffer();
    }

    // Checks if the index is within bounds for access or modification
    protected void checkIndex(int index) {
        if(index < 0 || index >= size) throw new MyIndexOutOfBoundsException(index);
    }

    // Swaps elements at the specified indices
    protected void swapElements(int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // Expands the internal array when more space is needed
    public void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    } // Returns an iterator over elements of type T

    private class MyIterator<E> implements Iterator<E>{ // Inner class to implement iterator functionality
        private int currentIndex = 0;
        @Override
        // Checks if there is a next element in the list that is not null
        public boolean hasNext() {
            while(currentIndex < size && arr[currentIndex] == null) currentIndex++;
            return currentIndex < size;
        }

        @Override
        // Returns the next element in the list and increments the index
        public E next() {
            if(!hasNext()) throw new MyNoSuchElementException("No such element exception.");
            return (E) arr[currentIndex++];
        }
    }
}
