package dp2;

/**
 * https://www.naukri.com/code360/problems/nth-fibonacci-number_74156
 */
public class P2_CountWaysToReach {

    public static void main(String[] args) {
        P2_CountWaysToReach o = new P2_CountWaysToReach();
        int stairs = 5;
        System.out.println(o.solve(stairs));
        System.out.println(o.solveDP(stairs));
        System.out.println(o.solveSO(stairs));
    }

    private int solve(int stairs) {
        if (stairs < 0) {
            return 0;
        }
        if (stairs == 0) {
            return 1;
        }
        return solve(stairs - 1) + solve((stairs - 2));
    }

    private int solveDP(int stairs) {
        int[] dp = new int[stairs + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= stairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[stairs];
    }

    private int solveSO(int stairs) {
        int pre1 = 1;
        int pre2 = 1;
        for (int i = 2; i <= stairs; i++) {
            int temp = pre1;
            pre1 = pre1 + pre2;
            pre2 = temp;
        }
        return pre1;
    }
}
