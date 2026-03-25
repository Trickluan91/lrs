package lab9.timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1723">1723. Книга Сандро</a>
 */
public class t1723 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args){
        try {
            run();
        } finally {
            in.close();
            out.flush();
        }
    }

    static void run(){
        String s = in.next();
        int n = s.length();
        String best = s;
        int bestCount = 1;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                String sub = s.substring(i, i + len);
                int count = 0;
                for (int j = 0; j <= n - len; j++) {
                    if (s.substring(j, j + len).equals(sub)) count++;
                }
                if (count > bestCount || (count == bestCount && sub.length() > best.length())) {
                    bestCount = count;
                    best = sub;
                }
            }
        }
        out.println(best);
    }
}
