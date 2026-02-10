package arrays;

import java.util.Arrays;

public class ArrayExtend {
    public static void main(String[] args) {
        Integer[] array = new Integer[3];
        array[0] = 3;
        array[1] = 8;
        array[2] = -7;
        array = arrayAddElement(array, -9);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static <T> T[] arrayAddElement(T[] array, T newElement) {
        T[] arrayNew = Arrays.copyOf(array, array.length + 1);
        arrayNew[arrayNew.length - 1] = newElement;
        return arrayNew;
    }
}
