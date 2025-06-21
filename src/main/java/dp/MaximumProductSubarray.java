package dp;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int result = maxProduct(nums);
        System.out.println(result);
    }

    private static int maxProduct(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxProduct = max * nums[i];
            int minProduct = min * nums[i];
            min = Math.min(min, Math.min(maxProduct, minProduct));
            max = Math.max(max, Math.max(maxProduct, minProduct));
            result = Math.max(result, max);
        }
        return result;
    }
}
