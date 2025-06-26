package com.sunil.dsa.categories.b_two_pointers;

/*

https://leetcode.com/problems/container-with-most-water/description/

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49

 */
public class P4_ContainerWithMostWater {

    public static void main(String[] args) {
        P4_ContainerWithMostWater o = new P4_ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(o.maxArea(height));
    }

    public int maxArea(int[] height) {

        int n = height.length;
        int maxArea = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = h * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
