package arrays;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] arr = { 5, -5, 7, 6, 3, 2, 10, 0 };
        System.out.println(Arrays.toString(sortArray(arr)));
    }

    public static int[] sortArray(int[] array) {
        int[] buffer = Arrays.copyOf(array, array.length);
        int[] sorted = new int[array.length];

        for (int i = 0; i < sorted.length; i++) {
            int minIndex = 0;
            for (int j = 0; j < buffer.length; j++) {
                if (buffer[j] < buffer[minIndex]) {
                    minIndex = j;
                }
            }
            sorted[i] = buffer[minIndex];
            buffer = removeAndCopy(buffer, minIndex);
        }

        return sorted;
    }

    public static int[] removeAndCopy(int[] array, int removeIndex) {
        int[] newArray = new int[array.length - 1];
        for (int i = 0; i < removeIndex; i++)
            newArray[i] = array[i];
        for (int i = removeIndex + 1; i < array.length; i++)
            newArray[i - 1] = array[i];
        return newArray;
    }
}
