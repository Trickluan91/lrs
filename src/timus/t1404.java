package timus;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1404">1404. Легко взломать!</a>
 */
public class t1404 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        try { run(); } finally { in.close(); out.flush(); }
    }

    static void run() {
        char[] str = in.nextLine().toCharArray();
        int[] s2 = new int[str.length];
        int[] s1 = new int[str.length];


        for (int i = 0; i < str.length; i++) {
            s2[i] = str[i] - 'a';
            if (i == 0) {
                while (s2[0] - 5 < 0) s2[0] += 26;
                s1[0] = s2[0] - 5;
            } else {
                while (s2[i] - s2[i-1] < 0 || s2[i] - s2[i-1] > 25) s2[i] += 26;
                s1[i] = s2[i] - s2[i-1];
            }
        }

        for (int i = 0; i < str.length; i++) {
            out.print((char) ('a' + s1[i]));
        }
    }
}
