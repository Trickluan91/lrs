package lab13.par1;

public class ex1 {
    static void main() {
        try {
            IO.println("0");
            throw  new RuntimeException("Непроверяемая ошибка");
        } catch (RuntimeException e) { // исключение перехвачено
            IO.println("1  " + e);  // исключение обработано
        }
        IO.println("2");
    }
}
