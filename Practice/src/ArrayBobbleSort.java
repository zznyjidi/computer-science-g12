import java.util.Arrays;

public class ArrayBobbleSort {
    public static void main(String[] args) {
        int[] arr = {5, -5, 7, 6, 3, 2, 10, 0};
        bubbleSort(arr);
        IO.println(Arrays.toString(arr));
    }

    public static int[] bubbleSort(int[] array) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    swapped = true;
                }
            }
        } while (swapped);
        return array;
    }
}
