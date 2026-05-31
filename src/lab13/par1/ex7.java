package lab13.par1;

public class ex7 {
    static void main() {
        try {
            try {
                IO.println("0");
                throw new NullPointerException("ошибка");
            } catch (NullPointerException e) {
                IO.println("1");
                throw new ArithmeticException();
            } catch (ArithmeticException e) {
                IO.println("2");
            }
        } catch (ArithmeticException e) {
            IO.println(e);
        }

        IO.println("3");
    }
}
