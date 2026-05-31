package lab13.timus;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=2035">2035. Очередной пробный тур</a>
 */
public class t2035 {
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
        int x = in.nextInt(), y = in.nextInt(), c = in.nextInt();
        int a = Math.min(x, c);
        int b = c - a;
        if(b >= 0 && b <= y) {
            out.print(a);
            out.print(" ");
            out.print(b);
        } else {
            out.print("Impossible");
        }
    }
}
