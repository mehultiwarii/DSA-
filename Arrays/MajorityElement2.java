import java.util.*;

public class MajorityElement2 {
    public static List<Integer> brute(int arr[]) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (ans.size() == 0 || ans.get(0) != arr[i]) {
                int count = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == arr[i]) {
                        count++;
                    }
                }

                if (count > arr.length / 3) {
                    ans.add(arr[i]);
                }
            }
            if (ans.size() == 2)
                break;
        }
        return ans;
    }

    // using hashing
    public static List<Integer> better(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int nums: arr){
            map.put(nums,map.getOrDefault(nums,0)+1);
        }

        for(Map.Entry<Integer,Integer>entry : map.entrySet()){
            if(entry.getValue()>arr.length/3){
                list.add(entry.getKey());
            }
        }
        return list;
    }

    //moore's voting algo 
    public static void optimal(int arr[]){
        int count1 = 0;
        int count2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            if(count1==0 && arr[i]!=el2){
                count1 =1;
                el1 = arr[i];
            }
            else if(count2 ==0 && arr[i]!=el1){
                count2 = 1;
                el2 = arr[i];
            }
            else if(el1==arr[i]) count1++;
            else if(el2==arr[i])count2++;
            else{
                count1--;
                count2--;
            }
        }
    }

    

    public static void main(String args[]) {
        int arr[] = { 3, 2, 3 };
        List<Integer> finalk = better(arr);
        System.out.println(finalk);

    }
}