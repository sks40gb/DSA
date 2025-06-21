package t150.array_and_string;

public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord o = new LengthOfLastWord();
        System.out.println(o.lengthOfLastWord("Hello World")); //5
        System.out.println(o.lengthOfLastWord("   fly me   to   the moon  ")); //4
        System.out.println(o.lengthOfLastWord("luffy is still joyboy")); //6
    }

    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                if (length > 0) {
                    break;
                }
            }
        }
        return length;
    }

    public int lengthOfLastWord1(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length - 1].trim().length();
    }
}
