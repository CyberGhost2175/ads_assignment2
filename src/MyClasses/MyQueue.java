package MyClasses;

import MyInterfaces.MyQueueInterface;

import java.util.concurrent.CopyOnWriteArrayList;

@SuppressWarnings("unchecked")
public class MyQueue<T> implements MyQueueInterface<T> {
    private MyLinkedList<T> linkedList; //  storage for the queue, using a linked list

    // Constructor initializes the queue by creating a new instance of MyLinkedList
    public MyQueue(){
        linkedList = new MyLinkedList<T>();
    }

    // Adds an item to the end of the queue
    @Override
    public void enqueue(T item) {
        linkedList.add(item); //  add items to the end
    }

    // Removes the item at the front of the queue
    @Override
    public void dequeue() {
        linkedList.removeFirst(); // remove the front item
    }

    // Returns the item at the front of the queue without removing it
    @Override
    public T peek() {
        return (T) linkedList.getFirst(); // Casts the result of getFirst to type T
    }

    // Checks if the queue is empty
    @Override
    public boolean isEmpty() {
        return linkedList.size() == 0; // Returns true if the linked list size is 0
    }

    // Returns the number of items in the queue
    @Override
    public int size() {
        return linkedList.size(); // Returns the size of the linked list
    }
}
