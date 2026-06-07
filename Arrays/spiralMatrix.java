public class spiralMatrix {
    public static void optimal(int arr[][]){
        int top= 0;
        int bottom = arr.length-1;
        int left = 0;
        int right = arr[0].length-1;

        while(top<=bottom && left<=right){

            //left to right 
            for(int i = left;i<=right;i++){
                System.out.print(arr[top][i]+" ");
            }
            top++;

            //top to bottom 
            for(int i = top;i<=bottom;i++){
                System.out.print(arr[i][right]+ " ");
            }
            right--;

            //right to left
            if(top<=bottom){
                for(int i =right;i>=left;i--){
                    System.out.print(arr[bottom][i]+" ");
                }
                bottom--;
            }
            //buttom to top 
            if(left<=right){
                for(int i = bottom;i>=top;i--){
                    System.out.print(arr[i][left]+" ");
                }
            }
            left++;


        }
    }
    
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};

        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("******************");
        System.out.println();
        optimal(arr);

    }
    
}
