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
public class A1_Set_Matrix_Zeros {

    public static void main(String[] args) {

//        int[][] matrix = {
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        };

        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        solve(matrix);

        ArrayUtil.print2D(matrix);

    }

    private static void solve(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    setRow(matrix, row);
                    setCol(matrix, col);
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == -1) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    private static void setRow(int[][] matrix, int row) {
        for (int col = 0; col < matrix[row].length; col++) {
            if(matrix[row][col] != 0){
                matrix[row][col] = -1;
            }
        }
    }

    private static void setCol(int[][] matrix, int col) {
        for (int row = 0; row < matrix.length; row++) {
            if(matrix[row][col] != 0){
                matrix[row][col] = -1;
            }
        }
    }

}
