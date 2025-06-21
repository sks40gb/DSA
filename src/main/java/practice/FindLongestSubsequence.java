package practice;

public class FindLongestSubsequence {

    public static void main(String[] args) {
        int[] input = {0,1,0,3,2,3, 8, 12,3,19};
        System.out.println(findLongest(input, 0, Integer.MIN_VALUE));

    }

    private static int findLongest(int[] arr, int index, int prev) {
        if (index == arr.length) {
            return 0;
        }
        int take = 0;
        int dontTake = 0;
        if (arr[index] > prev) {
            take = 1 + findLongest(arr, index + 1, arr[index]);
        }
        dontTake = findLongest(arr, index + 1, prev);
        return Math.max(take, dontTake);
    }

}
