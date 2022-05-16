import java.util.Random;

public class Array {
    private long[] arr;
    private int nElems;

    public Array(int maxElems) {
        arr = new long[maxElems];
        nElems = 0;
    }

    public void randomInit(int numElements) {
        Random generator = new Random();

        nElems = numElements;
        for (int i = 0; i < nElems; i++) {
            arr[i] = generator.nextLong() % 100000000;
        }
    }

    public void inverse() {
        long[] inverseArr = new long[nElems];

        for (int i = 0; i < nElems; i++) {
            inverseArr[i] = arr[nElems - i - 1];
        }
        arr = inverseArr;
    }

    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = arr[outer];
                inner = outer;

                while (inner > h-1 && arr[inner-h] >=  temp) {
                    arr[inner] = arr[inner-h];
                    inner -= h;
                }
                arr[inner] = temp;
            }  // end for
            h = (h - 1) / 3; // decrease h
        }  // end while (h > 0)
    } // end shellSort()

    public void mergeSort() {
        long[] theArr = new long[nElems];
        recMergeSort(theArr, 0, nElems - 1);
    }

    private void recMergeSort(long[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            recMergeSort(arr, left, mid);
            recMergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(long[] arr, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        long[] arr_L = new long[n1];
        long[] arr_R = new long[n2];

        for (int idx = 0; idx < n1; idx++) {
            arr_L[idx] = arr[left + idx];
        }

        for (int idx = 0; idx < n2; idx++) {
            arr_R[idx] = arr[mid + 1 + idx];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (arr_L[i] <= arr_R[j]) {
                arr[k++] = arr_L[i++];
            } else {
                arr[k++] = arr_R[j++];
            }
        }

        while (i < n1) {
            arr[k++] = arr_L[i++];
        }

        while (j < n2) {
            arr[k++] = arr_R[j++];
        }
    }

    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    public void recQuickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            long pivot = arr[right];
            int partition = partitionIt(left, right, pivot);

            recQuickSort(left, partition - 1);   // sort left side
            recQuickSort(partition + 1, right);  // sort right side
        }
    }

    public void quickSortOf3() {
        recQuickSort(0, nElems - 1);
        // insertionSort(0, nElems-1); // the other option
    }

    public void recQuickSortOf3(int left, int right) {
        int size = right - left + 1;

        if(size < 10) { // insertion sort if small
            insertionSort(left, right);
        } else {        // quicksort if large
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);

            recQuickSortOf3(left, partition-1);
            recQuickSortOf3(partition+1, right);
        }
    }  // end recQuickSort()

    public long medianOf3(int left, int right) {
        int center = (left + right) / 2;

        if (arr[left] > arr[center]) {  // order left & center
            swap(left, center);
        }

        if (arr[left] > arr[right] ) {  // order left & right
            swap(left, right);
        }

        if (arr[center] > arr[right]) {  // order center & right
            swap(center, right);
        }

        swap(center, right-1);          // put pivot on right
        return arr[right - 1];          // return median value
    }  // end medianOf3()

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;

        while (true) {
            while(arr[++leftPtr] < pivot); // find bigger

            while(rightPtr > 0 && arr[--rightPtr] > pivot); // find smaller

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        } // end while(true)
        swap(leftPtr, right);
        return leftPtr;
    }

    public void insertionSort(int left, int right) {
        int in, out;

        for (out = left + 1; out <= right; out++) {
            long temp = arr[out];       // remove marked item
            in = out;                   // start shifts at out
            // until one is smaller,
            while (in > left && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];  // shift item to right
                --in;                   // go left one position
            }
            arr[in] = temp;
        }  // end for
    } // end insertionSort()

    /* Swap two elements */
    private void swap(int a, int b) {
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Prints the array
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public Array clone() {
        Array clone = new Array(nElems);

        clone.nElems = nElems;
        for (int i = 0; i < nElems; i++) {
            clone.arr[i] = arr[i];
        }

        return clone;
    }
}
