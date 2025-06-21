package dp;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum o = new MinimumPathSum();
        int result = o.minPathSum(grid);
        System.out.println(result);
        System.out.println(o.solveDP(grid));
    }

    public int minPathSum(int[][] grid) {
//        return solve(grid, 0, 0);
        return solve2(grid, grid.length - 1, grid[0].length - 1);
    }

    private int solve(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if (r == m - 1 && c == n - 1) {
            return grid[r][c];
        }
        if (r >= m || c >= n) {
            return Integer.MAX_VALUE;
        }
        int right = solve(grid, r + 1, c);
        int down = solve(grid, r, c + 1);
        return grid[r][c] + Math.min(right, down);
    }

    private int solve2(int[][] grid, int r, int c) {
        if (r == 0 && c == 0) {
            return grid[r][c];
        }
        if (r < 0 || c < 0) {
            return Integer.MAX_VALUE;
        }
        int right = solve2(grid, r - 1, c);
        int down = solve2(grid, r, c - 1);
        return grid[r][c] + Math.min(right, down);
    }

    private int solveDP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = grid[0][0];

        //fill the first row
        for (int c = 1; c < n; c++) {
            dp[0][c] = dp[0][c - 1] + grid[0][c];
        }

        //fill the first column
        for (int r = 1; r < m; r++) {
            dp[r][0] = dp[r - 1][0] + grid[r][0];
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] = grid[r][c] + Math.min(dp[r - 1][c], dp[r][c - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }


}
