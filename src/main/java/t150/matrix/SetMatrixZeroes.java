package t150.matrix;

import util.ArrayUtil;

public class SetMatrixZeroes {

    public static void main(String[] args) {

        SetMatrixZeroes solution = new SetMatrixZeroes();

        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(matrix2);
        ArrayUtil.print2D(matrix2);
    }
    public void setZeroes(int[][] matrix) {

        boolean isFirstRowZero = false;
        for (int col = 0; col < matrix[0].length; col++) {
            if (matrix[0][col] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        boolean isFirstColumnZero = false;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][0] == 0) {
                isFirstColumnZero = true;
                break;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (isFirstRowZero) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }

        if (isFirstColumnZero) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }

    }
}
