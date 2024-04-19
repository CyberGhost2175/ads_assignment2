package MyClasses;

import MyExceptions.MyNoSuchElementException;
import MyExceptions.MyIndexOutOfBoundsException;
import MyInterfaces.MyListInterface;
import MySorting.QuickSort;

import java.util.Iterator;


@SuppressWarnings("unchecked")
public class MyArrayList<T> implements MyListInterface<T> {
    private T[] arr;
    private int size;
    private final int DEFAULT_SIZE = 5;

    public MyArrayList(){
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void add(T item) {
        checkSize();
        arr[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkSize();
        checkIndex(index);
        arr[index] = item;
    }

    @Override
    public void add(int index, T item) {
        checkSize();
        checkIndex(index);
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return arr[index];
    }

    @Override
    public T getFirst() {
        checkIndex(0);
        return get(0);
    }

    @Override
    public T getLast() {
        checkIndex(size - 1);
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for(int i = index + 1; i < size; i++) arr[i - 1] = arr[i];
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        QuickSort.quickSort(arr);
    }

    @Override
    public int indexOf(Object object) {
        for(int i = 0; i < size; i++) if(arr[i].equals(object)) return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for(int i = size - 1; i >= 0; i--) if(arr[i].equals(object)) return i;
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        for(T item : arr) if(item.equals(object)) return true;
        return false;
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public void clear() {
        arr = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void checkSize(){
        if(size == arr.length) increaseBuffer();
    }

    protected void checkIndex(int index) {
        if(index < 0 || index >= size) throw new MyIndexOutOfBoundsException(index);
    }

    protected void swapElements(int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void increaseBuffer() {
        T[] newArr = (T[]) new Object[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    private class MyIterator<E> implements Iterator<E>{
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            while(currentIndex < size && arr[currentIndex] == null) currentIndex++;
            return currentIndex < size;
        }

        @Override
        public E next() {
            if(!hasNext()) throw new MyNoSuchElementException("No such element exception.");
            return (E) arr[currentIndex++];
        }
    }
}
