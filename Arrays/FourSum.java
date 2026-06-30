import java.util.*;
public class FourSum {
    public static List<List<Integer>> brute(int arr[]){
        Set<List<Integer>> set = new HashSet<>();
        for(int i =0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                for(int k = j+1;k<arr.length;k++){
                    for(int l = k+1;l<arr.length;l++){
                        if(arr[i]+arr[j]+arr[k]+arr[l]==0){
                            List<Integer> ans= Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            Collections.sort(ans);
                            set.add(ans);
                        }
                    }

                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> better(int arr[]){
        Set<List<Integer>> set = new HashSet<>();
        for(int i =0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                Set<Integer>seen = new HashSet<>();
                for(int k = j+1;k<arr.length;k++){
                    int fourth = -(arr[i]+arr[j]+arr[k]);
                    if(seen.contains(fourth)){
                        List<Integer> ans = Arrays.asList(arr[i],arr[j],arr[k],fourth);
                        Collections.sort(ans);
                        set.add(ans);

                    }
                    seen.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> optimal(int arr[]){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            //skip the duplicate first ptr
            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }
            for(int j=i+1;j<arr.length;j++){
                if(j!=i+1 && arr[j]==arr[j-1]){
                    continue;
                }
                int k = j+1;
                int l =arr.length-1;
                while(k<l){
                    int sum = arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum==0){
                        ans.add(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        k++;
                        l--;
                        
                        while(k<l && arr[k]==arr[k-1])k++;
                        while(k<l && arr[l]==arr[l+1])l--;
                    }else if(sum<0){
                        k++;
                    }else{
                        l--;
                    }
                }
                
            }

        }
        return ans;
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,-1,-2,2,0,-1};
        List<List<Integer>> finall =optimal(arr);
        System.out.println(finall);
        
    }
}
