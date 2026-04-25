package lab10.timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1457">1457. Теплотрасса</a>
 */
public class t1457 {
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
        int n = in.nextInt();
        double ans = 0;
        for(int i = 0; i < n; i++){
            ans += in.nextInt();
        }
        System.out.printf("%.6f", ans / n);

    }
}
