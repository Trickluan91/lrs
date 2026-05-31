package lab13.par1;

public class ex11 {
    static void main() {
        try {
            IO.println("0");
            throw new NullPointerException("ошибка");
        } catch (NullPointerException e) {
            IO.println("1");
        } finally {
            IO.println("2");
        }
        IO.println("3");
    }
}
