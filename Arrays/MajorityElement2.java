import java.util.*;
public class MajorityElement2{
    public static List<Integer> brute(int arr[]){
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            if(ans.size()==0 || ans.get(0)!=arr[i] ){
                int count =0;
                for(int j=0;j<arr.length;j++){
                    if(arr[j]==arr[i]){
                        count++;
                    }
                }

                if(count>arr.length/3){
                    ans.add(arr[i]);
                }
            }
            if(ans.size()==2) break;
        }
        return ans;
    }

    
    public static void main(String args[]){
        int arr[] = {3,2,3};
        List<Integer> finalk = brute(arr);
        System.out.println(finalk);

    }
}