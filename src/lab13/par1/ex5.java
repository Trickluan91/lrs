package lab13.par1;

public class ex5 {
    static void main() {
        try {
            IO.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            IO.println("1");
        } catch (RuntimeException e) {
            IO.println(e);
        }
        IO.println("2");
    }
}
