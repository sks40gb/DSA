package t150.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        SummaryRanges solution = new SummaryRanges();

        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(solution.summaryRanges(nums1));
        // Output: ["0->2", "4->5", "7"]

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(solution.summaryRanges(nums2));
        // Output: ["0", "2->4", "6", "8->9"]
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int leftIndex =0;
        int n = nums[0];
        for (int rightIndex = 1; rightIndex < nums.length; rightIndex++) {
            if(nums[rightIndex-1] + 1 != nums[rightIndex]){
                if(leftIndex == rightIndex-1){
                    result.add(String.valueOf(nums[leftIndex]));
                }else{
                    result.add(String.format("%s->%s", nums[leftIndex], nums[rightIndex-1]));
                }
                leftIndex = rightIndex;
            }
        }
        if(leftIndex == nums.length-1){
            result.add(String.valueOf(nums[leftIndex]));
        }else{
            result.add(String.format("%s->%s", nums[leftIndex], nums[nums.length-1]));
        }
        return result;
    }

}
