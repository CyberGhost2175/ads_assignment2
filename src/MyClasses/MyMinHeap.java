package MyClasses;

import MyInterfaces.MyMinHeapInterface;
import MyClasses.MyLinkedList;

// MyMinHeap class defines a generic min heap where elements are ordered
// according to their natural ordering or by a Comparator
public class MyMinHeap<T extends Comparable<T>> implements MyMinHeapInterface<T> {
    private MyArrayList<T> arrayList; // Internal storage for heap elements

    // Constructor initializes the internal storage as an empty ArrayList
    public MyMinHeap(){
        arrayList = new MyArrayList<T>();
    }

    // Inserts a new item into the heap
    @Override
    public void insert(T item) {
        arrayList.add(item); // Add item at the end of the ArrayList
        checkHeap(arrayList.size() - 1); // Adjust heap to maintain heap property starting from the last item
    }

    // Removes the smallest item from the heap, which is at the root
    @Override
    public void removeSmallest() {
        if(arrayList.size() == 0) return; // If heap is empty, return
        T last = arrayList.getLast(); // Get the last element
        arrayList.set(0, last); // Replace the root of the heap with the last element
        arrayList.removeLast(); // Remove the last element
        checkHeapDown(0); // regroup the heap down from the root
    }

    // Returns the element at the specified index in the heap
    @Override
    public T get(int index) {
        return arrayList.get(index);
    }

    // Returns the smallest item in the heap, which is the root element
    @Override
    public T getSmallest() {
        return arrayList.get(0);
    }

    // Clears all elements from the heap
    @Override
    public void clear() {
        arrayList.clear();
    }

    // Internal method to maintain the heap property upwards after insertion
    private void checkHeap(int index){
        if(index == 0) return; // If the index is at the root, return
        for(int i = index; i > 0; i = parentIndex(i)){
            if(checkParent(i)) swapElements(i, parentIndex(i)); // Check and swap with parent if needed
            checkHeap(parentIndex(index)); // Recursive check up to the root
        }
    }

    // Internal method to maintain the heap property downwards after removal
    private void checkHeapDown(int index){
        int left = leftChild(index); // Index of left child
        int right = rightChild(index); // Index of right child
        int swapIndex = index; // Start with current index as potential swap candidate
        if(left < arrayList.size() && arrayList.get(swapIndex).compareTo(arrayList.get(left)) > 0) swapIndex = left;
        if(right < arrayList.size() && arrayList.get(swapIndex).compareTo(arrayList.get(right)) > 0) swapIndex = right;
        if(swapIndex != index){
            swapElements(swapIndex, index); // Swap if necessary
            checkHeapDown(swapIndex); // Continue checking downwards recursively
        }
    }

    // Swaps two elements in the heap's ArrayList
    void swapElements(int i, int j){
        arrayList.swapElements(i, j);
    }

    // Checks if a child element should be swapped with its parent for heap order
    boolean checkParent(int index){
        return arrayList.get(parentIndex(index)).compareTo(arrayList.get(index)) > 0;
    }

    // Returns the parent index for a given child index
    int parentIndex(int index){
        arrayList.checkIndex(index);
        if(index >= 0 && index <= 2) return 0;
        return (index % 2 == 0 ? (index - 2) / 2 : (index - 1) / 2);
    }

    // Calculates the index of the left child for a given parent index
    int leftChild(int index){
        return index * 2 + 1;
    }

    // Calculates the index of the right child for a given parent index
    int rightChild(int index){
        return index * 2 + 2;
    }
}
