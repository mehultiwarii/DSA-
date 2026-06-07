//revese array //check if palindrome or not lol

public class Rec4{
    //recursion using two pointers swap
    public static void revarr(int arr[],int left,int right){
        if(left>=right){
            return;
        }
        //swap
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        revarr(arr, left+1, right-1);
    }
    //using single pointer
    public static void revarrnew(int i, int arr[], int n){
        if(i>=n/2){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[n-i-1];
        arr[n-i-1] = temp;
        revarrnew(i+1, arr, n);

    }

    //check if a string is palindrome
    public static boolean isPalindrome(int i,String str){
        if(i>=str.length()/2) {return true;}
        if(str.charAt(i)!= str.charAt(str.length()-i-1)){
            return false;
        }
        return isPalindrome(i+1, str);
    }
    public static void main(String[] args) {
        String str = "madam";
        int arr[] = {1,2,3,4,5};
        int n = arr.length-1;
        // revarr(arr, 0, n);
        revarrnew(0, arr, arr.length);
        for(int i : arr){
            System.out.print(i+" ");
        }
        int strl = str.length();
        System.out.println();
        System.out.println(isPalindrome(0, str));
        
    }
}