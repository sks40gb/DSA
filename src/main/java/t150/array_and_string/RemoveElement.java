package t150.array_and_string;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 2;
        RemoveElement o = new RemoveElement();
        int result = o.removeElement(nums, val);
        System.out.println(result);
    }

    public int removeElement(int[] nums, int val) {
        int swapIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                swap(nums, swapIndex, i);
                swapIndex--;
            }
        }
        return swapIndex + 1;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
