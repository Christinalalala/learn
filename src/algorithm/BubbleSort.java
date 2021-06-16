package algorithm;

/**
 * 第一个for循环控制循环比较的次数
 * 第二个for循环控制每次循环中第一个数和其他数字比较的次数，知道把比他大或者小的输放到制定的位置
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 2, 9, 3, 8};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
