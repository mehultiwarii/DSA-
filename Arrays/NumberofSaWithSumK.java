import java.util.HashMap;

public class NumberofSaWithSumK {
    public static int brute(int arr[], int n ){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j =i;j<arr.length;j++){
                int sum=0;
                for(int k = i;k<=j;k++){
                    sum+=arr[k];
                }
                if(sum==n){
                    count++;
                }
            }
        }
        return count;
    }
    public static int better(int arr[], int n){
        int count =0;
        for(int i =0;i<arr.length;i++){
            int sum=0;
            for(int j =i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==n){
                    count++;
                }
            }
            
        }
        return count;
    }

    public static int optimal(int arr[],int n){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);
        int prefixsum = 0;
        for(int num:arr){
            prefixsum +=num;
            int rem = prefixsum - n;

            if(map.containsKey(rem)){
                count+= map.get(rem);
            }
            map.put(prefixsum, map.getOrDefault(prefixsum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,-3,1,1,1,4,2,-3};
        System.out.println(optimal(arr, 3));
    }
    
}
