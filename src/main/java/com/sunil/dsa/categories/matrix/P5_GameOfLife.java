package com.sunil.dsa.categories.matrix;

import util.ArrayUtil;

/*
https://leetcode.com/problems/game-of-life/description/

Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 */
public class P5_GameOfLife {

    public static void main(String[] args) {
        P5_GameOfLife o = new P5_GameOfLife();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        o.gameOfLife(board);
        ArrayUtil.print2D(board);
    }

    public void gameOfLife(int[][] board) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                int neighbors = getNeighbors(board, r, c);
//                System.out.println(neighbors + " for cell " + r + "," + c);
                if (Math.abs(board[r][c]) == 1) {
                    if (neighbors < 2 || neighbors > 3) {
                        board[r][c] = -1;
                    }
                } else if (board[r][c] == 0 || board[r][c] == -2) {
                    if (neighbors == 3) {
                        board[r][c] = -2;
                    }
                }
            }
        }

        //convert
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == -1) {
                    board[r][c] = 0;
                } else if (board[r][c] == -2) {
                    board[r][c] = 1;
                }
            }
        }
    }

    private int getNeighbors(int[][] board, int r, int c) {
        int total = 0;
        int[] directions = {1, 0, -1};

        for (int i = 0; i < directions.length; i++) {
            for (int j = 0; j < directions.length; j++) {
                if (!(directions[i] == 0 && directions[j] == 0)) { //not self cell
                    if (isAlive(board, r + directions[i], c + directions[j])) {
                        total++;
                    }
                }
            }
        }
        return total;
    }

    private boolean isAlive(int[][] board, int r, int c) {
        return isWithinBoundary(board, r, c) && Math.abs(board[r][c]) == 1;
    }

    private boolean isWithinBoundary(int[][] board, int r, int c) {
        return (r >= 0 && r < board.length && c >= 0 && c < board[0].length);
    }

}
