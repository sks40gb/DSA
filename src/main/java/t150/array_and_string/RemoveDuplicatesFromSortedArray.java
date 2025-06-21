package t150.array_and_string;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicatesFromSortedArray o = new RemoveDuplicatesFromSortedArray();
        System.out.println(o.removeDuplicates(nums));
        System.out.println("------------------");
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println("--------------------");
    }

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }
}
