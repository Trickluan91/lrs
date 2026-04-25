package lab10.timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1925">1925. О заслуге британских учёных</a>
 */
public class t1925 {
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
        int n = in.nextInt(), k = in.nextInt(), corr = 0, input = 0;
        for (int i = 0; i < n; i++) {
            corr += in.nextInt() - 2;
            input += in.nextInt();
        }
        int ans = corr + (k - 2) - input;
        System.out.println(ans < 0 ? "Big Bang!" : ans);
    }
}
