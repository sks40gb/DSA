package com.sunil.dsa.categories.array;

/**
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 */
public class P4_RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        P4_RemoveDuplicatesFromSortedArrayII o = new P4_RemoveDuplicatesFromSortedArrayII();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(o.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int counter = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                counter = 1;
                slow++;
            } else if (counter == 1) {
                nums[slow + 1] = nums[fast];
                counter = 2;
                slow++;
            }
        }
        return slow + 1;
    }
}
