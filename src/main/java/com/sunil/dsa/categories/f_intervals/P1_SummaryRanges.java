package com.sunil.dsa.categories.f_intervals;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/summary-ranges/description/

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Example 2:
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
 */
public class P1_SummaryRanges {

    public static void main(String[] args) {
        P1_SummaryRanges o = new P1_SummaryRanges();
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(o.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                if (start == i) {
                    result.add(String.valueOf(nums[i]));
                } else {
                    result.add(nums[start] + "->" + nums[i]);
                }
                start = i + 1;
            }
        }
        return result;
    }
}
