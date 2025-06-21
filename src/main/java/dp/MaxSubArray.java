package dp;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        int max = maxSubArray4(nums);
        System.out.println(max);
    }

    private static int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            max = Math.max(max, currentMax);
        }
        return max;
    }

    static  int maxSubArray2(int[] nums) {

        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    private static int maxSubArray3(int[] nums) {
        int max = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = 0; end < nums.length; end++) {
                int sum = 0;
                for (int i = start; i <= end ; i++) {
                    sum += nums[i];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private static int maxSubArray4(int[] nums) {
        int max = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum = sum + nums[end];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
