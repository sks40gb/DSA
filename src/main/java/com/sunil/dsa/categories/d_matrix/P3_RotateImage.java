package com.sunil.dsa.categories.d_matrix;

import util.ArrayUtil;

/*

https://leetcode.com/problems/rotate-image/description/

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
 */

public class P3_RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        P3_RotateImage o = new P3_RotateImage();
        o.rotate(matrix);
        ArrayUtil.print2D(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose (swap matrix[r][c] and matrix[c][r])
        for (int r = 0; r < n; r++) {
            for (int c = 0; c <= r; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n / 2; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][n - c - 1];
                matrix[r][n - c - 1] = temp;
            }
        }

    }
}
