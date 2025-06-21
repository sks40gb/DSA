package practice;

public class OutOfBoundaryPaths {
    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        int maxMove = 2;
        int startRo = 0;
        int startColumn = 0;
        int result = new OutOfBoundaryPaths().findPaths(m, n, maxMove, startRo, startColumn);
        System.out.println(result);
    }

    public int findPaths(int m, int n, int maxMove, int i, int j) {
        int[][] dp = new int[m+n][n+1];
        return findPathsRec(m,n,maxMove,i,j, dp);
    }
    public int findPathsRec(int m, int n, int maxMove, int i, int j, int[][] dp) {
        if (maxMove < 0) {
            return 0;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 1;
        }
        int left = findPathsRec(m, n, maxMove - 1, i, j - 1, dp);
        int right = findPathsRec(m, n, maxMove - 1, i, j + 1, dp);
        int top = findPathsRec(m, n, maxMove - 1, i - 1, j, dp);
        int bottom = findPathsRec(m, n, maxMove - 1, i + 1, j, dp);
        return dp[i][j]=left + right + top + bottom;
    }
}
