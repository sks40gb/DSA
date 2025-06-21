package practice;

public class PartitionEqualSubsetSum {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5, 1};
        boolean result = new PartitionEqualSubsetSum().canPartition(arr);
        System.out.println(result);
    }

    private boolean canPartition(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        return isFeasible(arr, 0, sum / 2);
    }

    private boolean isFeasible(int[] arr, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index >= arr.length || target < 0) {
            return false;
        }
        boolean pick = isFeasible(arr, index + 1, target - arr[index]);
        boolean dontPick = isFeasible(arr, index + 1, target);
        return pick || dontPick;
    }
}
