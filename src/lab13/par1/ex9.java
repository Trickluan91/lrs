package lab13.par1;

public class ex9 {
    static void main() {
        IO.println(m());
    }

    public static int m() {
        try {
            IO.println("0");
            return 55;    // выход из метода
        } finally {
            IO.println("1");
        }
    }
}
