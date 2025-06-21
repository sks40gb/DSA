package practice;

public class Test {

    /*
    [1, 1, 1, 1, 1]
    [1, 1, 1, 2]
    [1, 2, 2]
    [1, 1, 3]
    [5]
     */
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        int k = 5;
        coinChange(arr, k, 0, 0, "");
    }

    private static void coinChange(int[] arr, int k, int index, int total, String result) {
        if (total == k) {
            System.out.println(result);
            return;
        }
        if(total > k){
            return;
        }
        if (index >= arr.length) {
            return;
        }
        coinChange(arr, k, index, total + arr[index], result + " " + arr[index]);
        coinChange(arr, k, index + 1, total, result);
    }
}
