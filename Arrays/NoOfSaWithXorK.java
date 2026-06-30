import java.util.HashMap;

public class NoOfSaWithXorK {
    public static int brute(int arr[], int n){
        int count=0;
        for(int i =0;i<arr.length;i++){
            for(int j =i;j<arr.length;j++){
                int Xor= 0;
                for(int k =i;k<=j;k++){
                    Xor = Xor^arr[k];
                }
                if(Xor==n){
                    count++;
                }
            }
        }
        return count;
    }
    public static int better(int arr[],int n){
        int count = 0;
        for(int i =0;i<arr.length;i++){
            int Xor = 0;
            for(int j = i;j<arr.length;j++){
                Xor = Xor^arr[j];
                if(Xor==n) count++;
                
            }
            
            
        }
        return count;
    }
    public static int optimal(int arr[], int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        int xor = 0;
        int count = 0;
        map.put(0, 1);
        for(int i =0;i<arr.length;i++){
            xor = xor^arr[i];
            
            int x = xor^n;
            if(map.containsKey(x)){
                count+=map.get(x);
            }
            map.put(xor, map.getOrDefault(xor, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] ={4,2,2,6,4};
        System.out.println(optimal(arr, 6));
    }
}
