import java.util.*;
public class Leader {
    public static ArrayList<Integer> leaderbrute(int arr[]){
        ArrayList<Integer> ans =new ArrayList<>();
        for(int i =0;i<arr.length;i++){
            boolean leader = true;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    leader = false;
                    break;
                }
            }
            if(leader==true)
            ans.add(arr[i]);
        }
        return ans;
    }
    public static ArrayList<Integer> leaderoptimal(int arr[]){
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i =arr.length-1;i>=0;i--){
            if(arr[i]>max){
                ans.add(arr[i]);
            }
            max = Math.max(max,arr[i]);
        }
        Arrays.sort(arr);
        return ans;
    }
    public static void main(String args[]){
        int arr[] = {10,22,12,3,0,6};
        ArrayList<Integer> sol = leaderoptimal(arr);
        for(int i : sol){
            System.out.print(i+" ");
        }
    }
    
}
