package util;

public class ArrayUtil {

    public static void print2D(Integer[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void print2D(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void print1D(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public static void print1D(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public static void print1D(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }
}
