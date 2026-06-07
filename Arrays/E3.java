import java.util.*;
public class E3 {
    //finding missing number(brute)
    public static int findMissingBrute(int arr[], int n){
        for(int i = 1;i<=n;i++){//number from 1 to 5 in the array
            int flag = 0;
            for(int j =0;j<arr.length;j++){//going from 0 to n-1(iteration in array )
                if(arr[j]==i){//for each number we are checking in array if it exist or not
                    flag =1;
                    break;
                }
            }
            if(flag==0){
                return i;
            }
        }
        return -1;
    }
    //finding missing better approach using hashing array
    public static int FindingMissingBetter(int arr[], int n){
        int hash[] = new int[n+1];
        //marking the hashing array
        for(int i =0;i<arr.length;i++){
            hash[arr[i]]= 1;
        
        }
        //iterating the hasharray to find element with occurance 0
        for(int i =1;i<hash.length;i++){
            if(hash[i] ==0){
                return i;
            }
        }
        return -1;

    }
    //finding missing optimal-sum
    public static int findingMissingOptimalSum(int arr[], int n){
        int sum = (n*(n+1))/2;
        int sum2 = 0;
        for(int i =0;i<arr.length;i++){
            sum2+=arr[i];
        }
        return sum-sum2;
    }
    //finding missing optimal xor
    public static int findingMisingOptimalXor(int arr[], int N){
        int n= N-1;
        int xor1=0;
        int xor2 = 0;
        for(int i =0;i<n;i++){
            xor2 =xor2 ^ arr[i];//xor of array elements
            xor1 = xor1^(i+1);//xor of 1 to n 
        }
        xor1= xor1^N;
        return xor1 ^xor2;
    }
    //------------------------------------------------------

    //maximum consecutive one's
    public static int maxConsOnes(int arr[]){
        int counter = 0;
        int max =0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]==1){
                counter++;
                max = Math.max(max, counter);

            }else{
                counter=0;
            }
        }
        return max;
    }
    //--------------------------------------------------
    //finding  number appearing  once in twice appearing array
    public static int numberOnce(int arr[]){
        for(int i = 0;i<arr.length;i++){
            int counter =0;
            int num = arr[i];
            for(int j =0;j<arr.length;j++){
                if(arr[j] == num){
                    counter++;                    
                }

            }
            if(counter==1){
                return num;
            }
        }
        return -1;
    }
     
    public static int numberOnceBetter(int arr[]){
        //finding maximum to determin the size 
        int maxi = 0;
        for(int i =0;i<arr.length;i++){
            maxi= Math.max(maxi, arr[i]);
        }
        //initialize the hashing array with size maxi and iterate to fill
        int hash[] = new int [maxi+1];
        for(int i =0;i<arr.length;i++){
            hash[arr[i]]++;
        }
        //finding one freq element form the arrayu
        for(int i =0;i<hash.length;i++){
            if(hash[i]==1){
                return i;
            }
        }
        return -1;
    }
    //this approach is better when we have negative numbers and large input 
    public static void numberOnceBetterMap(long arr[]){
        HashMap<Long,Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Long,Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                System.out.println(entry.getKey());
            }
        }
    }
    public static long numberOnceOptimal(long arr[]){
        long xor1 = 0;
        for(int i =0;i<arr.length;i++){
            xor1 = xor1 ^ arr[i];
        }
        return xor1;
    }

    public static void main(String args[]){
        int arr[] = {1,2,4,5};
        // System.out.println(findMissingBrute(arr, 5));
        // System.out.println(FindingMissingBetter(arr, 5));
        // System.out.println(findingMissingOptimalSum(arr, 5));
        System.out.println("missing number is");
        System.out.println(findingMisingOptimalXor(arr, 5));
        System.out.println("maximum consecutive ones");
        int mco[] = {1,1,0,1,1,1,1,0,0,1,1,0,1};
        System.out.println(maxConsOnes(mco));
        int numOnce[] = {1,1,2,3,3,4,4};
        long numOnceMap[] ={-1,-2,-2,4,4,5,5,6,6,9,9};
        System.out.println("Number appering once in array");
        // System.out.println(numberOnce(numOnce));
        // System.out.println(numberOnceBetter(numOnce));
        numberOnceBetterMap(numOnceMap);
        System.out.println("Optimal code for appering once in array");
        System.out.println(numberOnceOptimal(numOnceMap));
    }
}
