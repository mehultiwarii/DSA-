public class bestTimeToBuySellStocks {
    public static int ans(int arr[]){
        int mini= arr[0];
        int maxprofit = 0;
        for(int i =1;i<arr.length;i++){
            int profit = arr[i]-mini;
            if(profit>maxprofit){
                maxprofit = profit;
            }
            if(arr[i]<mini){
                mini = arr[i];
            }
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        System.out.println(ans(arr));
    }
}
