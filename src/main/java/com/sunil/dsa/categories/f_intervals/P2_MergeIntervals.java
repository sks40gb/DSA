package com.sunil.dsa.categories.f_intervals;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/merge-intervals/description/

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class P2_MergeIntervals {

    public static void main(String[] args) {
        P2_MergeIntervals o = new P2_MergeIntervals();
        int[][] nums = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] result = o.merge(nums);
        ArrayUtil.print2D(result);
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        int[] current = intervals[0];
        for(int i=1; i < intervals.length; i++){
            int[] next = intervals[i];
            if(current[1] >= next[0]){
                current[1] =  Math.max(current[1],next[1]);
            }else{
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);
        return merged.toArray(new int[merged.size()][]);
    }
}
