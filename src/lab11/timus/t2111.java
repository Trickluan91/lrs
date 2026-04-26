package lab11.timus;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=2111">2111. Платон</a>
 */
public class t2111 {
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

    static void run(){
        int n  = in.nextInt(); long ans = 0, sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);
        for (int i : arr) {
            ans += sum * i + (sum - i) * i;
            sum -= i;
        }

        System.out.println(ans);
    }
}
