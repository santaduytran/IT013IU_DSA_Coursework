public class Prob123 {
    //1, 2, 3
    static int puzzle(int base, int limit) {  // Base and limit are non-negative numbers
        if (base > limit) {
            return -1;
        } else if (base == limit) {
            return 1;
        } else {
            return base * puzzle(base + 1, limit);
        }
    }

    public static void main(String[] args) {
        System.out.println("The result is (limit-1)! / (base-1)!");
        System.out.println("puzzle(14, 10) = " + puzzle(14, 10));
        System.out.println("puzzle(4, 7) = " + puzzle(4, 7));
        System.out.println("puzzle(0, 0) = " + puzzle(0, 0));
    }
}