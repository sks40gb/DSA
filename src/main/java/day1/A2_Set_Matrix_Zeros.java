package day1;

import util.ArrayUtil;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * Input: matrix =
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 *
 * Output:
 * [[1,0,1],
 * [0,0,0],
 * [1,0,1]]
 */
public class A2_Set_Matrix_Zeros {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        new A2_Set_Matrix_Zeros().solve(matrix);
        ArrayUtil.print2D(matrix);
    }

    private void solve(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    rows[row] = -1;
                    cols[col] = -1;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (rows[row] == -1 || cols[col] == -1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

}
