package lab11;

import java.util.Arrays;
import java.util.Random;

public class par1 {
    static void main() {
        int size = Integer.parseInt(IO.readln("Введите размер массива\n"));
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            arr[i] = random.nextInt();
        }

        IO.println("Массив arr : ");
        IO.println(Arrays.toString(arr));

        int[] arrResult = filterEvenNumbers(arr);

        IO.println("Массив arrResult :");
        IO.println(Arrays.toString(arrResult));
    }

    public static int[] filterEvenNumbers(int[] arr) {
        return Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
    }
}
