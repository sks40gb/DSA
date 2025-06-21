package com.sunil.dsa.categories.dp;

public class P1_FibonacciNumber {

    public static void main(String[] args) {
        P1_FibonacciNumber o = new P1_FibonacciNumber();
        int n = 5;
        System.out.println(o.fib(n));     // Recursive
        System.out.println(o.fibDP(n));   // DP with array
        System.out.println(o.fibSO(n));   // Space-optimized
    }

    // Recursive approach
    private int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // DP with array
    private int fibDP(int n) {
        if (n < 2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Space-optimized DP
    private int fibSO(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int pre2 = 0, pre1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = pre1 + pre2;
            pre2 = pre1;
            pre1 = curr;
        }
        return pre1;
    }
}
