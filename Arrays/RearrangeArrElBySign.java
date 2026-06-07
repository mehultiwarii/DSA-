import java.util.ArrayList;

public class RearrangeArrElBySign {
    
    public static void rearrangebrute(int arr[]){
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>0){
                positive.add(arr[i]);
                
            }else{
                negative.add(arr[i]);
            }
        }

        for(int i =0;i<arr.length/2;i++){
            arr[2*i] = positive.get(i);
            arr[2*i+1] = negative.get(i);
        }
    }

    //optimizing
    public static int[] rearrangeoptimal(int arr[]){
        int ans[] = new int[arr.length];
        int pos = 0;
        int neg = 1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>0){
                ans[pos] = arr[i];
                pos+=2;
            }else{
                ans[neg] =  arr[i];
                neg+=2;
            }

        }
        return ans;
      
    }

    //variety 2 
   public static int[] variety2optimal(int arr[]){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>=0){
                pos.add(arr[i]);
            }else{
                neg.add(arr[i]);
            }
        }

        int ans[] = new int[arr.length];
        int index = 0;
        for(int i =0;i<Math.min(pos.size(),neg.size());i++){
            ans[index++] = pos.get(i);
            ans[index++] = neg.get(i);
        }

        //getting remaining positive
        for(int i =Math.min(pos.size(),neg.size());i<pos.size();i++){
            ans[index++] = pos.get(i);
        }
        ///getting remaining negative
        for(int i = Math.min(pos.size(),neg.size());i<neg.size();i++){
            ans[index++] = neg.get(i);
        }
        return ans;
    } 
   public static void main(String args[]){
     int arr[] = {-2,-5,3,7,4,-9,10,-12,-1,6,9,8};
     
     
    //  int sol[] =  rearrangeoptimal(arr);
     
    //  for(int i : sol){
    //      System.out.print(i+" ");
    //     }   
        int ans[] = variety2optimal(arr);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
    
}
