
public class Bubble {

    public static void bubbleSorting(int arr[]){
        for(int i =arr.length-1;i>=0;i--){
            int didSwap = 0;
            for(int j = 0;j<=i-1;j++){
                //swapping
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap=1;
                }
                
            }
            if(didSwap ==0){
                break;
            }
        }
    }

    public static void recBubbleSort(int arr[],int n){
        if(n==1){
            return;
        }
        for(int j = 0;j<=n-2;j++){
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;

            }
        }
        recBubbleSort(arr,n-1);
    }
    public static void main(String args[]){
        int arr[] = {13,46,24,52,20,9};
        // bubbleSorting(arr);
        for(int i =0;i<=arr.length-1;i++){
            System.out.print(arr[i]+ " ");
        }
        recBubbleSort(arr, arr.length);
        System.out.println();
         for(int i =0;i<=arr.length-1;i++){
            System.out.print(arr[i]+ " ");
        }


    }
    
}
