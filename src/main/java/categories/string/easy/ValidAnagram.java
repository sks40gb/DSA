package categories.string.easy;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = new ValidAnagram().isAnagram(s, t);
        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i)]++;
            arr2[t.charAt(i)]++;
        }
        return Arrays.equals(arr1, arr2);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        // Sorting temp array using
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted strings
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;

    }
}
