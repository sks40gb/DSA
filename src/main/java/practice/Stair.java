package practice;

import java.util.Arrays;

public class Stair {
    public static void main(String[] args) {
        int n = 2;
        int result = new Stair().climbStairs(n);
        System.out.println(result);
    }

    /**
     * Hello How are you ?
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return steps(n,dp);
    }

    public int steps(int n, int[] dp) {
        if(dp[n] != -1){
            return dp[n];
        }
        if(n == 1 || n == 2){
            dp[n] = n;
            return n;
        }
        return  dp[n] = steps(n-1, dp) + steps(n-2, dp);
    }
}
