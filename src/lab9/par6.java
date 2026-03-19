package lab9;

import java.util.*;
import java.util.random.RandomGenerator;

public class par6 {
    private static final HashMap<Integer, String> map = new HashMap<>(10);
    private static final RandomGenerator rand = RandomGenerator.getDefault();

    void main(){
        for (int i = 0; i < 10; i++) {
            map.put(rand.nextInt(0,100), UUID.randomUUID().toString());
        }

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if(entry.getKey() > 5) list1.add(entry.getValue());
            if(entry.getKey() == 0) list2.add(entry.getValue());
            if(entry.getValue().length() > 5) list3.add(entry.getKey());
        }

        IO.println(String.join(", ", map.values()));
        Integer hz = list3.stream().reduce((a, b) -> a * b).get();
    }
}
