package matrix;

import java.util.Arrays;
import java.util.Random;

public class MatrixMultiplication {
    public static int[][] generateMatrix(int width, int height, int randMin, int randMax) {
        int[][] matrix = new int[height][width];
        Random random = new Random();

        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                matrix[y][x] = random.nextInt(randMin, randMax);
            }
        }

        return matrix;
    }

    public static int[][] matrixMultiplication(int[][] matrix, int number) {
        int matrixHeight = matrix.length;
        int matrixWidth = matrix[0].length;
        int[][] newMatrix = new int[matrixHeight][matrixWidth];

        for (int y = 0; y < matrixHeight; y++) {
            for (int x = 0; x < matrixWidth; x++) {
                newMatrix[y][x] = matrix[y][x] * number;
            }
        }

        return newMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            IO.println(Arrays.toString(row));
        }
        IO.println();
    }

    final static int MATRIX_WIDTH = 2;
    final static int MATRIX_HEIGHT = 3;

    final static int MATRIX_RAND_MIN = -9;
    final static int MATRIX_RAND_MAX = 10;

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(MATRIX_WIDTH, MATRIX_HEIGHT, MATRIX_RAND_MIN, MATRIX_RAND_MAX);
        printMatrix(matrix);

        Random random = new Random();
        int randInt = random.nextInt(MATRIX_RAND_MIN, MATRIX_RAND_MAX);
        int[][] newMatrix = matrixMultiplication(matrix, randInt);
        IO.println(randInt);
        printMatrix(newMatrix);
    }
}
