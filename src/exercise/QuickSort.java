package exercise;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2,7,3,6,4,5};
        sort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sort(int[] arr,int low,int high){
        if (low<high) {
            int middle = partition(arr,low,high);
            sort(arr,low,middle-1);
            sort(arr,middle+1,high);
        }
    }

    private static int partition(int[] arr,int low,int high) {
        int temp = arr[low];
        while (low<high) {
            while (low<high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low<high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }
}
