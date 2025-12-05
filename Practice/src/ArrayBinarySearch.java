import java.util.Arrays;

public class ArrayBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, -5, 7, 6, 3, 2, 10, 0};
        ArrayBobbleSort.bubbleSort(arr);
        IO.println(Arrays.toString(arr));
        IO.println(binarySearch(arr, 8));
    }

    public static int binarySearch(int[] array, int target) {
        int halfIndex = array.length / 2;
        if (array[halfIndex] == target) {
            return halfIndex;
        } else if (array[halfIndex] > target) {
            return binarySearch(Arrays.copyOfRange(array, 0, halfIndex), target);
        } else {
            return halfIndex + binarySearch(Arrays.copyOfRange(array, halfIndex, array.length), target);
        }
    }
}
