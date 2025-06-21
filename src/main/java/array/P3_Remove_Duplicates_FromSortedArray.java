package array;

public class P3_Remove_Duplicates_FromSortedArray {

    public static void main(String[] args) {
        P3_Remove_Duplicates_FromSortedArray o = new P3_Remove_Duplicates_FromSortedArray();
        int[] nums = {1, 1, 2};
        System.out.println(o.removeDuplicates(nums));
    }


    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }
        return slow + 1;
    }
}
