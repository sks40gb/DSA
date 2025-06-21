package com.sunil.dsa.categories.dp;

public class P16_RussianDollEnvelopes {

    public static void main(String[] args) {
        P16_RussianDollEnvelopes o = new P16_RussianDollEnvelopes();
        int[][] nums = {
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };
        System.out.println(o.russianDoll(nums, nums.length - 1, nums.length - 2));
    }

    private int russianDoll(int[][] nums, int pre, int cur) {
        if (cur < 0) {
            return 0;
        }
        int max = 0;

        //Take
        if (nums[cur][0] < nums[pre][0] && nums[cur][1] < nums[pre][1]) {
            max = 1 + Math.max(max, russianDoll(nums, cur, cur + 1));
        }
        //DontTake
        max = Math.max(max, russianDoll(nums, pre, cur + 1));

        return max;
    }

}
