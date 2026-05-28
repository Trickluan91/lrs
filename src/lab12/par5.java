package lab12;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class par5 {
    private static final int cores = Runtime.getRuntime().availableProcessors();

    static void main() throws InterruptedException {
        int length = 1_000;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Random().nextInt(0, 10_000);
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
                    int localMax = arr[start];
                    for (int j = start + 1; j < end; j++)
                        if (arr[j] > localMax) localMax = arr[j];
                    return localMax;
                }));
            }

            int max = Integer.MIN_VALUE;
            for (Future<Integer> f : futures)
                max = Math.max(max, f.get());

            System.out.println(max);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
