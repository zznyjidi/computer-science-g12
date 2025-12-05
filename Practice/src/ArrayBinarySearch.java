import java.util.Arrays;

public class ArrayBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, -5, 7, 6, 3, 2, 10, 0};
        ArrayBobbleSort.bubbleSort(arr);
        IO.println(Arrays.toString(arr));
        IO.println(binarySearch(arr, 7));
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (right-left > 1) {
            int middle = (left + right) / 2;
            if (array[middle] == target) {
                return middle;
            } else if (array[middle] > target) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return -1;
    }
}
