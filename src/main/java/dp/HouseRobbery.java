package dp;

public class HouseRobbery {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1}; //4
        int[] nums = {2, 7, 9, 3, 1};  //12
        HouseRobbery o = new HouseRobbery();
        System.out.println(o.robRec(nums, nums.length - 1));
        System.out.println(o.robDP(nums));
    }

    public int robRec(int[] nums, int index) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return nums[0];
        }
        int rob = nums[index] + robRec(nums, index - 2);
        int dontRob = robRec(nums, index - 1);
        return Math.max(rob, dontRob);
    }


    public int robMem(int[] nums, int index, int[] dp) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return nums[0];
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int rob = nums[index] + robMem(nums, index - 2, dp);
        int dontRob = robMem(nums, index - 1, dp);
        return dp[index] = Math.max(rob, dontRob);
    }


    public int robDP(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }


    public int robMO(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        int pre2 = nums[0];
        int pre1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
           int current = Math.max(nums[i] + pre2, pre1);
           pre2 = pre1;
           pre1 = current;
        }
        return pre1;
    }
}
