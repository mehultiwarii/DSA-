import java.util.*;
public class toSum {
    public static void twoSumBetter(int arr[],int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            int needed = target-arr[i];
            if(map.containsKey(needed)){
                System.out.println("Indexes are : "+ map.get(needed)+ " "+i);
            }
            map.put(arr[i], i);
        }

    }
    //best optimal for variety one solution
    public static boolean twoSumV1(int arr[], int target){
        int left = 0;
        int right = arr.length-1;
        Arrays.sort(arr);
        
        while(left<right){
            int sum = arr[left]+arr[right];
            if(sum == target){
                return true;
            }
            else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int arr[] = {2,6,5,23,55,8,11};
        twoSumBetter(arr, 13);
        System.out.println(twoSumV1(arr,13)
        );

    }
    
}
