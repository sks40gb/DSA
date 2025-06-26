package com.sunil.dsa.categories.a_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a",
"computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 */

//TODO : it has wrong implementation
public class P23_TextJustification {
    public static void main(String[] args) {
        P23_TextJustification o = new P23_TextJustification();
        String[] words = {"Science", "is", "what", "we", "understand",
                "well", "enough", "to", "explain", "to", "a",
                "computer.", "Art", "is", "everything", "else",
                "we", "do"};
        int maxWidth = 20;
        System.out.println(o.fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int start = 0;
        int end = 0;
        int len = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (len + 1 + words[i].length() > maxWidth) {
                System.out.println(len);
                processLine(words, start, end, len, maxWidth, list);
                start = i;
                len = words[i].length();
            } else {
                len += words[i].length() + 1;
            }
            end = i;
        }
        processLine(words, start, end, len, maxWidth, list);
        return list;
    }

    private void processLine(String[] words, int start, int end, int len, int maxWidth, List<String> list) {

        System.out.println(end + " :  " + start);
        int cnt = end - start + 1; //total word characters
        int spaceRequired = maxWidth - len; //extra space required

        String[] spaces = new String[cnt - 1];
        Arrays.fill(spaces, "");
        while (spaceRequired > 0) {
            for (int i = 0; i < spaces.length && spaceRequired > 0; i++) {
                spaces[i] += " ";
                spaceRequired--;
            }
        }
        StringBuilder line = new StringBuilder(words[start]);
        int spaceIndex = 0;
        for (int i = start + 1; i <= end; i++) {
            line.append(spaces[spaceIndex]).append(words[i]);
        }
        list.add(line.toString());
    }
}
