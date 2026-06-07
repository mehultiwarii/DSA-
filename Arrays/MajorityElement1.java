import java.util.*;
public class MajorityElement1 {
    public static int majelbrute(int arr[]){
        for(int i =0;i<arr.length;i++){
            int count =0;
            for(int j = 0; j<arr.length;j++){
                if(arr[j] == arr[i]){
                    count++;
                }
            }
            if(count> arr.length/2){
                return arr[i];
            }
        }
        return -1;
    }
    //better solution using a hashmap 
    public static void majelbetter(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()>arr.length/2){
                System.out.println("majority element is "+ entry.getKey());
            }
        }

    }
    //optimal using moore's voting algorithm
    public static int majeloptimal(int arr[]){
        int el = 0;
        int count = 0;
        for(int i =0;i<arr.length;i++){
            if(count==0){
                count = 1;
                el = arr[i];
            }else if(arr[i]==el){
                count++;
            }else{
                count--;
            }
        }
        //verifiacation
        int newcount =0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]==el){
                newcount++;
            }
        }
        if(newcount>arr.length/2){
            return el;
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[] = {3,3,1,5,5,3,3};
        // System.out.println(majelbrute(arr));
        // majelbetter(arr);
        
        System.out.println(majeloptimal(arr));
        
    }
    
}
