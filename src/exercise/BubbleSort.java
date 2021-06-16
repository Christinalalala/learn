package exercise;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 6, 5, 4, 7, 2};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(i);
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
