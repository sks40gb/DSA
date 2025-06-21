package categories.pattern.a_MinMax;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int result = minPath(grid, 0, 0);
        System.out.println(result);
    }

    private static int minPath(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        int min = Integer.MAX_VALUE;
        int rightMove = minPath(grid, i, j + 1);
        if (rightMove != Integer.MAX_VALUE) {
            min = Math.min(rightMove, min);
        }
        int downMove = minPath(grid, i + 1, j);
        if (downMove != Integer.MAX_VALUE) {
            min = Math.min(downMove, min);
        }
        return min + grid[i][j];
    }
}
