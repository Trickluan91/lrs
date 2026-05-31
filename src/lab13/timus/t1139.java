package lab13.timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1139">1139. Городские кварталы</a>
 */
public class t1139 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try {
            run();
        } finally {
            in.close();
            out.flush();
        }
    }

    static void run() {
        int n = in.nextInt(), m = in.nextInt();
        int a = n - 1, b = m - 1;
        out.print(a + b - gcd(a, b));
    }

    public static int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }
}
