package categories.string.easy;

public class CheckIfWordEqualsSummationOfTwoWords {
    public static void main(String[] args) {
        String firstWord = "acb";
        String secondWord = "cba";
        String targetWord = "cdb";
        boolean result = new CheckIfWordEqualsSummationOfTwoWords().isSumEqual(firstWord, secondWord, targetWord);
        System.out.println(result);
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = getNumber(firstWord);
        int second = getNumber(secondWord);
        int target = getNumber(targetWord);
        return (first + second) == target;
    }

    private int getNumber(String word) {
        int number = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int n = c - 'a';
            number = number * 10 + n;
        }
        return number;
    }
}
