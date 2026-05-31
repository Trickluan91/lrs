package lab13.par1;

public class ex2 {
    static void main() {
        try {
            IO.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
            //IO.println("1");
        } catch (Exception e) {
            IO.println("2 " + e);
        }
        IO.println("3");
    }
}
