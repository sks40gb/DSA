package com.sunil.dsa.categories.array;

public class P18_LengthOfLastWord {

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        P18_LengthOfLastWord o = new P18_LengthOfLastWord();
        System.out.println(o.lengthOfLastWord(s));
    }


    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (s.charAt(end) == ' ') {
            end--;
        }

        int start = end;
        while (s.charAt(start) != ' ' && start > 0) {
            start--;
        }

        return end - start;
    }

}
