package t150.array_and_string;

import util.ArrayUtil;

public class RotateArray {

    public static void main(String[] args) {
        RotateArray o = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        o.rotate(nums, k);
        ArrayUtil.print1D(nums);
    }

    public void rotate(int[] nums, int k) {
        // Ensures k is within nums boundary
        k = k % nums.length;

        // [7,6,5,4,3,2,1]
        reverse(nums, 0, nums.length - 1);
        // [7,6,5,4,3,2,1]
        reverse(nums, 0, k-1);
        // [7,6,5,4,3,2,1]
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
