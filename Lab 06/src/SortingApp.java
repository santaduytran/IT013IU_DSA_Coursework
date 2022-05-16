public class SortingApp {
    public static long[] test(Array arr) {
        Array arr1 = arr.clone();
        Array arr2 = arr.clone();
        Array arr3 = arr.clone();
        Array arr4 = arr.clone();

        long startTime, endTime;
        long[] duration = new long[4];

        /* ------------ Merge Sort ------------ */
        startTime = TimeUtils.now();
        arr1.mergeSort();
        endTime = TimeUtils.now();
        duration[0] = endTime - startTime;

        /* ------------ Shell Sort ------------ */
        startTime = TimeUtils.now();
        arr2.shellSort();
        endTime = TimeUtils.now();
        duration[1] = endTime - startTime;

        /* ------------ Quick Sort ------------ */
        startTime = TimeUtils.now();
        arr3.quickSort();
        endTime = TimeUtils.now();
        duration[2] = endTime - startTime;

        /* ------- Quick Sort Median of 3 ------- */
        startTime = TimeUtils.now();
        arr4.quickSortOf3();
        endTime = TimeUtils.now();
        duration[3] = endTime - startTime;

        return duration;
    }

    public static void table1() {
        /** ------------------- Table 1 - Experiment 1 ---------------------- */
        int[] maxSize = {10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};
        Array arr;

        System.out.println("Table 1 - Experiment 1: Simple sorting on random data");
        String s = String.format("| %8s | %10s | %10s | %10s | %17s |",
                "Max Size", "Merge Sort", "Shell Sort", "Quick Sort", "Quick Sort MedOf3");
        System.out.println(new String(new char[s.length()]).replace('\0', '-'));
        System.out.println(s);

        for (int idx = 0; idx < maxSize.length; idx++) {
            arr = new Array(maxSize[idx]);
            arr.randomInit(maxSize[idx]);
            long[] duration = test(arr);

            s = String.format("| %8s | %7s ms | %7s ms | %7s ms | %14s ms |",
                    maxSize[idx], duration[0], duration[1], duration[2], duration[3]);
            System.out.println(new String(new char[s.length()]).replace('\0', '-'));
            System.out.println(s);
        }
        System.out.println(new String(new char[s.length()]).replace('\0', '-'));


        /** ------------------- Table 2 - Experiment 2 ---------------------- */
        long[] duration;

        System.out.println("\nTable 2 - Experiment 2: Simple sorting in special cases");
        s = String.format("| %14s | %10s | %10s | %10s | %17s |",
                "Speial Cases", "Merge Sort", "Shell Sort", "Quick Sort", "Quick Sort MedOf3");

        System.out.println(new String(new char[s.length()]).replace('\0', '-'));
        System.out.println(s);

        /* -------------------------- Inverse order ------------------------*/
        Array arrSorted = new Array(maxSize[8]);
        arrSorted.randomInit(maxSize[8]);
        arrSorted.mergeSort();
        duration = test(arrSorted);
        s = String.format("| %14s | %7s ms | %7s ms | %7s ms | %14s ms |",
                "Inverse order", duration[0], duration[1], duration[2], duration[3]);
        System.out.println(new String(new char[s.length()]).replace('\0', '-'));
        System.out.println(s);

        /* -------------------------- Already sorted ------------------------*/
        Array arrInverse = new Array(maxSize[8]);
        arrInverse.randomInit(maxSize[8]);
        arrInverse.mergeSort();
        arrInverse.inverse();
        duration = test(arrInverse);
        s = String.format("| %14s | %7s ms | %7s ms | %7s ms | %14s ms |",
                "Already sorted", duration[0], duration[1], duration[2], duration[3]);
        System.out.println(new String(new char[s.length()]).replace('\0', '-'));
        System.out.println(s);
        System.out.println(new String(new char[s.length()]).replace('\0', '-'));
    }

    public static void main(String[] args) {
        table1();
    }
}