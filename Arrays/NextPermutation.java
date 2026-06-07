public class NextPermutation {
    //using helper function swap and reverse
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse(int arr[], int a, int b) {
        while(a < b) {
            swap(arr, a, b);
            a++;
            b--;
        }
    }
    public static void optimal(int arr[]){
        int index = -1;
       

        //1-> finding the longest prefix match
        for(int i = arr.length-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                index = i;
                break;

            }
        }


          // 2. If last permutation
        if(index == -1) {
            reverse(arr, 0, arr.length- 1);
            return;
        }
        //2-> finding the next greater element from breakpoint
        for(int i = arr.length-1;i>index;i--){
            if(arr[i]>arr[index]){
                swap(arr,i, index);
                break;
            }
        }

        //3-> reverse the entire half
        reverse(arr,index+1,arr.length-1);

    }
    public static void main(String args[]){
        int arr[] = {2,1,5,4,3,0,0};
        optimal(arr);
        for(int i : arr){
            System.out.print(i+ " ");
        }
    }
    
}
