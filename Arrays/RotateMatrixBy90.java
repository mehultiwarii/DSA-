public class RotateMatrixBy90 {
    public static void printmatrix(int arr[][]){
         for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void brute(int arr[][]){
        int ans [][] = new int[arr.length][arr[0].length];
        for(int i =0;i<arr.length;i++){
            for(int j =0;j<arr[0].length;j++){
                ans[j][arr.length-1-i] = arr[i][j]; 
                
            }
        }
        printmatrix(ans);
        
    }
    public static void swapp(int arr[][],int i,int j){
        int temp =arr[i][j];
        arr[i][j] =arr[j][i];
        arr[j][i]= temp;
    }
    public static void reverserow(int arr[]){
        for(int i =0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
    public static void optimal(int arr[][]){
        //transpose then reverse 
        for(int i =0;i<arr.length;i++){
            for(int j =i+1;j<arr[0].length;j++){
                swapp(arr,i,j);
            }
            
        }

        for(int i =0;i<arr.length;i++){
            reverserow(arr[i]);
        }
        
        printmatrix(arr);
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},
                           {5,6,7,8},
                         {9,10,11,12},
                         {13,14,15,16}};
        // brute(matrix);
        optimal(matrix);
    }
    
}
