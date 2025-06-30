package com.sunil.dsa.categories.f_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/insert-interval/description/

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class P3_InsertInterval {

    public static void main(String[] args) {
        P3_InsertInterval o = new P3_InsertInterval();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        System.out.println(Arrays.deepToString(o.insert(intervals, newInterval)));
    }


    public int[][] insert(int[][] intervals, int[] newInterval) {

        int i = 0;
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();

        //add all which is less than newIntervals
        while(i < n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }


        // ------- --------- --------- -------------
        //            [0]-------[1]

        //Add overlapping intervals
        while(i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        list.add(newInterval);

        //Add rest of the items
        while(i < n){
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }

}
