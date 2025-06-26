package com.sunil.dsa.categories.d_matrix;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/spiral-matrix/description/

Input: matrix = [[1,2,3],
                [4,5,6],
                [7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
 */
public class P2_SpiralMatrix {

    public static void main(String[] args) {

        P2_SpiralMatrix o = new P2_SpiralMatrix();
        int[][] matrix =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        System.out.println(o.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        int RIGHT = 0;
        int BOTTOM = 1;
        int LEFT = 2;
        int UP = 3;

        int direction = RIGHT;
        List<Integer> list = new ArrayList<>();

        while (left <= right && top <= bottom) {
            if (direction == RIGHT) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
                direction = BOTTOM;
            } else if (direction == BOTTOM) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
                direction = LEFT;
            } else if (direction == LEFT) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
                direction = UP;
            } else if(direction == UP) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
                direction = RIGHT;
            }
        }
        return list;
    }
}
