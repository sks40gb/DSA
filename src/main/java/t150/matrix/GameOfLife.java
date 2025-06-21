package t150.matrix;

public class GameOfLife {

    public void gameOfLife(int[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                //cell
                markLiveOrDead(board, row, col);
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == -1) {
                    board[row][col] = 0;
                } else if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
            }
        }
    }

    private void markLiveOrDead(int[][] board, int row, int col) {
        int[] directions = {-1, 0, 1};
        int liveCount = 0;
        for (int xd : directions) {
            for (int yd : directions) {
                if (xd == 0 && yd == 0) {
                    continue;
                }
                int r = row + yd;
                int c = col + xd;
                if (isWithinRange(board, row, r, c)) {
                    if (Math.abs(board[r][c]) == 1) {
                        liveCount++;
                    }
                }
            }
        }

        //apply rules
        int v = board[row][col];
        if (v == 1 && (liveCount < 2 || liveCount > 3)) {
            board[row][col] = -1;
        }
        if (v == 0 && liveCount == 3) {
            board[row][col] = 2;
        }
    }

    private boolean isWithinRange(int[][] board, int row, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[row].length;
    }

    public static void main(String[] args) {
        GameOfLife solution = new GameOfLife();

        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};

        solution.gameOfLife(board);
        // Print updated board
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Output:
        // 0 0 0
        // 1 0 1
        // 0 1 1
        // 0 1 0

    }


}
