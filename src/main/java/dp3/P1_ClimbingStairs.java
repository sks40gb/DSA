package dp3;

public class P1_ClimbingStairs {
    public static void main(String[] args) {
        P1_ClimbingStairs o = new P1_ClimbingStairs();
        int n = 3;
        System.out.println(o.climbStairs(n));
        System.out.println(o.climbStairsDP(n));

    }

    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairsDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
