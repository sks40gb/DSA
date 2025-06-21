package com.sunil.dsa.patterns.windowsldiging.fixed;

/**
 * Find maximum (or minimum) sum of a subarray of size k
 *
 * Input  : arr[] = {100, 200, 300, 400}
 * k = 2
 * Output : 700
 *
 * Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
 * k = 4
 * Output : 39
 * We get maximum sum by adding subarray {4, 2, 10, 23}
 * of size 4.
 *
 * Input  : arr[] = {2, 3}
 * k = 3
 * Output : Invalid
 * There is no subarray of size 3 as size of whole
 * array is 2.
 */

public class D_MaximumSumOfSubarray {

    public static void main(String[] args) {
        int[] input = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int maxSum = getMaxSum(input,k);
        System.out.println(maxSum);
    }

    private static int getMaxSum(int[] input, int k){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += input[i];
        }
        max = sum;
        for(int i=k; i < input.length; i++){
            sum -= input[i-k];
            sum += input[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
