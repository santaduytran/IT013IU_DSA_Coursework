package lab3_2;

import java.util.Random;
public class Array {
    public static int[] randomInit(int numElements) {
        Random aRandom = new Random();
        int arr[] = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            arr[i] = Math.abs(aRandom.nextInt() % 100); // Assign a random integer value to current element of the array.
        }
        return arr;
    }
}
