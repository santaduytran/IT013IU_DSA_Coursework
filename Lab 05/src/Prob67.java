import java.util.Arrays;

public class Prob67 {
    private static int[] array;
    private static StringBuilder sb = new StringBuilder();

    static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    static void displayArray(int[] arr) {
        Arrays.stream(arr).forEach(x -> sb.append(", ").append(x));
        System.out.println("The current array is: " + sb.toString().substring(2));
    }

    //6
    static int findMin(int array[], int n) { // n is the number of elements in array
        if (n == 1) {
            return array[0];
        } else {
            return min(array[n - 1], findMin(array, n - 1));
        }
    }

    //7
    static int findSum(int array[], int n) { // n is the number of elements in array
        if (n == 1) {
            return array[0];
        } else {
            return (array[n - 1] + findSum(array, n - 1));
        }
    }

    public static void main(String[] args) {
        array = new int[] {-17, 40, 5, 26, 13, -22, 15};
        displayArray(array);
        System.out.println("6. Array's smallest elements: " + findMin(array, array.length)); //6
        System.out.println("7. Array's sum of all elements: " + findSum(array, array.length)); //7
    }
}