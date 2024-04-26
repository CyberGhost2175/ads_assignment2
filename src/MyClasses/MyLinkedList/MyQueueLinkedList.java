package MyClasses.MyLinkedList;

import MyInterfaces.MyQueueInterface;

@SuppressWarnings("unchecked")
public class MyQueueLinkedList<T> implements MyQueueInterface<T> {
    private MyLinkedList<T> linkedList; //  storage for the queue, using a linked list

    // Constructor initializes the queue by creating a new instance of MyLinkedList
    /**
     * Initializes the queue by creating a new instance of MyLinkedList.
     * Time Complexity: O(1), as it simply initializes a new MyLinkedList instance.
     */
    public MyQueueLinkedList(){
        linkedList = new MyLinkedList<T>();
    }

    // Adds an item to the end of the queue
    /**
     * Adds an item to the end of the queue.
     * Time Complexity: O(1), as it simply delegates to the add method of MyLinkedList.
     */
    @Override
    public void enqueue(T item) {
        linkedList.add(item); //  add items to the end
    }

    // Removes the item at the front of the queue
    /**
     * Removes the item at the front of the queue.
     * Time Complexity: O(1), as it simply delegates to the removeFirst method of MyLinkedList.
     */
    @Override
    public void dequeue() {
        linkedList.removeFirst(); // remove the front item
    }

    // Returns the item at the front of the queue without removing it
    /**
     * Returns the item at the front of the queue without removing it.
     * Time Complexity: O(1), as it simply delegates to the getFirst method of MyLinkedList.
     */
    @Override
    public T peek() {
        return (T) linkedList.getFirst(); // Casts the result of getFirst to type T
    }

    // Checks if the queue is empty
    /**
     * Checks if the queue is empty.
     * Time Complexity: O(1), as it simply checks the size of the linked list.
     */
    @Override
    public boolean isEmpty() {
        return linkedList.size() == 0; // Returns true if the linked list size is 0
    }

    // Returns the number of items in the queue
    /**
     * Returns the number of items in the queue.
     * Time Complexity: O(1), as it simply returns the size of the linked list.
     */
    @Override
    public int size() {
        return linkedList.size(); // Returns the size of the linked list
    }
}
