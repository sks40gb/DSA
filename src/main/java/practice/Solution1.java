package practice;

import util.ArrayUtil;

public class Solution1 {

    public static void main(String[] args) {
        int[][] matrix1 = {{0, 1}};
        int[][] matrix2 = {{1, 0, 3}};

        int[][] matrix3 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix4 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        new Solution1().setZeroes(matrix2);
        ArrayUtil.print2D(matrix2);
    }

    public void setZeroes(int[][] matrix) {
        int c0 = 1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    if (c == 0) {
                        c0 = 0;
                    } else {
                        matrix[0][c] = 0;
                    }
                }
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }

        if (c0 == 0) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }

    }
}
