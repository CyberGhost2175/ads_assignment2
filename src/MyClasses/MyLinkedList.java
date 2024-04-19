package MyClasses;

import MyExceptions.MyNoSuchElementException;
import MyExceptions.MyIndexOutOfBoundsException;
import MyInterfaces.MyListInterface;
import MySorting.QuickSort;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class MyLinkedList<T> implements MyListInterface<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(null, item, null);
        if(head == null) head = newNode;
        else{
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void set(int index, T item) {
        getNode(index).element = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        MyNode<T> newNode = new MyNode<>(getNode(index).prev, item, getNode(index));

        if(newNode.prev != null) newNode.prev.next = newNode;
        else head = newNode;

        if(newNode.next != null) newNode.next.prev = newNode;
        else tail = newNode;
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
        return getNode(index).element;
    }

    @Override
    public T getFirst() {
        if(head == null) return null;
        return head.element;
    }

    @Override
    public T getLast() {
        if(tail == null) return null;
        return tail.element;
    }

    @Override
    public void remove(int index) {
        MyNode<T> nodeToRemove = getNode(index);
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;
        size--;
    }

    @Override
    public void removeFirst() {
        if(head == tail) {
            clear();
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    @Override
    public void removeLast() {
        if(tail == head) {
            clear();
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    @Override
    public void sort() {
        Object[] array = toArray();
        QuickSort.quickSort(array);
        arrayToLinkedList(array);
    }

    @Override
    public int indexOf(Object object) {
        for(int i = 0; i < size; i++) if(get(i).equals(object)) return i;
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for(int i = size - 1; i >= 0; i--) if(get(i).equals(object)) return i;
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        for(int i = 0; i < size; i++) if(get(i).equals(object)) return true;
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for(int i = 0; i < size; i++) result[i] = get(i);
        return result;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode<T> getNode(int index){
        checkIndex(index);
        MyNode<T> resultNode = head;
        for(int i = 0; i < index; i++) resultNode = resultNode.next;
        return resultNode;
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size) throw new MyIndexOutOfBoundsException(index);
    }

    private void arrayToLinkedList(Object[] arr){
        clear();
        for(Object a : arr) add((T) a);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>();
    }

    private static class MyNode<E>{
        private E element;
        private MyNode<E> prev;
        private MyNode<E> next;

        MyNode(MyNode<E> prev, E element, MyNode<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
    private class MyIterator<E> implements Iterator<E>{
        private int currentIndex = 0;

        @Override
        public boolean hasNext(){
            return currentIndex < size;
        }

        @Override
        public E next(){
            if(!hasNext()) throw new MyNoSuchElementException("No such element exception.");
            return (E) get(currentIndex++);
        }
    }
}
