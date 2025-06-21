package categories.dp;

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int result = new MinimumPathSum().minPathSum(grid);
        System.out.println(result);
    }

    public int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return move(grid, 0, 0, memo);
    }

    public int move(int[][] grid, int i, int j, int[][] memo) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] > -1) {
            return memo[i][j];
        }
        int value = grid[i][j];
        return memo[i][j] = value + Math.min(move(grid, i + 1, j, memo), move(grid, i, j + 1, memo));
    }

}
