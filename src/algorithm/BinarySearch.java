package algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        String str = "123";
        System.out.println(str.hashCode());
        System.out.println(circulationBinarySearch(arr, 3));
        System.out.println(recursionBinarySearch(arr, 3, 0, arr.length - 1));
    }

    private static int circulationBinarySearch(int[] arr, int key) {
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
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    private static int recursionBinarySearch(int[] arr, int key, int low, int high) {
        if (low <= high) {
            int middle = (low + high) / 2;
            if (arr[middle] < key) {
                return recursionBinarySearch(arr, key, middle + 1, high);
            } else if (arr[middle] > key) {
                return recursionBinarySearch(arr, key, low, middle - 1);
            } else {
                return middle;
            }
        }
        return -1;
    }

}
