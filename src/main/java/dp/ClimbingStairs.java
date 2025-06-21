package dp;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 6;
        ClimbingStairs o = new ClimbingStairs();
        System.out.println(o.climbStairsRec(n));
        System.out.println(o.climbStairsDP(n));
        System.out.println(o.climbStairsMO(n));
    }

    public int climbStairsRec(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbStairsRec(n - 1) + climbStairsRec(n - 2);
    }

    public int climbStairsDP(int n) {
        if (n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairsMO(int n) {
        if (n == 1) {
            return n;
        }
        int pre2 = 1;
        int pre1 = 2;
        for (int i = 3; i <= n; i++) {
            int current = pre1 + pre2;
            pre2 = pre1;
            pre1 = current;
        }
        return pre1;
    }


}
