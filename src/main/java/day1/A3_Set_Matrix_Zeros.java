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
public class A3_Set_Matrix_Zeros {

    public static void main(String[] args) {

        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        new A3_Set_Matrix_Zeros().solve(matrix);
        ArrayUtil.print2D(matrix);
    }

    private void solve(int[][] matrix) {
        //rows = matrix[row][...]
        //cols = matrix[...][col]
        //col0

        int col0 = matrix[0][0];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    if(col == 0){
                        col0 = 0;
                    }else{
                        matrix[0][col] = 0;
                    }
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

        if(matrix[0][0] == 0){
            for(int col = 1; col < matrix[0].length; col++){
                matrix[0][col] = 0;
            }
        }
        if(col0 == 0){
            for(int row = 0; row < matrix.length; row++){
                matrix[row][0] = 0;
            }
        }
    }

}
