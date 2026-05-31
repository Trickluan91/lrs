package lab13.par2;

public class t3 {
    static int n = 5;
    static byte[] matrix = new byte[n];

    static void main() {
        IO.println(String.format("Введите числа от -128 до 127 для вычисления суммы. Максимальное количество цифр: %d", n));

        for (int i = 0; i < n; i++) {
            Byte b = null;
            while (b == null) b = parseByte(IO.readln());
            matrix[i] = b;
        }

        int sum = 0;
        for (byte j : matrix) sum += j;
        IO.println(sum);
    }

    static Byte parseByte(String str){
        try {
            int val = Integer.parseInt(str);
            if(val < Byte.MIN_VALUE || val > Byte.MAX_VALUE)
                throw new ArithmeticException("Число слишком большое или маленькое");
            return (byte) val;
        } catch (NumberFormatException e) {
            IO.println("Пожалуйста, введите число");
            return null;
        } catch (RuntimeException e){
            IO.println(e.getMessage());
            return null;
        }
    }
}
