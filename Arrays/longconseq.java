import java.util.Arrays;
import java.util.HashSet;

public class longconseq {
    public static boolean search(int arr[], int target){
        for(int i =0;i<arr.length;i++){
            if(arr[i]==target){
                return true;
            }
        }
        return false;
    }

    public static int lcsbrute(int arr[]){  
        int longest = 1;
        for(int i =0;i<arr.length;i++){
            int el = arr[i];
            int count = 1;
            while(search(arr, el+1)){
                el = el+1;
                count++;
            }
            longest = Math.max(count,longest);
        }
        return longest;
    }

    public static int lcsbetter(int arr[]){
        Arrays.sort(arr);
        int longest = 1;
        int count = 0;
        int lastSmall = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            //increasing current sequence
            if(arr[i]-1==lastSmall){
                count++;
                lastSmall = arr[i];
                
            }//starting new sequence
            else if(arr[i]!=lastSmall){
                count =1;
                lastSmall = arr[i];
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
    public static int lcsoptimal(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        
        for(int i =0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int longest = 0;
        for(int nums : set){
            if(!set.contains(nums-1)){
                int count = 1;
                int x = nums;
                while(set.contains(x+1)){
                    x = x+1;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
    public static void main(String args[]){
        int arr[] = {102,4,100,1,101,3,2,1,99,103,1};
        System.out.println(lcsoptimal(arr));

    }
    
}
