public class prac{
    static int count = 0;
    public static void mehul(){
        if(count==4){
            System.out.println(count);
            return;
        }
        System.out.println(count);
        count++;
        mehul();
        
    }

    //printing name 5 times
    public static void name(int i , int n){
        if(i>n){
            return;
        }
        System.out.println("Mehul");
        
        name(i+1, n);
       

    }
    //print 1 to n
    public static void oneTOn(int i,int n){
        if(i>n){
            return;
        }
        System.out.println(i);
        oneTOn(i+1, n);

    }
    
    
    //printing N to 1
    public static void nTOone(int n){
        if(n<1){
            return;
        }
        System.out.println(n);
        nTOone(n-1);
    }

    //ont to n backtrack
    public static void onetonBack(int n){
        if(n<1){
            return;
        }
        onetonBack(n-1);
        System.out.println(n);
    }
    //n to one backtarck
    public static void ntoOneBack(int i,int n){
        if(i>n){
            return;
        }
        ntoOneBack(i+1,n);
        System.out.println(i);
    }
    public static void main(String args[]){
        // name(1,5);
        // oneTOn(1, 5);
        // nTOone(10);
        onetonBack(5);
        nTOone(5);
    }
}