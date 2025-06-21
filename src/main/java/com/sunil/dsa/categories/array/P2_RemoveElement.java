package com.sunil.dsa.categories.array;

public class P2_RemoveElement {

    public static void main(String[] args) {
        P2_RemoveElement o = new P2_RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(o.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

}
