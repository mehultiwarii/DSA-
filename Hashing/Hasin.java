import java.util.*;
public class Hasin {
  public static void main(String[] args) {
        //count the freq of the elements in the array 
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0;i<n;i++){
            System.out.print("Enter the element "+i+ " ");
            arr[i] = sc.nextInt();
        }
        //pre processing -> freq array count
        int hash[] = new int[13];
        for(int i =0;i<n;i++){
            hash[arr[i]]++;
        }
        int query;
        System.out.println("Enter number of questions");
        query = sc.nextInt();
        while(query-->0){
            System.out.println("Enter the number for frequency");
            int num= sc.nextInt();
            System.out.println(hash[num]);
        }
        
    }
}
