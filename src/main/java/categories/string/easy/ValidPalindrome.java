package categories.string.easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "0P";
        boolean result = new ValidPalindrome().isPalindrome(s);
        System.out.println(result);
    }

    public boolean isPalindrome(String s) {
        String s1 = parseString(s);
        int left = 0;
        int right = s1.length() -1;
        while(left < right){
            if(s1.charAt(left) != s1.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private String parseString(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') ){
                builder.append(c);
            }
        }
        return builder.toString().toLowerCase();
    }
}
