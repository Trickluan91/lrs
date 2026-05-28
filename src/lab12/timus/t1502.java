package lab12.timus;

import java.io.PrintWriter;
import java.util.*;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1502">1502. Точки домино</a>
 */
public class t1502 {
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
        long n = in.nextInt();
        System.out.println((n * (n + 1) * (n + 2)) / 2);
    }
}
