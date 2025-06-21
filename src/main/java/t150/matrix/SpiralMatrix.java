package t150.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {

        SpiralMatrix solution = new SpiralMatrix();

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(solution.spiralOrder(matrix1));
        // Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(solution.spiralOrder(matrix2));
        // Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
    }

    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        //move indices
        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;

        while(left <= right && top <= bottom){
            // Move right
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for (int i = right; i >= left ; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i=bottom; i >=top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }

}
