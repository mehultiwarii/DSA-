public class Insertion {
    public static void insertionSorting(int arr[]){
        for(int i =1;i<=arr.length-1;i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                //swapp
                int temp = arr[j-1];
                arr[j-1]= arr[j];
                arr[j] = temp;

                j--;
            }
        }
    }
    public static void recInsertionSort(int arr[],int i , int n){
        //base case
        if(i==n) return;
        int j = i;
        while(j>0 && arr[j-1]>arr[j]){
            int temp =arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
            j--;
        }

        recInsertionSort(arr, i+1,n);

    }

    public static void main(String args[]){
        int arr[] = {13,46,24,52,20,9};
        // insertionSorting(arr);

        //printing the array 
        for(int i = 0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
        recInsertionSort(arr, 1,arr.length);
        System.out.println();
        for(int i = 0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
}
