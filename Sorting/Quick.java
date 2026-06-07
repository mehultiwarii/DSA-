public class Quick {

    public static void quickSorting(int arr[], int low, int high) {

        if (low < high) {

            int pivotIndexing = pivotIdx(arr, low, high);

            quickSorting(arr, low, pivotIndexing - 1);

            quickSorting(arr, pivotIndexing + 1, high);
        }
    }

    public static int pivotIdx(int arr[], int low, int high) {

        int pivot = arr[low];

        int i = low;
        int j = high;

        while (i < j) {

            while (i <= high - 1 && arr[i] <= pivot) {
                i++;
            }

            while (j >= low + 1 && arr[j] > pivot) {
                j--;
            }

            if (i < j) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;

        return j;
    }

    public static void main(String[] args) {

        int arr[] = {3, 1, 2, 4, 1, 5, 6, 1, 2, 4};

        System.out.println("Before Sorting:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        quickSorting(arr, 0, arr.length - 1);

        System.out.println("\nAfter Sorting:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}