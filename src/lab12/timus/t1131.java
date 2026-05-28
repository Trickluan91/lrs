package lab12.timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1131">1131. Копирование</a>
 */
public class t1131 {
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
        long comps = in.nextInt(), cords = in.nextInt(), downloads = 1, time = 0;

        while (downloads < comps && downloads < cords) {
            downloads *= 2;
            time++;
        }

        if (downloads < comps) {
            time += (comps - downloads + cords - 1) / cords;
        }

        System.out.println(time);
    }
}
