package lab9.timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1638">1638. Книжный червь</a>
 */
public class t1638 {
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
        int depthSheets = in.nextInt(), depthBinding = in.nextInt(), tomStart =  in.nextInt(), tomEnd = in.nextInt();
        out.println(Math.abs(depthSheets * (tomEnd - tomStart - 1) + 2 * depthBinding * (tomEnd - tomStart)));
    }
}
