package categories.string.easy;

/**
 * https://leetcode.com/problems/increasing-decreasing-string/?envType=problem-list-v2&envId=ehkbkaxt
 */
public class IncreasingDecreasingString {
    public static void main(String[] args) {
        String s = "aaaabbbbcccc";
        System.out.println(new IncreasingDecreasingString().sortString(s));
    }

    public String sortString(String s) {
        StringBuilder result = new StringBuilder();
        int[] arr = fillArray(s);
        boolean asc = true;
        while(result.length() < s.length()) {
            if (asc) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > 0) {
                        result.append((char) i);
                        arr[i]--;
                    }
                }
                asc = false;
            } else {
                for (int i = arr.length - 1; i >= 0; i--) {
                    if (arr[i] > 0) {
                        result.append((char) i);
                        arr[i]--;
                    }
                }
                asc = true;
            }
        }
        return result.toString();
    }

    private static int[] fillArray(String s) {
        int[] array = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            array[c]++;
        }
        return array;
    }

}

