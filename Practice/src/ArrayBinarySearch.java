import java.util.Arrays;

public class ArrayBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, -5, 7, 6, 3, 2, 10, 0};
        ArrayBobbleSort.bubbleSort(arr);
        IO.println(Arrays.toString(arr));
        IO.println(binarySearch(arr, 7));
    }

    public static int binarySearch(int[] array, int target) {

        // Gate Keeping
        if (target < array[0] || target > array[array.length-1]) {
            return -1;
        }

        int halfIndex = array.length / 2;
        int offset = halfIndex / 2;
        while (true) {
            // Match
            if (array[halfIndex] == target) {
                return halfIndex;
            // Middle No Match
            } else if (
                (halfIndex - 1 >= 0 && halfIndex + 1 < array.length) 
                && (array[halfIndex - 1] < target && array[halfIndex + 1] > target)
            ) {
                return -1;
            // Search Left
            } else if (array[halfIndex] > target) {
                halfIndex -= offset;
                offset /= 2;
            // Search Right
            } else {
                halfIndex += offset;
                offset /= 2;
            }
            if (offset == 0) {
                offset = 1;
            }
        }
    }
}
