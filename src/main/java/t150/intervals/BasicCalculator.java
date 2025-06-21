package t150.intervals;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {

        BasicCalculator calc = new BasicCalculator();

        System.out.println(calc.calculate("1 + 1"));           // Output: 2

        System.out.println(calc.calculate(" 2-1 + 2 "));       // Output: 3

        System.out.println(calc.calculate("(1+(4+5+2)-3)+(6+8)")); // Output: 23
        System.out.println(calc.calculate("1-(     -2)")); // Output: 3
    }


    public int minPathSum(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int[][] dp = new int[row][col];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < row; i++) {

            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < col; j++) {

            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int r = 1; r < row; r++) {

            for (int c = 1; c < col; c++) {

                dp[r][c] = grid[r][c] + Math.min(dp[r - 1][c], dp[r][c - 1]);
            }
        }
        return dp[row - 1][col - 1];
    }


    public int solveTab(int n, int[] a) {
        int[][] dp = new int[n + 1][n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {

                int take = 0;
                if (prev == -1 || a[curr] > a[prev]){
                    take = 1 + dp[curr + 1][curr + 1];
                }

                int notTake = dp[curr + 1][prev + 1];

                dp[curr][prev + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }

    public int calculate(String s) {
        int result = 0;
        int sign = 1;
        int num = 0;
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
//                result += stack.pop() * stack.pop();
                result *= stack.pop(); // Apply the sign before '('
                result += stack.pop(); // Add the result before '('
            }
        }
        result += sign * num;
        return result;
    }


}















