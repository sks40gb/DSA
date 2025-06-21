package t150.array_and_string;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        ReverseWordsInAString o = new ReverseWordsInAString();
//        Output: "blue is sky the"
        System.out.println(o.reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        String[] words = s.trim().split("\\s+");

        // Initialize the output string
        String out = "";

        // Iterate through the words in reverse order
        for (int i = words.length - 1; i > 0; i--) {
            // Append the current word and a space to the output
            out += words[i] + " ";
        }

        // Append the first word to the output (without trailing space)
        return out + words[0];
    }

    public String reverseWords2(String s) {

        String[] words = s.trim().split("\\s+");
        int left = 0;
        int right = words.length - 1;

        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words);
    }


}
