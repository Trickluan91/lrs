package lab9.par1;

public class ex4 {
    void main(){
        IO.println(fact(7));
    }

    int fact(int n){
       int result;
       if (n != 1){
           result = fact(n - 1) * n;
           return result;
       }
       return 1;
    }
}
