import java.util.*;
public class numberHash {
    public static void main(String[] args) {
        //forming and storing the the array
        System.out.println("Enter number of elements ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0;i<n;i++){
            System.out.println("Enter the number ");
            arr[i] = sc.nextInt();
        }
        //preprocessing
        Map<Integer, Integer> mapp= new HashMap<>(); 
        for(int i =0;i<n;i++){
            //store and get the frequency
            mapp.put(arr[i], mapp.getOrDefault(arr[i], 0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: mapp.entrySet()){
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }


        //query(number of questions)
        System.out.println("Number of questions ");
        int q = sc.nextInt();
        while(q-->0){
            //asking for a specific number
            int num = sc.nextInt();
            //fetch
            System.out.println(mapp.getOrDefault(num, 0));
        }
    }
    
}
