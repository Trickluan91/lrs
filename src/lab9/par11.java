package lab9;

import java.util.*;

public class par11 {
    static final int N = 5_000_000;
    static final int randIndex = (int) (Math.random() * N);

    static long time(Runnable r) {
        long start = System.nanoTime();
        r.run();
        return (System.nanoTime() - start) / 1_000_000;
    }

    void main() {
        testDeque();
        testList();
        testSortedSet();
    }

    void testDeque(){
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        IO.println("ArrayDeque add first: " + time(() -> { for (int i = 0; i < N; i++) deque.push(i); }));
        IO.println("ArrayDeque remove first: " + time(() -> { for (int i = 0; i < N; i++) deque.pop(); }));

        IO.println("ArrayDeque add last: " + time(() -> { for (int i = 0; i < N; i++) deque.addLast(i); }));
        IO.println("ArrayDeque remove last: " + time(() -> { for (int i = 0; i < N; i++) deque.removeLast(); }));

        for (int i = 0; i < N; i++) { deque.add(i); }
        IO.println("ArrayDeque get: " + time(() -> search(deque, randIndex)));
    }

    void testList(){
        List<Integer> list = new ArrayList<>(N);

        IO.println("ArrayList add first: " + time(() -> { for (int i = 0; i < N; i++) list.add(i); }));
        //IO.println("ArrayList remove first: " + time(() -> { for (int i = 0; i < N; i++) list.removeFirst(); }));

        //IO.println("ArrayList add mid: " + time(() -> { for (int i = 0; i < N; i++) list.add(list.size() / 2, i); }));
        //IO.println("ArrayList remove mid: " + time(() -> { for (int i = 0; i < N; i++) list.remove(list.size() / 2); }));

        IO.println("ArrayList add last: " + time(() -> { for (int i = 0; i < N; i++) list.addLast(i); }));
        IO.println("ArrayList remove last: " + time(() -> { for (int i = 0; i < N; i++) list.removeLast(); }));

        for (int i = 0; i < N; i++) { list.add(i); }
        IO.println("ArrayList get: " + time(() -> list.get(randIndex)));
    }

    void testSortedSet() {
        TreeSet<Integer> set = new TreeSet<>();

        IO.println("TreeSet add first: " + time(() -> { for (int i = 0; i < N; i++) set.add(i); }));
        IO.println("TreeSet remove first: " + time(() -> { for (int i = 0; i < N; i++) set.removeFirst(); }));

        IO.println("TreeSet add last: " + time(() -> { for (int i = N; i > 0; i--) set.add(i); }));
        IO.println("TreeSet remove last: " + time(() -> { for (int i = 0; i < N; i++) set.removeLast(); }));

        for (int i = 0; i < N; i++) { set.add(i); }
        IO.println("TreeSet get: " + time(() -> search(set, randIndex)));
    }

    void search(Collection<Integer> col, int index) {
        Iterator<Integer> it = col.iterator();
        for (int i = 0; i < index; i++) it.next();
        it.next();
    }
}
