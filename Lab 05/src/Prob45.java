public class Prob45 {
    private static StringBuilder sb = new StringBuilder();

    //4
    static double sumFraction(int n) {  // While n > 0
        if (n < 1) {
            sb.append(n);
            return n;
        } else if (n == 1) {
            sb.append(1);
            return 1;
        } else {
            sb.append("1/").append(n).append(" + ");
            return (double) (1.0 / n + sumFraction(n - 1));
        }
    }

    //5
    static int sum(int n) {  // While n > 1
        if (n < 1) {
            sb.append(n);
            return n;
        } else if (n == 1) {
            sb.append(1);
            return 1;
        } else {
            sb.append(n).append(" + ");
            return n + sum(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(sumFraction(20) + " = " + sb.toString()); //4
        sb = new StringBuilder();
        System.out.println(sum(30) + " = " + sb.toString()); //5
    }
}