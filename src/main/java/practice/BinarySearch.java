package practice;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int k = 5;
        int result1 = new BinarySearch().find1(arr, k, 0, arr.length - 1);
        int result2 = new BinarySearch().find2(arr, k, 0, arr.length - 1);
        System.out.format("[%s], [%s]", result1, result2);
    }

    private int find1(int[] arr, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if (k < arr[mid]) {
            return find1(arr, k, start, mid - 1);
        } else {
            return find1(arr, k, mid + 1, end);
        }
    }

    private int find2(int[] arr, int k, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (k < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
