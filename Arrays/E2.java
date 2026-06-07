import java.util.ArrayList;
import java.util.TreeSet;

public class E2 {
    // left rotate the array by one place
    public static void rotateByOne(int arr[]){
        int temp = arr[0];
        for(int i= 1;i<arr.length;i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
    }
    //rotate array by d places
    public static void rotateByDPlaces(int arr[] , int n,int d){
        d = d%n;
        int temp[] = new int[d];
        //filling temp
        for(int i =0;i<d;i++){
            temp[i] = arr[i];
        }
        //shifting
        for(int i =d;i<n;i++){
            arr[i-d] =arr[i];
        }
        //putting back temp in array
        for(int i = n-d;i<n;i++){
            arr[i] = temp[i-(n-d)];
        }


    }
    //reverse arr(required for optimal)
    public static void revarr(int arr[], int left, int right){

        while(left<right){
            int temp = arr[left]; 
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
    //optimal solution of rotate by d places
    public static void rotatebydoptimal(int arr[],int d){
        int n  = arr.length;

        //handling d if it is large
        d= d%n;

        //reversing the first half
        revarr(arr, 0, d-1);
        //reversing second half
        revarr(arr, d, n-1);
        //reversing whole array
        revarr(arr, 0, n-1);
    }


    //move non zeroes element in the end 
    public static void moveNZBrute(int arr[]){
        int n =arr.length;

        ArrayList<Integer> list = new ArrayList<>();
        //filling the list with non zeros
        for(int i =0;i<n;i++){
            if(arr[i]!=0){
                list.add(arr[i]);
            }
        }

        //filling the array with nz on first place from the list 
        for(int i =0;i<list.size();i++){
            arr[i] = list.get(i);
        }

        //fill remaining with non zeroes
        for(int i = list.size();i<n;i++){
            arr[i] = 0;
        }

    }
    //optimal soluction 
    public static void moveZerosOptimal(int arr[]){
        int n= arr.length;
        //find the first zero idx
        int j = -1;
        for(int i = 0;i<n;i++){
            if(arr[i]==0){
                j = i;//giving j the first '0' element index
                break;
            }
        }
        //swapp with non zero <->zero, then iterate 
        for(int i = j+1;i<n;i++){
            if(arr[i]!=0){
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
            }
        }
    }

    //finding union brute
    public static void unionFind(int arr1[], int arr2[]){
        //create tree set
        TreeSet<Integer> set = new TreeSet<>();

        //fill with first array unique elwmwnt
        for(int i =0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        //fill with second array unique elemetns
        for(int i =0;i<arr2.length;i++){
            set.add(arr2[i]);
        }

        //creating result array 
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:set){
            list.add(i);
        }

        //printing the list 
        for(int i =0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
    public static ArrayList<Integer> unionFindOptimal(int arr1[], int arr2[]){
        //initializing the two pointers in both the array 
        int i =0;
        int j= 0;

        ArrayList<Integer> list = new ArrayList<>();

        while(i<arr1.length && j<arr2.length){
            //if the arr1 is smaller
            if(arr1[i]<arr2[j]){
                if(list.size()==0 || list.get(list.size()-1)!=arr1[i]){
                    list.add(arr1[i]);
                }
                i++;
            }
            //if the arr2 is smaller
            else if(arr2[j]<arr1[i]){
                if(list.size()==0 || list.get(list.size()-1)!=arr2[j]){
                    list.add(arr2[j]);
                }
                j++;
            }
            //if the elements are equal
            else{
                if(list.size()==0|| list.get(list.size()-1)!= arr1[i]){
                    list.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        //remaining elements
        while(i<arr1.length){
            if(list.get(list.size()-1)!=arr1[i]){
                list.add(arr1[i]);
            }
            i++;
        }
        while(j<arr2.length){
            if(list.get(list.size()-1)!=arr2[j]){
                list.add(arr2[j]);
            }
            j++;
        }
        return list;

    }

    //intersection
    public static ArrayList<Integer> intersectionBrute(int arr1[],int arr2[]){
        int vis[] = new int[arr2.length];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0;i<arr1.length;i++){
            for(int j = 0;j<arr2.length;j++){
                if(arr1[i]==arr2[j] && vis[j]==0){
                    ans.add(arr1[i]);
                    vis[j] =1;
                    break;
                }
                if(arr2[j]>arr1[i]){
                    break;
                }
            }
        }
        return ans;
    }

    //intersection optimal code 
    public static ArrayList<Integer> intersectionOptimal(int arr1[],int arr2[]){
        ArrayList <Integer> ans = new ArrayList<>();
        int i =0;
        int j =0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                i++;

            }
            else if(arr2[j]<arr1[i]){
                j++;
            }
            else{
                //congrats, its a fucking match!!!!! go fuck!!
                ans.add(arr1[i]);
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        // rotateByDPlaces(arr,arr.length,3);
        rotatebydoptimal(arr, 3);
        // for(int i : arr){
        //     System.out.print(i + " ");
        // }
        int nz[] = {1,2,4,3,0,2,0,1,7,6,0,0,0,3};
        // moveNZBrute(nz);
        moveZerosOptimal(nz);
        for(int i : nz){
            System.out.print(i + " ");
        }
        int arr1[] = {1,1,2,3,4,5,8,8};
        int arr2[] ={1,1,5,5,9,10}; 
        System.out.println("union elements brute");
        unionFind(arr1, arr2);
        System.out.println();
        System.out.println("union elements optimal");
        ArrayList<Integer> union = unionFindOptimal(arr1, arr2);
        for(int i : union){
            System.out.print(i + " ");
        }

        System.out.println("----------------------");
        System.out.println("Intersection Brute");
        ArrayList<Integer> list = intersectionBrute(arr1, arr2);
        for(int i : list){
            System.out.print(i+ " ");
        }
        System.out.println();
        System.out.println("Intersection Optimal");
        ArrayList<Integer> listoptimal = intersectionOptimal(arr1, arr2);
        for(int i : listoptimal){
            System.out.print(i + " ");
        }


        


    }
    
}
