package t150.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {


    public static void main(String[] args) {

        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums1));
        // Output: 4 (1,2,3,4)

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solution.longestConsecutive(nums2));
        // Output: 9 (0,1,2,3,4,5,6,7,8)

    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int n : nums){
            list.add(n);
        }
        int max = 0;
        for(int n : nums){
            if(map.containsKey(n)){
                max = Math.max(max,map.get(n));
            }else{
                int mx = getMaxLength(n, list);
                max = Math.max(max,mx);
                map.put(n, max);
            }

        }
        return max;
    }

    private int getMaxLength(int n, List<Integer> list) {
        int counter = 1;
        while(true){
            if(list.contains(n-1)){
                counter++;
                n = n-1;
            }else{
                break;
            }
        }
        return counter;
    }


}
