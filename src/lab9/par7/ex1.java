package lab9.par7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ex1 {
    void main(){
        int n = Integer.parseInt(IO.readln());

        long startTime = System.nanoTime();

        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) list.add(i);

        while (list.size() > 1){
            for (int i = 0; i < list.size(); i++) {
                if(i % 2 == 0){
                    list.remove(i);
                }
            }
        }

        long endTime = System.nanoTime();
        IO.println(TimeUnit.SECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS));
    }
}
