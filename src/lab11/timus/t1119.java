package lab11.timus;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1119">1119. Метро</a>
 */
public class t1119 {
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

    static void run(){
        int width = in.nextInt(),  height = in.nextInt(), fast = in.nextInt();

        boolean[][] diag = new boolean[width + 1][height + 1];

        for (int i = 0; i < fast; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            diag[x][y] = true;
        }

        double[][] dp = new double[width + 1][height + 1];
        for (double[] row : dp) Arrays.fill(row, Double.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 0; i <= width; i++) {
            for (int j = 0; j <= height; j++) {
                if (dp[i][j] == Double.MAX_VALUE) continue;

                if (i + 1 <= width)
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 100);

                if (j + 1 <= height)
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 100);

                if (i + 1 <= width && j + 1 <= height && diag[i][j])
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + 100 * Math.sqrt(2));
            }
        }

        out.println(Math.round(dp[width][height]));
    }
}
