package lab13.par1;

public class ex10 {
    static void main() {
        IO.println(m());
    }

    public static int m() {
        try {
            IO.println("0");
            return 15;
        } finally {
            IO.println("1");
            return 20;
        }
    }
}
