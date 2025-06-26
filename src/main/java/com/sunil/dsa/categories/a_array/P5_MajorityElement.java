package com.sunil.dsa.categories.a_array;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: nums = [3,2,3]
 * Output: 3
 */
public class P5_MajorityElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        P5_MajorityElement o = new P5_MajorityElement();
        System.out.println(o.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int counter = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                counter++;
            }else{
                counter--;
                if(counter == 0){
                    num = nums[i];
                    counter++;
                }
            }
        }
        return num;
    }

    public int majorityElement_v1(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCnt = 0;
        int maxNum = nums[0];
        for (int num : nums) {
            int cnt = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, cnt);
            if (cnt > maxCnt) {
                maxCnt = cnt;
                maxNum = num;
            }
        }
        return maxNum;
    }
}

