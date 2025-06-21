package practice2;

public class NumberOfWaysToStayInSamePlace {

    public static void main(String[] args) {
        int result = new NumberOfWaysToStayInSamePlace().numWays(4, 2);
        System.out.println(result);
    }

    public int numWays(int steps, int arrLen) {
        return ways(steps, arrLen, 0);
    }

    private int ways(int steps, int arrLen, int current) {
        if (steps == 0 && current == 0) {
            return 1;
        }
        if (steps < 0 || current > arrLen - 1 || current < 0) {
            return 0;
        }
        int left = ways(steps - 1, arrLen, current - 1);
        int right = ways(steps - 1, arrLen, current + 1);
        int stay = ways(steps - 1, arrLen, current);
        return left + right + stay;
    }
}
