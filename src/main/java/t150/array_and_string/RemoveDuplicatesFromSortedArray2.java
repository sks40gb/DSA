package t150.array_and_string;

import util.ArrayUtil;

public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        RemoveDuplicatesFromSortedArray2 o = new RemoveDuplicatesFromSortedArray2();
        System.out.println(o.removeDuplicates(nums));
        ArrayUtil.print1D(nums);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int insertPos = 1; // Position to insert the next valid element
        int count = 1; // Count of occurrences of the current element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1; // Reset count for a new element
            }
            if (count <= 2) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        return insertPos;
    }

}
