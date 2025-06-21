package practice;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2}; //2,1,3 -> 2,3,1
        int[] result = new NextPermutation().solve(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    int[] solve(int[] arr) {
        int ind = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            reverse(arr, 0, arr.length-1);
            return arr;
        }
        //get next big number and swap
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[ind] < arr[i]) {
                int temp = arr[ind];
                arr[ind] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        //revere half
        reverse(arr, ind + 1, arr.length - 1);
        return arr;
    }

    private void reverse(int[] arr, int start, int end) {
      while(start < end){
          int temp = arr[start];
          arr[start]= arr[end];
          arr[end] = temp;
          start++;
          end--;
      }
    }
}
