package practice;

import util.ArrayUtil;

public class Solution {

    public static void main(String[] args) {
        int[][] matrix3 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] matrix4= {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        new Solution().markZeros(matrix4);
        ArrayUtil.print2D(matrix4);
    }

    private void markZeros(int[][] matrix){
        for(int r=0; r < matrix.length; r++){
            for(int c=0; c < matrix[r].length; c++){
                if(matrix[r][c] == 0){
                    markRowZero(matrix,r);
                    markColZero(matrix,c);
                }
            }
        }

        //ArrayUtil.print2D(matrix);
        for(int r=0; r< matrix.length; r++){
            for(int c=0; c< matrix[r].length; c++){
                if(matrix[r][c] == -1){
                    matrix[r][c] = 0;
                }
            }
        }
    }

    private void markRowZero(int[][] matrix, int r){
        for(int c1=0; c1 < matrix[r].length; c1++){
            if(matrix[r][c1] != 0){
                matrix[r][c1] = -1;
            }
        }
    }

    private void markColZero(int[][] matrix, int c){
        for(int r1=0;  r1 < matrix.length; r1++){
            if(matrix[r1][c] != 0){
                matrix[r1][c] = -1;
            }
        }
    }

}