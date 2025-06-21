package practice;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        Integer[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<Integer[]> mergedList = merge(intervals);
        ArrayUtil.print2D(intervals);
        System.out.println("----");
        mergedList.forEach(arr->{
            System.out.println();
            ArrayUtil.print1D(arr);
        });
    }

    private static List<Integer[]> merge(Integer[][] intervals) {
        List<Integer[]> list = new ArrayList<>();
        Arrays.sort(intervals, (first, second) -> {
            if(first[0].equals(second[0])){
                return Integer.compare(first[1], second[1]);
            }
            return  Integer.compare(first[0], second[0]);
        });

        Integer[] lastArr = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            Integer[] arr = intervals[i];
            if(arr[0] <= lastArr[1]){
                lastArr[1] = arr[1];
            }else{
                list.add(lastArr);
                lastArr = arr;
            }
        }
        list.add(lastArr);
        return list;
    }
}
