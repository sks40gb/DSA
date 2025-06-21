package categories.string.easy;

/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/?envType=problem-list-v2&envId=ehkbkaxt
 */
class AreAlmostEqual {

    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "kanb";
        boolean result = new AreAlmostEqual().areAlmostEqual(s1, s2);
        System.out.println(result);
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        int firstMissing = -1;
        int secondMissing = -1;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                if(firstMissing == -1){
                    firstMissing = i;
                }else if(secondMissing == -1){
                    secondMissing = i;
                }else{
                    return false;
                }
            }
        }
        if(firstMissing == -1 || secondMissing == -1){
            return false;
        }
        return (s1.charAt(firstMissing) == s2.charAt(secondMissing)) && (s1.charAt(secondMissing) == s2.charAt(firstMissing));
    }
}