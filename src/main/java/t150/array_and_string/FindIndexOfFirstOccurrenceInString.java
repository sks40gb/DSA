package t150.array_and_string;

public class FindIndexOfFirstOccurrenceInString {

    public static void main(String[] args) {
        FindIndexOfFirstOccurrenceInString o = new FindIndexOfFirstOccurrenceInString();
        System.out.println(o.strStr("a", "a"));
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (isMatched(i, haystack, needle)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isMatched(int fromIndex, String haystack, String needle) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(i + fromIndex) != needle.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
