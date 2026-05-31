package lab13.timus;

import java.io.PrintWriter;
import java.util.*;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1203">1203. Научная конференция</a>
 */
public class t1203 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try { run(); } finally { in.close(); out.flush(); }
    }

    static void run() {
        int n = in.nextInt();
        int[][] lectures = new int[n][2];
        for (int i = 0; i < n; i++) {
            lectures[i][0] = in.nextInt();
            lectures[i][1] = in.nextInt();
        }
        Arrays.sort(lectures, Comparator.comparingInt(a -> a[1]));

        int visited = 0;
        int lastEnd = -1;
        for (int[] l : lectures) {
            if (l[0] > lastEnd) {
                visited++;
                lastEnd = l[1];
            }
        }
        out.print(visited);
    }

}
