public class setMatrix0 {
    public static void setrow(int matrix[][], int i){
        for(int j = 0;j<matrix[0].length;j++){ 
            if(matrix[i][j] == 1){
                matrix[i][j] =-1;
            }
        }
    }
    public static void setcol(int matrix[][],int col){
        for(int j =0;j<matrix.length;j++){
            if(matrix[j][col]==1){
                matrix[j][col] = -1;
            }
        }
    }
    public static void setbrute(int matrix[][]){
        //go to eah row to set
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    setrow(matrix,i);
                    setcol(matrix,j);
                }
            }
        }
        //set zeroes again
        for(int i =0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j] =0;
                }

            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        
    }
    //better approach
    public static void better(int arr[][]){
        int row[] = new int[arr.length];
        int col[] = new int[arr[0].length];
        for(int i =0;i<arr.length;i++){
            for(int j =0;j<arr[0].length;j++){
                if(arr[i][j] ==0){
                    row[i] = 1;
                    col[j] =1;
                }
            }
        } 
        for(int i =0;i<arr.length;i++){
            for(int j =0;j<arr[0].length;j++){
                if(row[i]==1 || col[j]==1){
                    arr[i][j] = 0;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void optimal(int arr[][]){
        int col0 = 1;
        for(int i =0;i<arr.length;i++){
            if(arr[i][0]==0){
                col0=0;
            }
            for(int j =0;j<arr[0].length;j++){
                if(arr[i][j] == 0){
                    //mark the row 
                    arr[i][0] = 0;
                    //mark the column 
                    arr[0][j] = 0;
                }
            }
        }
        //traversing from the end
        for(int i =arr.length-1;i>=1;i--){
            for(int j =arr[0].length-1;j>=1;j--){
                if(arr[i][0] == 0 || arr[0][j]==0){
                    arr[i][j] = 0;
                }
            }

            if(col0 == 0){
                arr[i][0] = 0;
            }
        }
         for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        int matrix[][] = {{1,1,1,1},
                       {1,0,0,1},
                        {1,1,0,1},
                        {1,1,1,1}
                    };
        // setbrute(matrix);
        // better(matrix);
        optimal(matrix);
    }
    
}
