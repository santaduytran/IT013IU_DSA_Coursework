public class Prob8 {
    //8
    static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

    public static void main(String[] args) {
        System.out.println("The GCD of (7, 11) is: " + gcd(7, 11)); //8
    }
}