package MyClasses;

import MyInterfaces.MyStackInterface;

import java.util.concurrent.CopyOnWriteArrayList;

public class MyStack<T> implements MyStackInterface<T> {
    private MyLinkedList<T> linkedList;
    int top;

    public MyStack(){
        linkedList = new MyLinkedList<T>();
        top = 0;
    }

    @Override
    public void push(T item) {
        linkedList.addLast(item);
        top++;
    }

    @Override
    public void pop() {
        linkedList.removeLast();
        top--;
    }

    @Override
    public T get(){
        return linkedList.get(top - 1);
    }

    @Override
    public void clear() {
        linkedList = new MyLinkedList<T>();
        top = 0;
    }
}
