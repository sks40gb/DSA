package windowsldiging.variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest sub-array having sum k
 *
 * Note : This will work only with positive numbers
 *
 * Input : arr[] = { 10, 5, 2, 7, 1, 9 },  k = 15
 * Output : 4
 * The sub-array is {5, 2, 7, 1}
 *
 * Input : arr[] = {-5, 8, -14, 2, 4, 12}, k = -5
 * Output : 5
 */

public class A_LongestSubarray {

    public static void main(String[] args) {
        int[] input = {10, 5, 2, 7, 1, 9};
        int k = 15;
        int maxSize = getLongestSubarray(input, k);
        System.out.println(maxSize);
    }

    private static int getLongestSubarray(int[] input, int k) {
        List<Integer> sumList = new ArrayList<>();
        int max = 0;
        int sum = 0;
        int leftIndex = 0;
        for(int rightIndex=0; rightIndex < input.length; rightIndex++){
            sum += input[rightIndex];
            if(sum == k){
                max = Math.max(max,rightIndex-leftIndex+1);
            }
            while(sum > k && leftIndex <= rightIndex){
                sum -= input[leftIndex];
                leftIndex++;
            }
        }
        return max;
    }
}
