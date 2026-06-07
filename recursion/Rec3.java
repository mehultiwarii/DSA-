//sum and factorial lol
public class Rec3 {
    
    //parameterised summision
    public static void paraSum(int i, int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }
        paraSum(i-1, sum+i);

    }
    //functional(returning the value)
    public static int functionall(int n){
        if(n==0){
            return 0;
        }
        return n+functionall(n-1);
    }
    //factorial of n(fucntional/recursive)
    public static int rec(int n){
        if(n==0){
            return 1;
        }
        return n * rec(n-1);
    }
     //parameterized
    public static void parafact(int n,int pr){
        if(n==0){
            System.out.println(pr);
            return;
        }
        parafact(n-1, n*pr);
    }
    public static void main(String[] args) {
        paraSum(3, 0);
        System.out.println(functionall(4));
        System.out.println(rec(5));
        parafact(5, 1);
        
    }
}
