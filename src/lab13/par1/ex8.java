package lab13.par1;

public class ex8 {
    static void main() {
        try {
            IO.println(m());
        } catch (RuntimeException e) {
            IO.println(e);
        }
    }

    static int m() {
        try {
            IO.println("0");
            throw new RuntimeException();
        } finally {
            IO.println("1");
        }
    }
}
