import java.util.ArrayList;

public class SortArrOf0s1s2s {
    public static void mergeSort(int arr[], int low, int high){
        
        //base case
        if(low>=high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr, low, mid, high);
    }
    public static void merge(int arr[], int low, int mid, int high){
        int left = low;
        int right = mid+1;
        ArrayList<Integer>list = new ArrayList();
        while(left<=mid&& right<=high){
            if(arr[left]<=arr[right]){
                list.add(arr[left]);
                left++;
            }
            else{
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
        //copy everything
        for(int i =low; i<=high;i++){
            arr[i] = list.get(i-low);
        }
    }
    //bettter solution
    public static void betterSort(int arr[]){
        int count0 = 0;
        int count1= 0;
        int count2=0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]==0) count0++;
            else if (arr[i]==1) count1++;
            else count2++;
        }
        for(int i =0;i<count0;i++){
            arr[i] =0;
        }
        for(int i =count0;i<count0+count1;i++){
            arr[i]= 1;

        }
        for(int i =count0+count1;i<arr.length;i++){
            arr[i] = 2;
        }
    }

    //the most optimal approach
    public static void swap(int arr[],int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    //using dutch national flag algorithm 
    public static void optimalSort(int arr[]){
        int low = 0;
        int mid =0;int high = arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,mid,low);
                mid++;
                low++;
            }
            else if(arr[mid] ==1){
                mid++;
            }
            else{
                swap(arr,mid,high);
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {0,1,1,0,0,2,1,0,0,2,2,2,0,2,2,1,0,0};
        // mergeSort(arr, 0, arr.length-1);
        // System.out.println("Using merge sort");
        // for(int i : arr){
        //     System.out.print(i+ " ");
        // }
        // System.out.println("Better Sort using counter");
        // betterSort(arr);
        System.out.println("Using dutch national flag alogirthm");
        optimalSort(arr);
        for(int i: arr){
            System.out.print(i+ " ");
        }


    }
    
}
