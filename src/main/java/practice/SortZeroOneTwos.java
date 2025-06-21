package practice;

import util.ArrayUtil;

public class SortZeroOneTwos {

    /**
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     */
    public static void main(String[] args) {

        int[] arr = {2,0,2,1,1,0,1,2,0,0,0,1,2,1,0,2,1};
        new SortZeroOneTwos().solve(arr);
        ArrayUtil.print1D(arr);
    }

    private void solve(int[] arr){

        int low = 0;
        int mid = 0;
        int high = arr.length-1;

        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }else{
                swap(arr, mid, high);
                high--;
            }
        }

    }

    private void swap(int[] arr, int from, int to){
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
