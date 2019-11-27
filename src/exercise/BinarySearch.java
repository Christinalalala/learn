package exercise;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(circulation(arr,5));
        System.out.println(recursion(arr,5,0,arr.length));
    }

    private static int circulation(int[] arr,int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;
        if (key < arr[low] || key > arr[high]) {
            return -1;
        }
        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                high = middle - 1;
            }else if (arr[middle] < key) {
                low = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }



    private static int recursion (int[] arr,int key,int low,int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            if (arr[middle] > key) {
                return recursion(arr, key, low, middle-1);
            }else if (arr[middle] < key) {
                return recursion(arr, key, middle+1, high);
            }else {
                return middle;
            }
        }
        return -1;
    }
}
