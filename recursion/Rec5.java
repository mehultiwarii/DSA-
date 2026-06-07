//nultiple recursion calls
//fibonacchi
//TC-> 2^n -exponential
public class Rec5 {
    public static int fab(int n){
        if(n<=1){
            return n;
        }
        int num = fab(n-1) + fab(n-2);
        return num;
    }
    public static void main(String[] args) {
        System.out.println(fab(4));
        
    }
}

