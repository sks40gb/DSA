package practice;

import util.ArrayUtil;

public class NQueen {

    public static void main(String[] args) {
        int n = 5;
        board(n);
    }

    private static void board(int n) {
        int[][] board = new int[n][n];
        if (dfs(board, 0)) {
            ArrayUtil.print2D(board);
            System.out.println("---------------");
        }
    }

    private static boolean dfs(int[][] board, int r) {
        int n = board.length;
        if (r >= n) {
            return true;
        }
        for (int c = 0; c < n; c++) {
            if (isSafe(board, r,c)) {
                //System.out.format("placed [%s][%s]", r, c);
                board[r][c] = 1;
                if(dfs(board, r + 1)){
                    return  true;
                }
                board[r][c] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int r, int c) {
        for (int i = 0; i < board.length; i++) {
            if (board[r][i] == 1 || board[i][c] == 1) {
                return false;
            }
        }
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = r, j = c; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
