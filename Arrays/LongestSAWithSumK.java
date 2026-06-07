import java.util.*;
public class LongestSAWithSumK {
    public static int longestSubarrayWithSumKBrute(int arr[], int k){
        int maxLength = 0;
        for(int i =0;i<arr.length;i++){
            int sum =0;
            
            for(int j = i;j<arr.length;j++){
                sum+=arr[j];
                if(sum==k){
                    maxLength = Math.max(maxLength,j-i+1);
                }
            }
        }
        return maxLength;
    }
    //optimal for positives and zeroes and negatives
    public static int longestSubarrayWithSumKBetter(int arr[],int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i =0;i<arr.length;i++){
            //prefix sum
            sum+= arr[i];
            //if entire sa from 0 to i
            if(sum == k){
                maxLen = Math.max(maxLen,i+1);
            }
            //remaining sum needed
            int rem = sum-k;
            //check if it exist in hashmap
            if(map.containsKey(rem)){
                int len = i-map.get(rem);//similar to len = right-left
                maxLen = Math.max(maxLen, len);
            }
            //storing first occurance only
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    //most optimal when array has postivies
    public static int longestSubarrayWithSumKOptimal(int arr[], int k){
        int maxlen = 0;
        int sum = arr[0];
        int left =0;
        int right = 0;
        while(right<arr.length){
            //shrinking the left
            while(left<=right && sum>k){
                sum-=arr[left];
                left++;
            }
            //bingi if sum ==k
            if(sum==k){
                maxlen = Math.max(maxlen, right-left+1);
            }
            //need to move right
            right++;
            if(right<arr.length){
                sum+=arr[right];
            };

        }
        return maxlen;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1,1,1,4,2,3};
        System.out.println(longestSubarrayWithSumKOptimal(arr, 4));
        // System.out.println(longestSubarrayWithSumKBrute(arr, 3));

    }
}
