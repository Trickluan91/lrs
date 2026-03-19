package lab9.par1;

public class ex3 {
    private static int step = 0;

    void main(){
        recurse(1);
    }

    void recurse(int x){
        space();
        IO.println(x + " ->");
        step++;
        if((2* x + 1) < 20) {
            recurse(2 * x + 1);
        }
        step--;
        space();
        IO.println(x + " <-");
    }

    void space() {
        for (int i = 0; i < step; i++) {
            IO.print(" ");
        }
    }
}
