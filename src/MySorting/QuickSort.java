package MySorting;

// Provides a static method implementation of the QuickSort algorithm for sorting arrays.
public class QuickSort {

    // Public method that sorts an array of objects that implement the Comparable interface.
    // It initiates the recursive quick sort process by setting the initial low and high indices.
    public static void quickSort(Object[] arr) {
        quickSort(arr, 0, arr.length - 1); // Calls the recursive quick sort method
    }

    // Recursive method that implements the QuickSort algorithm.
    // Parameters 'low' and 'high' are the indices between which the array is to be sorted.
    private static void quickSort(Object[] arr, int low, int high) {
        if (low < high) { // Base case: if the range is non-trivial
            int pi = partition(arr, low, high); // Partition the array and get the pivot index

            quickSort(arr, low, pi - 1); // Recursively sort the subarray before the pivot
            quickSort(arr, pi + 1, high); // Recursively sort the subarray after the pivot
        }
    }

    // Partitions the array around a pivot such that elements less than pivot are on the left
    // and elements greater than pivot are on the right.
    // Returns the index of the pivot element after partition.
    private static int partition(Object[] arr, int low, int high) {
        Object pivot = arr[high]; // Chooses the last element as the pivot
        int i = (low - 1);  // Initialize index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot, increment the low element index
            if (((Comparable) arr[j]).compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j); // Swap current element with the element at index i
            }
        }

        // Swap the pivot element with the element at index i+1
        swap(arr, i + 1, high);

        return i + 1; // Return the index position of the pivot
    }

    // Utility method to swap two elements in the array.
    // Parameters 'i' and 'j' are the indices of the elements to be swapped.
    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i]; // Temporary storage for the element at index i
        arr[i] = arr[j];      // Place element at j into index i
        arr[j] = temp;        // Move element from temp (original i) to index j
    }
}
