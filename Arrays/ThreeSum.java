import java.util.*;
public class ThreeSum {
    public static List<List<Integer>> brute(int arr[]){
        Set<List<Integer>> set=new HashSet<>();
        for(int i =0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                for(int k = j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        } 
        return new ArrayList<>(set);
    }

    //better -> discarding the third loop
    public static List<List<Integer>> better(int arr[]){
        HashSet<List<Integer>> ans = new HashSet<>();
        for(int i =0;i<arr.length;i++){
            HashSet<Integer> seen = new HashSet<>();
            for(int j =i+1;j<arr.length;j++){
                int k = -(arr[i]+arr[j]);
                if(seen.contains(k)){
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],k);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                seen.add(arr[j]);
            }
        }
        return new ArrayList<>(ans);
    }


    //optimal with 2 ptr
    public static List<List<Integer>> optimal(int arr[]){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<arr.length-2;i++){
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            int left = i+1;
            int right = arr.length-1;
            while(left<right){
                int sum = arr[i]+arr[left]+arr[right];
                if(sum==0){
                    ans.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--;
                    //skip duplicate left
                    while(left<right&& arr[left]==arr[left-1]){
                        left++;
                    }
                    //skip duplicate right
                    while(left<right && arr[right]==arr[right+1]){
                        right--;
                    }
                }else if(sum<0){
                    left++;
                }else{
                    right--;
                }
                
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] ={-1,0,1,2,-1,-4};
        List<List<Integer>> ans = optimal(arr);
        System.out.println(ans);
    }
    
}
