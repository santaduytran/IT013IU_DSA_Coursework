import java.util.Random;

public class Array {
    private long[] arr;
    private int nElems;

    public Array(int maxElems) {
        arr = new long[maxElems];
        nElems = 0;
    }

    private void swap(int a, int b) {
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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

    public void bubbleSort() {
        for (int i = 1; i < nElems - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < nElems - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public void selectionSort() {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            swap(min_idx, i);
        }
    }

    public void insertionSort() {
        for (int i = 1; i < arr.length; i++) {
            long temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
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