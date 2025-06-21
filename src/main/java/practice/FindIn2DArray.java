package practice;

public class FindIn2DArray {

    public static void main(String[] args) {
        int[][] matrix4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int k = 6;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println("1D search -->" + new FindIn2DArray().findIn1D(arr, k, 0, arr.length-1));
        int n = matrix4.length * matrix4[0].length;
        int[] result = new FindIn2DArray().findIn2D(matrix4, k, 0, n - 1);
        System.out.format("start %s, end %s", result[0], result[1]);

    }

    private int findIn1D(int[] arr, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end)/2; // start + (end - start) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if (k < arr[mid]) {
            return findIn1D(arr, k, start, mid);
        } else {
            return findIn1D(arr, k, mid + 1, end);
        }
    }

    private int[] findIn2D(int[][] matrix, int k, int start, int end) {
        System.out.println();
        if (start >= end) {
            return new int[]{-1, -1};
        }
        int mid = (start + end)/2;
        int row = mid / matrix.length;
        int col = mid / matrix[0].length;
        if (matrix[row][col] == k) {
            return new int[]{row, col};
        }
        if (k < matrix[row][col]) {
            return findIn2D(matrix, k, start, mid);
        } else {
            return findIn2D(matrix, k, mid + 1, end);
        }
    }

}
