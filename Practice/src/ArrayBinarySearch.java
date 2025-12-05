import java.util.Arrays;

public class ArrayBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, -5, 7, 6, 3, 2, 10, 0};
        ArrayBobbleSort.bubbleSort(arr);
        IO.println(Arrays.toString(arr));
        for (int i = -6; i < 12; i++) {
            IO.print(i + ":" + binarySearch(arr, i) + "; ");
        }
        IO.println();
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        if (target == array[left]) return left;
        if (target == array[right]) return right;
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
