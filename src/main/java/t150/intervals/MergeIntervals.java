package t150.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {


    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[][]{};
        }
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int[] currInterval = intervals[0];

        for(int i=0; i < intervals.length; i++){
            int[] interval = intervals[i];
            if(currInterval[1] >= interval[0]){
                currInterval[1] = Math.max(currInterval[1], interval[1]);
            }else{
                list.add(currInterval);
                currInterval = interval;
            }
        }
        list.add(currInterval);
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {

        MergeIntervals solution = new MergeIntervals();

        int[][] intervals1 = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println(Arrays.deepToString(solution.merge(intervals1)));
        // Output: [[1,6], [8,10], [15,18]]

        int[][] intervals2 = {{1,4}, {4,5}};
        System.out.println(Arrays.deepToString(solution.merge(intervals2)));
        // Output: [[1,5]]
    }

}
