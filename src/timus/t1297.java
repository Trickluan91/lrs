package timus;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1297">1297. Палиндромы</a>
 */
public class t1297 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try { run(); } finally { in.close(); out.flush(); }
    }

    static void run() {
        String s = new Scanner(System.in).nextLine();
        int n = s.length();
        int bestStart = 0, bestLen = 1;

        for (int i = 0; i < n; i++) {
            for (int[] lr : new int[][]{{i, i}, {i, i+1}}) {
                int l = lr[0], r = lr[1];
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > bestLen) {
                        bestLen = r - l + 1;
                        bestStart = l;
                    }
                    l--; r++;
                }
            }
        }

        out.println(s.substring(bestStart, bestStart + bestLen));
    }
}
