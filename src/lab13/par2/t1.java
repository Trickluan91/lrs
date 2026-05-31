package lab13.par2;

public class t1 {
    static void main() {
        IO.println("Введите число сначала количество чисел (>0), потом сами числа. Все должно быть положительным");
        Integer n = null;
        while (n == null || n == 0) {
            n = parseInt(IO.readln());
            if(n != null && n == 0) IO.println("Введите ненулевое количество чисел");
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            Integer d = null;
            while (d == null) d = parseInt(IO.readln());
            arr[i] = d;
        }

        double average = 0;
        for (int j : arr) average += j;
        IO.println(average / n);
    }

    static Integer parseInt(String str){
        try {
            long val = Long.parseLong(str);
            if(val < 0) throw new RuntimeException("Число должно быть положительным");
            if(val > Integer.MAX_VALUE) throw new ArithmeticException("Число слишком большое");
            return (int) val;
        } catch (NumberFormatException e) {
            IO.println("Пожалуйста, введите число");
            return null;
        } catch (RuntimeException e){
            IO.println(e.getMessage());
            return null;
        }
    }
}
