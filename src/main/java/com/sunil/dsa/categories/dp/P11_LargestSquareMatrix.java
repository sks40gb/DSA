package com.sunil.dsa.categories.dp;

public class P11_LargestSquareMatrix {

    public static void main(String[] args) {
        P11_LargestSquareMatrix o = new P11_LargestSquareMatrix();
        int[][] mat = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(o.maxSquare(mat));
        System.out.println(o.maxSquareDP(mat));
    }

    int maxSquare(int mat[][]) {
        int max = 0;
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[0].length; c++) {
                max = Math.max(max, maxSquare(mat, r, c));
            }
        }
        return max;
    }

    int maxSquare(int mat[][], int row, int col) {
        if (row >= mat.length || col >= mat[0].length) {
            return 0;
        }
        if (mat[row][col] == 0) {
            return 0;
        }
        int right = maxSquare(mat, row + 1, col);
        int bottom = maxSquare(mat, row, col + 1);
        int diagonal = maxSquare(mat, row + 1, col + 1);
        return Math.min(right, Math.min(bottom, diagonal)) + mat[row][col];
    }

    static int maxSquareDP(int mat[][]) {
        int m = mat.length;
        int n = mat[0].length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (mat[r][c] == 1) {
                    int right = dp[r + 1][c];
                    int bottom = dp[r][c + 1];
                    int diagonal = dp[r + 1][c + 1];
                    dp[r][c] = Math.min(right, Math.min(bottom, diagonal)) + 1;
                    max = Math.max(max, dp[r][c]);
                }
                // If mat[r][c] == 0, dp[r][c] remains 0 (default value)
            }
        }

        return max;
    }


}
