package array;

import util.ArrayUtil;

/**
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 *
 * Approach
 * 1,2,3,4,5,6,7
 * Reverse Array
 * 7,6,5,4,3,2,1
 * Reverse left and right of K
 * 5,6,7 - 1,2,3,4
 */
public class P8_RotateArray {

    public static void main(String[] args) {
        P8_RotateArray o = new P8_RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        o.rotate(nums, k);
        ArrayUtil.print1D(nums);
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // [7,6,5,4,3,2,1]
        reverse(nums, 0, n - 1);

        // [7,6,5,4,3,2,1]
        reverse(nums, 0, k - 1);

        // [7,6,5,4,3,2,1]
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
            begin++;
            end--;
        }
    }


}
