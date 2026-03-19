package lab9.par1;

public class ex5 {
    void main() {
        IO.println(fact(5, 0));
    }

    int fact(int n, int d) {
        if(n == 0) {
            IO.println(" ".repeat(d) + 0);
            return 0;
        } else if(n == 1) {
            IO.println(" ".repeat(d) + 1);
            return 1;
        } else {
            IO.println(" ".repeat(d) + n);
            return fact(n - 1, d + 1) + fact(n - 2, d + 1);
        }
    }
}
