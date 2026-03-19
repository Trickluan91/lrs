package lab9;

public class par2 {
    void main() {
        try{
            translate(Integer.parseInt(IO.readln()));
        } catch(NumberFormatException e) {
            throw new RuntimeException("Error: enter only number");
        }
    }

    void translate(int x) {
        if(x == 0) return;
        translate(x / 2);
        IO.print(x % 2);
    }
}
