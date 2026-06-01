package timus;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1290">1290. Саботаж</a>
 */
public class t1290 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try { run(); } finally { in.close(); out.flush(); }
    }

    static void run() {
        int n = in.nextInt();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = in.nextInt();
        }

        Arrays.sort(digits);

        for (int i = digits.length - 1; i >= 0; i--) {
            out.println(digits[i]);
        }
    }
}
