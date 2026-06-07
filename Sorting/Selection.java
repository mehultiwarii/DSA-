
import java.util.*;

public class Selection {
    public static void selectionSort(int arr[]){

        for(int i =0;i<=arr.length-2;i++){
            int min =i;//considering first element index's to be minimum
            for(int j =i;j<=arr.length-1;j++){
                if(arr[j]<arr[min]){
                    min = j;//store the index
                }
            }
            //swap
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

        }
    }
    public static void main(String args[]){
        int arr[] = {13,46,24,52,20,9};

        selectionSort(arr);
        //print the arr

        for(int i =0;i<=arr.length-1;i++){
            System.out.print(arr[i]+ " ");
        }
    }
    
    
}
