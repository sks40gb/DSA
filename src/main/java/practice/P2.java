package practice;

import util.ArrayUtil;

public class P2 {

    /**
     * X opeartion
     * recursion()
     * Operation reverse
     */

    public static void main(String[] args) {
        String s = "ABC"; //-> inline
        char[] input = s.toCharArray();
        solve(input, 0);
        //solve(s, "");
    }

    private static void solve(char[] arr, int index) {
        if (index == arr.length) {
            for (char c : arr) {
               // System.out.print(c);
            }
            System.out.println();
            return;
        }

        for (int i = index; i < arr.length; i++) { //recursion [Array and Index]
            ArrayUtil.print1D(arr);
            swap(arr, index, i);
            solve(arr, index + 1);
            swap(arr, index, i);
        }
    }

    private static void swap(char[] arr, int index, int i) {
        char temp = arr[index];
        arr[index] = arr[i];
        arr[i] = temp;
    }

    private static void solve(String s, String ans) { //ABC -> C, f(AB)
        //base code
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        //Body
        for (int i = 0; i < s.length(); i++) { //n times -> branching
            char c = s.charAt(i); //B
            String sub = s.substring(0, i) + s.substring(i + 1); //AC
            solve(sub, c + ans);
        }

    }

}
