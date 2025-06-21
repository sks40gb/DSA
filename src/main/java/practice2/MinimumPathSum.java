package practice2;

public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum o = new MinimumPathSum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(o.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        return minPath(grid, 0, 0);
    }

    private int minPath(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        int right = minPath(grid, i + 1, j);
        int bottom = minPath(grid, i, j+1);
        return Math.min(right, bottom) + grid[i][j];
    }
}



