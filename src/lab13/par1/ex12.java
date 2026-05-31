package lab13.par1;

public class ex12 {
    static void main() {
        m("null", 0.000001);
    }

    public static void m(String str, double chislo) {
        if (str == null) {
            throw new IllegalArgumentException("Строка введена неверно");
        }
        if (chislo > 0.001) {
            throw new IllegalArgumentException("Неверное число");
        }

        IO.println(1);
    }
}
