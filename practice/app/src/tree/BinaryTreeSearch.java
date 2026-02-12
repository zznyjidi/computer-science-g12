package tree;

import java.util.Random;

public class BinaryTreeSearch {

    public static int normalSearch(int[] numbers, int target) {
        int opCount = 0;

        for (int number : numbers) {
            opCount++;
            if (number == target)
                break;
        }
        return opCount;
    }

    public static int[] generateRandomArray(int length, int nStart, int nStop) {
        int[] numbers = new int[length];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(nStart, nStop);
        }

        return numbers;
    }

    final static int SEARCH_COUNT = 1000;

    public static void main(String[] args) {
        IO.println("Search: " + SEARCH_COUNT);

        int[] numbers = generateRandomArray(1000, 0, 101);
        int[] searchNumbers = generateRandomArray(SEARCH_COUNT, 0, 101);

        int simpleTotalOpCount = 0;
        for (int i : searchNumbers) {
            simpleTotalOpCount += normalSearch(numbers, i);
        }
        IO.println("SimpleSearch: ");
        IO.println("SearchAverage: " + (simpleTotalOpCount / SEARCH_COUNT));
        IO.println("SearchTotal: " + simpleTotalOpCount);

        BinaryTreeNode root = new BinaryTreeNode();

        int buildOpCount = 0;
        for (int number : numbers) {
            buildOpCount += root.add(number);
        }
        int binaryTotalCount = 0;
        for (int i : searchNumbers) {
            binaryTotalCount += root.search(i);
        }
        IO.println("BinarySearch: ");
        IO.println("Build: " + buildOpCount);
        IO.println("SearchAverage: " + (binaryTotalCount / SEARCH_COUNT));
        IO.println("SearchTotal: " + binaryTotalCount);
        IO.println("TotalAverage: " + (binaryTotalCount + buildOpCount) / SEARCH_COUNT);
        IO.println("Total: " + (binaryTotalCount + buildOpCount));
    }
}
