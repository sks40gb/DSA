package categories.string.easy;

public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        boolean result = new CheckIfTwoStringArraysAreEquivalent().arrayStringsAreEqual(word1, word2);
        System.out.println(result);
    }
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            s1.append(word1[i]);
        }

        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < word2.length; i++) {
            s2.append(word2[i]);
        }
        return s1.toString().equals(s2.toString());
    }
}
