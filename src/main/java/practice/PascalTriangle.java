package practice;

public class PascalTriangle {

    public static void main(String[] args) {
        int n = 5;
        new PascalTriangle().solve(5);
    }

    private void solve(int n){
        int[] arr = new int[0];
        for(int i=0; i < n; i++){
            int left = 0;
            int right = i;

            int[] cArr = new int[i+1];
            cArr[left] = 1;
            cArr[right] = 1;
            left++;
            right--;

            while(left <= right){
                cArr[left] = arr[left-1] + arr[left];
                cArr[right] = arr[right] + arr[right-1];
                left++;
                right--;
            }
            arr = cArr;

            for(int index=0; index<arr.length; index++){
                System.out.format(" %s", arr[index]);
            }
            System.out.println();
        }
    }
}
