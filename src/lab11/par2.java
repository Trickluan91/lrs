package lab11;

import java.util.Arrays;
import java.util.Random;

public class par2 {
    static void main() {
        int size = Integer.parseInt(IO.readln("Введите размер массива\n"));
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            arr1[i] = random.nextInt(200);
            arr2[i] = random.nextInt(200);
        }

        IO.println("Массив arr1 : ");
        IO.println(Arrays.toString(arr1));

        IO.println("Массив arr2 : ");
        IO.println(Arrays.toString(arr2));

        int[] arrResult = findCommonElements(arr1, arr2);

        IO.println("Массив arrResult :");
        IO.println(Arrays.toString(arrResult));
    }

    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1)
                .filter(x -> Arrays.stream(arr2)
                        .anyMatch(y -> y == x))
                .toArray();
    }
}
