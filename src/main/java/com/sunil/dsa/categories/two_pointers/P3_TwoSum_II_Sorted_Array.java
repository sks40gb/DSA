package com.sunil.dsa.categories.two_pointers;

import util.ArrayUtil;

/*

https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

 */
public class P3_TwoSum_II_Sorted_Array {

    public static void main(String[] args) {
        P3_TwoSum_II_Sorted_Array o = new P3_TwoSum_II_Sorted_Array();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        ArrayUtil.print1D(o.twoSum(numbers, target));
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}
