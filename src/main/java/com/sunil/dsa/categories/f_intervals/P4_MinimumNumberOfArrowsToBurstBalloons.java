package com.sunil.dsa.categories.f_intervals;

import java.util.Arrays;

/*
https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

Example 1:
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

Example 2:
Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
 */
public class P4_MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
        P4_MinimumNumberOfArrowsToBurstBalloons o = new P4_MinimumNumberOfArrowsToBurstBalloons();
        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(o.findMinArrowShots(points1));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b)-> Integer.compare(a[1], b[1]));
        int[] current = points[0];
        int arrow = 1;

        for(int i=1; i< points.length; i++ ){
            if(points[i][0] > current[1]){
                arrow++;
                current = points[i];
            }
        }
        return arrow;
    }

}
