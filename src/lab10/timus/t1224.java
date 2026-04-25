package lab10.timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1224">1224. Спираль</a>
 */
public class t1224 {
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
        long height = in.nextInt(), width = in.nextInt();
        long turns = height + width - 2 - Math.abs(height - width);

        if(height > width) System.out.println(turns + 1);
        else System.out.println(turns);
    }
}
