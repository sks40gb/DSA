package practice2;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = new MaxSubArray().maxSubArray(arr);
        System.out.println(result);
    }

    private int maxSubArray(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = getSum(arr, i, j);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    private int getSum(int[] arr, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j ; k++) {
            sum += arr[k];
        }
        return sum;
    }
}
