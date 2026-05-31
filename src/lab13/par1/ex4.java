package lab13.par1;

public class ex4 {
    static void main() {
        try {
            IO.println("0");
            throw new RuntimeException("ошибка");
        } catch (NullPointerException e) {
            IO.println("1");
        } catch (Exception e) {
            IO.println("2");
        } catch (Error e) {
            IO.println("3");
        }
        IO.println("4");
    }
}
