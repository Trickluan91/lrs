package lab9.par1;

public class ex1 {
    void main() {
        recurse(1);
    }

    void recurse(int x) {
        IO.println("x=" + x);
        if((2 * x + 1) < 20) {
            recurse(2 * x + 1);
        }
    }
}
