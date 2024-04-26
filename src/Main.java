import MyClasses.MyArrayList.MyArrayList;

public class Main {
    static void printArr(MyArrayList arr, String m){
        System.out.println(m);
        for(Object i : arr) System.out.print(i + " ");
        System.out.println();
    }

    static void printLinked(Object[] arr, String m){
        System.out.println(m);
        for(Object i : arr) System.out.print(i + " ");
        System.out.println();
    }
    public static void main(String[] args) {

        // ----------------- MyArrayList using ------------------ \\



//        MyArrayList arr = new MyArrayList();
//
//        arr.add("element1");
//        arr.add("element2");
//        arr.add("element3");
//        arr.add("element4");
//        arr.add("element5");
//        arr.add("element6");
//        arr.add("element7");
//
//        arr.sort();
//        printArr(arr, "");
//
//        arr.add(12);
//        arr.add("temp");
//        arr.add(true);
//        arr.add('N');
//        arr.add('G');
//
//
//        printArr(arr, "first array list: ");
//        System.out.println("array size: " + arr.size());
//
//        arr.remove(1);
//
//        printArr(arr, "after removing element 1: ");
//        System.out.println("array size: " + arr.size());
//
//
//        arr.addFirst("first");
//        arr.addLast("last");
//
//        printArr(arr, "After addFirst and addLast: ");
//        System.out.println("array size: " + arr.size());
//
//        arr.set(arr.size() - 1, "new - last");
//        arr.removeFirst();
//
//        printArr(arr, "After set(last) and removeFirst: ");
//        System.out.println("Array size: " + arr.size());
//
//        arr.removeLast();
//        printArr(arr, "After removeLast: ");
//        System.out.println("Array size: " + arr.size());
//
//        System.out.println("true in arr: " + arr.exists(true));
//        System.out.println("Index of c: " + arr.indexOf('c'));
//        System.out.println("Last index of c: " + arr.lastIndexOf('c'));
//        System.out.println("getFirst(): " + arr.getFirst());
//        System.out.println("getLast(): " + arr.getLast());
//        arr.clear();
//        printArr(arr, "After clear(): ");




        // ----------------- MyLinkedList using ------------------ \\

//        MyLinkedList linkList = new MyLinkedList();
//        linkList.add("1");
//        linkList.add("fff");
//        linkList.add("333");
//        linkList.add("444");
//        linkList.add("212");
//        linkList.add("323");
//
//        linkList.sort();
//        printLinked(linkList.toArray(), "");
//
//        linkList.add("aaa");
//        linkList.add('d');
//        linkList.add("563AMI01");
//
//        printLinked(linkList.toArray(), "First linked list: ");
//
//        linkList.add(1, "index1");
//        linkList.addFirst("first");
//        linkList.addLast("last");
//        linkList.set(3, "3");
//
//        printLinked(linkList.toArray(), "After add, addFirst, addLast, set(3): ");
//
//        System.out.println(linkList.getFirst());
//        System.out.println(linkList.getLast());
//        System.out.println(linkList.indexOf("vv"));
//        System.out.println(linkList.lastIndexOf('d'));
//
//        linkList.remove(1);
//        linkList.removeFirst();
//        linkList.removeLast();
//
//        System.out.println(linkList.size());
//        printLinked(linkList.toArray(), "After remove(1), removeFirst, removeLast: ");






        // ----------------- MyStack using ------------------ \\

//        MyStack stack = new MyStack();
//
//        stack.push(123);
//        stack.push("temp");
//        stack.push(423);
//        stack.push('W');
//
//        System.out.println(stack.get());






        // ----------------- MyHeap using ------------------ \\

//        MyMinHeap minHeap = new MyMinHeap();
//        minHeap.insert(1);
//        minHeap.insert(2);
//        minHeap.insert(3);
//        minHeap.insert(4);
//        minHeap.insert(5);
//        minHeap.insert(10);
//        minHeap.insert(47);
//        minHeap.insert(42);
//
//        for(int i = 0; i < 7; i++){
//            System.out.println((i + 1) + ": " + minHeap.get(i));
//        }
//
//        minHeap.removeSmallest();
//
//        for(int i = 0; i < 7; i++){
//            System.out.println((i + 1) + ": " + minHeap.get(i));
//        }




        // ----------------- MyQueue using ------------------ \\
//        MyQueue queue = new MyQueue();
//        queue.enqueue(3);
//        queue.enqueue(24);
//        queue.enqueue(31);
//        queue.enqueue(1);
//
//        System.out.println(queue.peek());
//        queue.dequeue();
//        System.out.println(queue.peek());
//        queue.dequeue();
//        System.out.println(queue.peek());
//        queue.dequeue();
//        System.out.println(queue.peek());
//        queue.dequeue();
//        System.out.println(queue.peek());

    }
}