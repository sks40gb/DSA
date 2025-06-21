
package t150.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

        InsertInterval solution = new InsertInterval();

        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        System.out.println(java.util.Arrays.deepToString(solution.insert(intervals1, newInterval1)));

        // Output: [[1,5], [6,9]]
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
      //  System.out.println(java.util.Arrays.deepToString(solution.insert(intervals2, newInterval2)));
        // Output: [[1,2], [3,10], [12,16]]
    }

    private int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) { // {{1, 3}, {6, 9}};
            int[] interval = intervals[i]; //{6, 9}
            if(newInterval[0] < interval[1]){ // {6, 9} - {1,5}
                newInterval[0] = interval[0];//Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]); //{1,5}
            }else{
                list.add(interval);
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }


}






