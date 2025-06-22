package com.sunil.dsa.categories.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

https://leetcode.com/problems/3sum/description/

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 */
public class P5_3Sum {

    public static void main(String[] args) {
        P5_3Sum o = new P5_3Sum();
        List<List<Integer>> result = o.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates and use two-pointer approach

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            twoSum(nums, target, i + 1, result);
        }
        return result;
    }

    private void twoSum(int[] nums, int target, int startIndex, List<List<Integer>> result) {
        int first = -target;
        int left = startIndex;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result.add(Arrays.asList(first, nums[left], nums[right]));

                // Skip duplicates for left and right
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }

                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
