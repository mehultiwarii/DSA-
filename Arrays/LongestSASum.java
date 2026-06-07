public class LongestSASum {
    //iterate each sa using 3 loops
    public static int lsasumbrute(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            for(int j =i;j<arr.length;j++){
                int sum = 0;
                for(int k = i;k<=j;k++){
                    sum+= arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    //slighthly improve bf logic for better solution 
    public static int betterlsasum(int arr[]){
        int maxsum = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            int sum = 0;
            for(int j =i;j<arr.length;j++){
                sum+= arr[j];
                maxsum = Math.max(maxsum, sum);
            }
            
        }
        return maxsum;

    }

    //Optimal solution using kadane's algorithm
    public static void optimallsasum(int arr[]){
        int maxsum = Integer.MIN_VALUE;
        int sum = 0;
        //if asked to print the sa which gave us longest sum
        int tempstart = 0;
        int ansstart = -1;
        int ansend = -1;

        for(int i =0;i<arr.length;i++){
            if(sum==0){
                tempstart = i;
            }
            sum+=arr[i];

            if(sum>maxsum){
                maxsum = sum;
                ansstart = tempstart;
                ansend = i;
                
            }
            if(sum<0){
                sum = 0;
            }
            
        }
        //if no positive sum found(optional)
        if(maxsum<0){
            System.out.println("no positive maxsum found");
        }  
        System.out.println("subarray of maxsum is ");
        for(int i = ansstart;i<=ansend;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println("Maximum subarray sum is "+maxsum);
    }
    public static void main(String[] args) {
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};
        // System.out.println(lsasumbrute(arr));
        // System.out.println(betterlsasum(arr));
        optimallsasum(arr);
    }
    
}
