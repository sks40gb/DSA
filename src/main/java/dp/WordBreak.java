package dp;

import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak o = new WordBreak();

//        String s = "leetcode";
//        List<String> wordDict = List.of("leet", "code");

        String s = "abcd";
        List<String> wordDict = List.of("a","abc","b","cd");


        System.out.println(o.wordBreakRec(s, wordDict, 0));
    }

    public boolean wordBreakRec(String s, List<String> wordDict, int start) {
        int n = s.length();
        if (start == n) {
            return true;
        }
        boolean found = false;
        for (int end = start; end < n; end++) {
            String sub = s.substring(start, end+1);
            if (wordDict.contains(sub)) {
                found = found || wordBreakRec(s.substring(end+1), wordDict, start + 1);
            }
        }
        return found;
    }
}
