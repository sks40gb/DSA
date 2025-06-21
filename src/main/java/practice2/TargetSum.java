package practice2;

public class TargetSum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int result = new TargetSum().findTargetSumWays(nums, target);
        System.out.println(result);
    }

    public int findTargetSumWays(int[] nums, int target) {
        return findSums(nums, target, 0);
    }

    private int findSums(int[] nums, int target, int index) {
        if (index == nums.length && target == 0) {
            return 1;
        }
        if (index >= nums.length) {
            return 0;
        }
        int add = findSums(nums, target - nums[index], index + 1);
        int sub = findSums(nums, target + nums[index], index + 1);
        return add + sub;
    }
}
