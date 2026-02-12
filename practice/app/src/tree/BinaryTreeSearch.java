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

    final static int SEARCH_COUNT = 10000;

    public static void main(String[] args) {
        IO.println("Started. ");
        IO.println();

        int[] numbers = generateRandomArray(SEARCH_COUNT, 0, SEARCH_COUNT + 1);
        int[] searchNumbers = generateRandomArray(SEARCH_COUNT, 0, SEARCH_COUNT + 1);

        IO.println("Search: " + SEARCH_COUNT);
        IO.println();

        int simpleSearchOp = 0;
        for (int i : searchNumbers) {
            simpleSearchOp += normalSearch(numbers, i);
        }
        IO.println("SimpleSearch: ");
        IO.println("Total: " + simpleSearchOp);
        int simpleSearchAve = simpleSearchOp / SEARCH_COUNT;
        IO.println("Average: " + simpleSearchAve);
        IO.println();

        BinaryTreeNode root = new BinaryTreeNode();

        int binaryBuildOp = 0;
        for (int number : numbers) {
            binaryBuildOp += root.add(number);
        }
        int binarySearchOp = 0;
        for (int i : searchNumbers) {
            binarySearchOp += root.search(i);
        }
        IO.println("BinarySearch: ");
        int binaryTotalOp = binaryBuildOp + binarySearchOp;
        IO.println("Total: " + binaryTotalOp);
        int binaryTotalAve = binaryTotalOp / SEARCH_COUNT;
        IO.println("Average: " + binaryTotalAve);
        IO.println("Build: " + binaryBuildOp);
        IO.println("SearchTotal: " + binarySearchOp);
        int binarySearchAve = binarySearchOp / SEARCH_COUNT;
        IO.println("SearchAverage: " + binarySearchAve);
        IO.println();

        IO.println("ForBinarySearchToBeMoreEfficient: " + (binaryBuildOp / (simpleSearchAve - binarySearchAve)));
    }
}
