package timus;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1935">1935. Слёзы утопленников</a>
 */
public class t1935 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try { run(); } finally { in.close(); out.flush(); }
    }

    static void run() {
        int skin = in.nextInt(), sum = 0, latest = 0;

        int[] lists = new int[skin];
        for (int i = 0; i < lists.length; i++) lists[i] = in.nextInt();
        Arrays.sort(lists);

        for (int list : lists) {
            sum += Math.max(latest, list);
            latest = list;
        }
        out.println(sum + latest);
    }
}
