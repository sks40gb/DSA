package practice2;

import java.util.HashMap;
import java.util.Map;

public class KnightDialer2 {
    public static void main(String[] args) {
        int result = new KnightDialer2().knightDialer(3131);
        System.out.println(result);
    }

    public int knightDialer(int n) {
        char[][] keypad = buildKeypad();
        Map<String, Integer> dp = new HashMap<>();
        int totalWays = 0;

        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[i].length; j++) {
                if (keypad[i][j] != '*') {
                    totalWays += findWays(keypad, i, j, n, dp);
                }
            }
        }
        return totalWays;
    }

    private static char[][] buildKeypad() {
        char[][] keypad = new char[4][3];
        keypad[0][0] = '1';
        keypad[0][1] = '2';
        keypad[0][2] = '3';
        keypad[1][0] = '4';
        keypad[1][1] = '5';
        keypad[1][2] = '6';
        keypad[2][0] = '7';
        keypad[2][1] = '8';
        keypad[2][2] = '9';
        keypad[3][0] = '*';
        keypad[3][1] = '0';
        keypad[3][2] = '*';
        return keypad;
    }

    public int findWays(char[][] keypad, int i, int j, int n, Map<String, Integer> dp) {
        if (!canMove(keypad, i, j)) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        String key = i + "_" + j + "_" + n;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int totalWays = 0;
        totalWays += findWays(keypad, i - 2, j - 1, n - 1, dp);
        totalWays += findWays(keypad, i - 2, j + 1, n - 1, dp);
        totalWays += findWays(keypad, i + 2, j - 1, n - 1, dp);
        totalWays += findWays(keypad, i + 2, j + 1, n - 1, dp);
        totalWays += findWays(keypad, i - 1, j - 2, n - 1, dp);
        totalWays += findWays(keypad, i + 1, j - 2, n - 1, dp);
        totalWays += findWays(keypad, i - 1, j + 2, n - 1, dp);
        totalWays += findWays(keypad, i + 1, j + 2, n - 1, dp);

        dp.put(key, totalWays);
        return totalWays;
    }

    private boolean canMove(char[][] keypad, int i, int j) {
        return (i >= 0 && i < keypad.length && j >= 0 && j < keypad[0].length && keypad[i][j] != '*');
    }
}
