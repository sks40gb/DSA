package com.sunil.dsa.categories.d_matrix;

import util.ArrayUtil;

/*
https://leetcode.com/problems/set-matrix-zeroes/description/

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

 */
public class P4_SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        P4_SetMatrixZeroes o = new P4_SetMatrixZeroes();
        o.setZeroes(matrix);
//        o.setZeroes1(matrix);

        ArrayUtil.print2D(matrix);
    }

    public void setZeroes(int[][] matrix) {
        int row0 = 1;

        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[0][c] == 0) {
                row0 = 0;
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    if (matrix[r][c] == 0) {
                        matrix[0][c] = 0;
                        matrix[r][0] = 0;
                    }
                }
            }
        }

        for (int c = 0; c < matrix[0].length; c++) {
            if(matrix[0][c] == 0){
                for(int r=1; r < matrix.length; r++){
                    matrix[r][c] = 0;
                }
            }
        }

        if(row0 == 0){
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }

        for(int r=1; r < matrix.length; r++){
            if(matrix[r][0] == 0){
                for(int c =0; c < matrix[0].length; c++){
                    matrix[r][c] = 0;
                }
            }
        }
    }


    public void setZeroes1(int[][] matrix) {

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    setToMinus(matrix, r, c);
                }
            }
        }

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == -1) {
                    matrix[r][c] = 0;
                }
            }
        }
    }

    private void setToMinus(int[][] matrix, int row, int col) {
        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][col] != 0) {
                matrix[r][col] = -1;
            }
        }

        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[row][c] != 0) {
                matrix[row][c] = -1;
            }
        }
    }
}
