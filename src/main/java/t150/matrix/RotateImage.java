package t150.matrix;

import util.ArrayUtil;

public class RotateImage { public static void main(String[] args) {

    RotateImage solution = new RotateImage();

    int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    ArrayUtil.print2D(matrix);
    System.out.println("---------------");
    solution.rotate(matrix);

    // Print rotated matrix
//    for (int[] row : matrix) {
//        for (int num : row) {
//            System.out.print(num + " ");
//        }
//        System.out.println();
//    }
    // Output:
    // 7 4 1
    // 8 5 2
    // 9 6 3
}

    private void rotate(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        ArrayUtil.print2D(matrix);

        for (int row = 0; row < matrix.length; row++) {
           int l = 0;
           int r = matrix[0].length - 1;
           while(l < r){
               System.out.format("L:%s R:%s", l,r);
               int temp = matrix[row][l];
               matrix[row][l] = matrix[row][r];
               matrix[row][r] = temp;
               l++;
               r--;
           }
        }
        System.out.println("-------------");
        ArrayUtil.print2D(matrix);

    }

}
