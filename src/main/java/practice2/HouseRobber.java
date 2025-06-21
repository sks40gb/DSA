package practice2;

import java.util.Arrays;

public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber o = new HouseRobber();
        System.out.println(o.rob(new int[]{1, 2, 3, 1})); //4
        System.out.println(o.rob(new int[]{2, 7, 9, 3, 1})); //12
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return robRec(nums, nums.length - 1, dp);
    }

    private int robRec(int[] nums, int index, int[] dp) {
        if (index < 0) {
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int rob = robRec(nums, index - 2, dp) + nums[index];
        int dontRob = robRec(nums, index - 1, dp);
        return dp[index] = Math.max(rob, dontRob);
    }

}
