package lab12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Напишите функцию, которая суммирует элементы в массиве целых чисел при помощи многопоточности.
 * Количество потоков должно быть равно количеству ядер процессора.
 */

public class par6 {
    private static final int cores = Runtime.getRuntime().availableProcessors();

    static void main() throws InterruptedException {
        int length = 100;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(0, 1_000);
        }
        System.out.println(Arrays.toString(arr));

        int chunkSize = (int) Math.ceil((double) arr.length / cores);
        int ts = Math.min(arr.length, cores);

        try(ExecutorService executor = Executors.newFixedThreadPool(ts)) {
            List<Future<Integer>> futures = new ArrayList<>();

            for (int i = 0; i < ts; i++) {
                int start = i * chunkSize;
                int end = Math.min(start + chunkSize, arr.length);
                futures.add(executor.submit(() -> {
                    int localSum = arr[start];
                    for (int j = start + 1; j < end; j++)
                        localSum += arr[j];
                    return localSum;
                }));
            }

            int sum = 0;
            for (Future<Integer> f : futures)
                sum += f.get();

            System.out.println(sum);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
