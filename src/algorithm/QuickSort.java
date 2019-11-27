package algorithm;


public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2,9,3,6,4,7};
        quickSort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] arr,int low,int high){
        if (low < high) {
            int middle = partition(arr, low, high);
            quickSort(arr,low,middle-1);
            quickSort(arr,middle+1,high);
        }
    }

    public static int  partition(int[] arr,int low,int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && temp <= arr[high]) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && temp >= arr[low]) {
                low++;
            }
            arr[high] = arr [low];
        }
        arr[low] = temp;
        return low;
    }
}
