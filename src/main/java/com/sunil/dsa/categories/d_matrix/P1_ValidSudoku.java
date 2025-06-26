package com.sunil.dsa.categories.d_matrix;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/valid-sudoku/
 */
public class P1_ValidSudoku {

    public static void main(String[] args) {
        P1_ValidSudoku o = new P1_ValidSudoku();
        char[][] sudoku = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(o.isValidSudoku(sudoku));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char v = board[r][c];
                if (v == '.') {
                    continue;
                }

                String rowKey = "R" + r + "_" + v;
                String colKey = "C" + c + "_" + v;
                int box = (r / 3) * 3 + (c / 3); // corrected box number
                String boxKey = "B" + box + "_" + v;

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}
