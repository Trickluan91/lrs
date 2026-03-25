package lab9.timus;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1617">1617. Ползуны</a>
 */
public class t1617 {
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
        Map<Integer, Integer> map = new HashMap<>();
        int n  = in.nextInt();
        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int ans = 0;
        for (Integer value : map.values()) {
            if(value >= 4) ans += value / 4;
        }
        out.println(ans);
    }
}
