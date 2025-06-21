package categories.pattern.a_MinMax;

public class MaximumSquare {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(new MaximumSquare().maximalSquare(matrix)); // Output: 4
    }

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1'){
                    max = Math.max(max, mx(matrix, i, j));
                }
            }
        }
        return max*max;
    }

    private static int mx(char[][] matrix, int i, int j) {
        if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') {
            return 0;
        }
        int right = mx(matrix, i, j + 1) + 1;
        int bottom = mx(matrix, i + 1, j) + 1;
        int diagonal = mx(matrix, i + 1, j + 1) + 1;
//        int right = mx(matrix, i, j + 1) ;
//        int bottom = mx(matrix, i + 1, j) ;
//        int diagonal = mx(matrix, i + 1, j + 1);
        return  Math.min(right, Math.min(bottom, diagonal)) + 1;
    }

}
