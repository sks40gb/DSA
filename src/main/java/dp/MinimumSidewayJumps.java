package dp;

import java.util.Arrays;

public class MinimumSidewayJumps {
    public static void main(String[] args) {
//        int[] obstacles = {0, 1, 1, 3, 3, 0};
        int[] obstacles = {0, 2, 1, 0, 3, 0};
        int[][] dp = new int[obstacles.length][3];
        int result = minJumpDP(obstacles,2);
        System.out.println(result);
    }

    private static int minJump(int[] obstacles, int index, int lane) {
        if (index == obstacles.length - 1) {
            return 0;
        }
        if (obstacles[index + 1] != lane) {
            return minJump(obstacles, index + 1, lane);
        } else {
            int min = Integer.MAX_VALUE;
            for (int l = 1; l <= 3; l++) {
                if (l != lane && obstacles[index] != l) {
                    min = Math.min(min, 1 + minJump(obstacles, index, l));
                }
            }
            return min;
        }
    }

    private static int minJumpMem(int[] obstacles, int index, int lane, int[][] dp) {
        if (index == obstacles.length - 1) {
            return 0;
        }
        if (dp[index][lane] != 0) {
            return dp[index][lane];
        }
        if (obstacles[index + 1] != lane) {
            return dp[index][lane] = minJumpMem(obstacles, index + 1, lane, dp);
        } else {
            int min = Integer.MAX_VALUE;
            for (int l = 1; l <= 3; l++) {
                if (l != lane && obstacles[index] != l) {
                    min = Math.min(min, 1 + minJumpMem(obstacles, index, l, dp));
                }
            }
            return dp[index][lane] = min;
        }
    }

    private static int minJumpDP(int[] obstacles, int lane) {

        int n = obstacles.length;
        int[][] dp = new int[n][4];

        for (int index = 0; index < n-1; index++) {
            if (obstacles[index + 1] != lane) {
                dp[index][lane] = dp[index + 1][lane];
            } else {
                int min = Integer.MAX_VALUE;
                for (int l = 1; l <= 3; l++) {
                    if (l != lane && obstacles[index] != l) {
                        dp[index][l] = Math.min(min, 1 + dp[index][l]);
                    }
                }
            }
        }
        return dp[n-1][lane];
    }
}
