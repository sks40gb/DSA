package practice;

import util.ArrayUtil;

public class MatrixRotationClockWise {
    /*
    Example 1:

    Input: [[1,2,3],[4,5,6],[7,8,9]]

    Output: [[7,4,1],[8,5,2],[9,6,3]]

    Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix.

    Example 2:

    Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]

    Output:[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

    Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix
     */

    public static void main(String[] args) {
        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] matrix4 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int[][] result = new MatrixRotationClockWise().rotate2(matrix4);
        ArrayUtil.print2D(result);
    }

    private int[][] rotate1(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int row=0; row < matrix.length; row++){
            for(int col=0; col < matrix[0].length; col++){
                //result[(matrix.length-col-1)][row] = matrix[row][col];
                result[col][(matrix.length-row-1)] = matrix[row][col];
                System.out.format("(%s,%s) - (%s,%s)", row, col, (col), (matrix.length-row-1));
                System.out.println();
            }
            System.out.println("-------------");
        }
        return result;
    }


    private int[][] rotate2(int[][] matrix){

        //transform row to col
        for(int row=1; row < matrix.length; row++){
            for(int col=0; col < row; col++){
                int temp = matrix[row][col];
                matrix[row][col] =matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        //reverse each row
        for(int row =0; row < matrix.length; row++){
            reverse(matrix[row]);
        }
        return matrix;
    }

    private void reverse(int[] arr){
        for(int i=0; i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }

}
