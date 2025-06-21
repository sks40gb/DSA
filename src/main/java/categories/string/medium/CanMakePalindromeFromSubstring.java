package categories.string.medium;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

// [true,false,false,true,true]
public class CanMakePalindromeFromSubstring {
    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        List<Boolean> resultList = new CanMakePalindromeFromSubstring().canMakePaliQueries(s, queries);
        for (Boolean aBoolean : resultList) {
            System.out.println(aBoolean);
        }
    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> list = new ArrayList<>();
        int[][] frequencies = new int[s.length() + 1][26];

        for (int i = 0; i < s.length(); i++) {
            frequencies[i + 1] = frequencies[i].clone();
            frequencies[i + 1][s.charAt(i)-'a']++;
        }
        ArrayUtil.print2D(frequencies);

        for (int i = 0; i < queries.length; i++) {
            list.add(isPoli(frequencies, queries[i]));
        }
        return list;
    }

    private Boolean isPoli(int[][] frequencies, int[] query) {
        int left = query[0];
        int right = query[1];
        int times = query[2];

        int[] freq = new int[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = frequencies[right+1][i] - frequencies[left][i];
        }

        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= (times * 2) + 1;
    }
}
