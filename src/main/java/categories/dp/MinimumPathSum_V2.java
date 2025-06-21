package categories.dp;

public class MinimumPathSum_V2 {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int result = new MinimumPathSum_V2().minPathSum(grid);
        System.out.println(result);
    }

    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        //base code
        dp[0][0] = grid[0][0];

        //update first row
        for (int i = 1; i < n; i++) {
            dp[0][i] =  dp[0][i-1] + grid[0][i];
        }

        //update the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] =  Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

}
