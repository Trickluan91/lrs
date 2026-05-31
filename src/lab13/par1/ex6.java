package lab13.par1;

public class ex6 {
    static void main() {
        try {
            IO.println("0");
            throw new NullPointerException("ошибка");
        } catch (ArithmeticException e) {
            IO.println("1");
        } catch (Exception e) {
            IO.println("2");
//        } catch (RuntimeException e) {
//            IO.println("3");
        }
        IO.println("4");
    }
}
