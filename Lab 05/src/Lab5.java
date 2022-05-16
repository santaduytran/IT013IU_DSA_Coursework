import java.util.Arrays;

public class Lab5 {
	//1, 2, 3
	public static int puzzle(int base, int limit) { // Base and limit are non-negative numbers
		if (base > limit)
			return -1;
		else if (base == limit)
			return 1;
		else
			return base * puzzle(base + 1, limit);
	}

	//4
	private static StringBuilder sb = new StringBuilder();
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

	//6
	public static int findmin(int a[], int n) {
		if (n == 0)
			return a[0];
		else {
			int min = Math.min(a[n - 1], findmin(a, n - 1));
			return min;
		}
	}

	//7
	public static int findsum(int a[], int n) {
		if (n == 1)
			return a[0];
		else
			return a[n - 1] + findsum(a, n - 1);
	}

	//8
	public static int gcd(int p, int q) {
		if (q == 0)
			return p;
		else
			return gcd(q, p % q);
	}

	public static void main(String[] args) {
		System.out.println("puzzle(14, 10) = " + puzzle(14, 10));
		System.out.println("puzzle(4, 7) = " + puzzle(4, 7));
		System.out.println("puzzle(0, 0) = " + puzzle(0, 0));

		System.out.println(sumFraction(20) + " = " + sb.toString()); //4
		sb = new StringBuilder();
		System.out.println(sum(30) + " = " + sb.toString()); //5

		int a[] = { -49, 2, 23, 40, -5, 6, 17 };
		System.out.println("a[] =  " + Arrays.toString(a));
		System.out.println("findmin(a, a.length) = " + findmin(a, a.length)); //6
		System.out.println("findsum(a, a.length) = " + findsum(a, a.length)); //7

		System.out.println("gcd(89, 13) = " + gcd(89, 13)); //8
	}
}
