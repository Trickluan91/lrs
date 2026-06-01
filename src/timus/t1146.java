package timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1146">1146. Maximum Sum</a>
 */
public class t1146 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try { run(); } finally { in.close(); out.flush(); }
    }

    static void run() {
        int n = in.nextInt();
        int[][] rectangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                rectangle[i][i1] = in.nextInt();
            }
        }

        int best = Integer.MIN_VALUE;

        for (int r1 = 0; r1 < n; r1++) {
            int[] col = new int[n];
            for (int r2 = r1; r2 < n; r2++) {
                for (int j = 0; j < n; j++) {
                    col[j] += rectangle[r2][j];
                }

                int cur = 0;
                for (int j = 0; j < n; j++) {
                    cur += col[j];
                    if (cur > best) best = cur;
                    if (cur < 0) cur = 0;
                }
            }
        }

        System.out.println(best);
    }
}
