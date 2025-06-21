package t150.array_and_string;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix o = new LongestCommonPrefix();
        String[] s1 = {"flower", "flow", "flight"};
        System.out.println(o.longestCommonPrefix(s1)); // "fl"
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder pre = new StringBuilder();
        String word = strs[0];
        for (int i = 0; i < word.length(); i++) {
            for (int wIndex = 1; wIndex < strs.length; wIndex++) {
                //Not enough length of word
                if (strs[wIndex].length() <= i) {
                    return pre.toString();
                }
                //if character doesn't match with first word
                if (strs[wIndex].charAt(i) != word.charAt(i)) {
                    return pre.toString();
                }
            }
            pre.append(word.charAt(i));
        }
        return pre.toString();
    }
}
