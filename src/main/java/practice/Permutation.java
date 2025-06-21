package practice;

import util.ArrayUtil;

public class Permutation {

    public static void main(String[] args) {
        String s = "ABC";
        // solve(s,"");
        solve2(s.toCharArray(), 0);
    }

    private static void solve2(char[] charArray, int index) {
        if (index >= charArray.length) {
            ArrayUtil.print1D(charArray);
            return;
        }
        for (int i = index; i < charArray.length; i++) {
            swap(charArray, index, i);
            solve2(charArray, index + 1);
            swap(charArray, index, i);
        }
    }

    private static void swap(char[] charArray, int from, int to) {
        char temp = charArray[from];
        charArray[from] = charArray[to];
        charArray[to] = temp;
    }

    private static void solve(String s, String perm) {
        if (s.length() == 0) {
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String sub = s.substring(0, i) + s.substring(i + 1);
            solve(sub, c + perm);
        }
    }
}
