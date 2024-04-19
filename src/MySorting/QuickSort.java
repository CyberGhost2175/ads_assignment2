package MySorting;

public class QuickSort {

    public static void quickSort(Object[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(Object[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Object[] arr, int low, int high) {
        Object pivot = arr[high];
        int i = (low - 1);  // Index of smaller element

        for(int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (((Comparable) arr[j]).compareTo(pivot) <= 0) {
                i++;

                // swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // swap arr[i+1] and arr[high] or pivot
        swap(arr, i + 1, high);

        return i + 1;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
