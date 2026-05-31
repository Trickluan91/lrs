package lab13.par1;

public class ex13 {
    static void main(String[] args) {
        try {
            int l = args.length;
            IO.println("размер массива= " + l);

            int h = 10 / l;
            args[l + 1] = "10";
        } catch (ArithmeticException e) {
            IO.println("Деление на ноль");
        } catch (ArrayIndexOutOfBoundsException e) {
            IO.println("Индекс не существует");
        }
    }
}
