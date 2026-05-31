package lab13.par1;

public class ex14 {
    static void main(String[] args) {
        try {
            int l = args.length;
            IO.println("размер массива= " + l);
            m(l);
        } catch (ArithmeticException e) {
            IO.println("Ошибка: Деление на ноль");
        }
    }

    public static void m(int x) throws ArithmeticException {
        int h = 10 / x;
    }
}
