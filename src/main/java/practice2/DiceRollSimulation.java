package practice2;

import java.util.Arrays;

public class DiceRollSimulation {
    public static void main(String[] args) {
        int n = 2;
        int[] rollMax = {1, 1, 2, 2, 2, 3};
//        int n = 20;
//        int[] rollMax = {8,5,10,8,7,2};
        int result = new DiceRollSimulation().dieSimulator(n, rollMax);
        System.out.println(result);
    }

    public int dieSimulator(int n, int[] rollMax) {
        int[][][] dp = new int[n + 1][rollMax.length + 1][17];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return numbersAllowed(n, rollMax, 0, 1, dp);
    }

    public int numbersAllowed(int n, int[] rollMax, int preNumber, int count, int[][][] dp) {
//        System.out.printf("Count for number %s is %s", preNumber, count);
//        System.out.println(result);
        // System.out.println();
        if (count == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if (dp[n][preNumber][count] != -1) {
            return dp[n][preNumber][count];
        }

        int max = 0;
        for (int i = 0; i < rollMax.length; i++) {
            int number = i + 1;
            int maxCount = rollMax[i];
            //If number matches with pre number
            if (number == preNumber) {
                max += numbersAllowed(n - 1, rollMax, number, count - 1, dp);
            } else {
                max += numbersAllowed(n - 1, rollMax, number, maxCount, dp);
            }
        }
        max = max % 1_000_000_007;
        if(max < 0){
            max += 1_000_000_007;
        }
        return dp[n][preNumber][count] = max;
    }

}











