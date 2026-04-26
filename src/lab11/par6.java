package lab11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class par6 {
    static void main() {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        IO.println("Массив:");
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(1000));
            IO.println(integers.get(i));
        }

        List<Integer> integersAfter = squareList(integers);

        IO.println("Найденные числа:");

        for (Integer i : integersAfter) {
            IO.println(i);
        }
    }

    public static List<Integer> squareList(List<Integer> list) {
        return list.stream().filter(x -> x % 5 == 0).collect(Collectors.toList());
    }
}
