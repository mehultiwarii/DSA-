import java.util.*;
public class Merge {
    public static void mergeSort(int arr[], int low, int high){
        //code for dividing the array

        //base case
        if(low>=high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        //function calling for the merge
        merge(arr, low,  mid, high);


    }

    public static void merge(int arr[], int low, int mid,int high){
        //left and right -> 2 pointers to compare the values and sort 
        int left = low;
        int right = mid+1;
        ArrayList<Integer> list = new ArrayList<>();
        while(left<=mid && right<=high){
            if(arr[left]<arr[right]){
                list.add(arr[left]);
                left++;
            }else{
                list.add(arr[right]);
                right++;
            }

        }
        while(left<=mid){
            list.add(arr[left]);
            left++;
        }
        while(right<=high){
            list.add(arr[right]);
            right++;
        }

        //copy list element to the original array 
        for(int i = low; i<=high;i++){
            arr[i] = list.get(i-low);
        }
        
    }
    public static void main(String args[]){
        int arr[] = {3,1,2,4,1,5,6,1,2,4};
        for(int i =0;i<=arr.length-1;i++){
            System.out.print(arr[i]+ " ");
        }
        mergeSort(arr, 0, arr.length-1);
        System.out.println();
        //print the array 
        for(int i =0;i<=arr.length-1;i++){
            System.out.print(arr[i]+ " ");
        }
    }
    
}
