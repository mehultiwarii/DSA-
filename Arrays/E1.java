
import java.util.*;
public class E1{
    //to find the second largest element in the array
    public static int secondlarge(int arr[]){
        int large = arr[0];
        int scndlarge =  -1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>large  ){
                scndlarge = large;
                large = arr[i];
            }
            else if(arr[i]<large && arr[i]>scndlarge){
                scndlarge = arr[i];
            }
            
        }
        return scndlarge;
    }
    //finding the second smallest element in the array
    public static int secondsmall(int arr[]){
        int smallest = arr[0];
        int ssmallest = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<smallest){
                ssmallest = smallest;
                smallest = arr[i];

            }
            else if(arr[i]!=smallest && arr[i]< ssmallest){
                ssmallest = arr[i];
            }
        }
        return ssmallest;
    }
    //checking if array is sorted or not
    public static boolean isSorted(int arr[]){
        for(int i =1;i<=arr.length-1;i++){
            if(arr[i]>=arr[i-1]){

            }
            else{
                return false;
            }

        }
        return true;
    }

    public static int removeDuplicate(int arr[]){
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        //adding items to the hashset
        for(int i =0;i<arr.length;i++){
            set.add(arr[i]);
        }
        //printing the hashset
        System.out.println("HashSet Contains");
        for(int i : set){
            System.out.print(i+" ");
        }
        System.out.println();
        //conpying process one by one 
        int index = 0;
        for(int i : set){
            arr[index] = i;
            index++;
        }
        return index;

    }
    //optimal code for removing duplicates
    public static int rmvDupl(int arr[]){
        int i =0;
        for(int j = 1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                arr[i+1] =arr[j];
                i++; 
            }
        }
        return i+1;//this is numebr of elements the array would contain
    }
    public static void main(String args[]) {
        
        int arr[] = {1,2,2,3,4,2,3,4,4,5,90,8};
        //code to find the largest element in the array 
        int largest= arr[0];
        for(int i = 0;i<arr.length;i++){
            if(arr[i]> largest){
                largest = arr[i];
            }
        }
        System.out.println("the largerst is "+largest);
        int secondLargest = secondlarge(arr);
        System.out.println();
        System.out.println(secondLargest);
        System.out.println();
        int secondSmallest = secondsmall(arr);
        System.out.println("The scond smallest element in the array is " + secondSmallest);
        System.out.println();
        System.out.println(isSorted(arr));
        int arrTwo[] = {1,1,1,3,4,4,5,6,6};
        int newidx = rmvDupl(arrTwo);
        
        System.out.println("printing the array");
        System.out.println();
        for(int i =0;i<newidx;i++){
            System.out.print(arrTwo[i]+" ");
        }
        
        
    }
}