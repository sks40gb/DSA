package t150.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        ValidSudoku o = new ValidSudoku();
        System.out.println(o.isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {

        Set<String> list = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col] == '.'){
                    continue;
                }
                String rowKey = row + ":" + board[row][col];
                String colKey = col + ":" + board[row][col];

                int matrix = (row / 3 )* 3 + col / 3;
                String matrixKey = matrix + ":" + board[row][col];
                if (!list.add(rowKey) || !list.add(colKey) || !list.add(matrixKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}
