package t150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {


    public static void main(String[] args) {

        WordPattern solution = new WordPattern();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(solution.wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog")); // false
        System.out.println(solution.wordPattern("abba", "dog dog dog dog")); // false
    }

    public boolean wordPattern(String pattern, String sentence) {
        String[] words = sentence.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for(int i=0; i < pattern.length(); i++){
            Character c = pattern.charAt(i);
            String word = words[i];
            if(charToWord.containsKey(c) && !charToWord.get(c).equals(word)){
                return false;
            }
            charToWord.put(c, word);

            if(wordToChar.containsKey(word) && wordToChar.get(word) != c){
                return false;
            }
            wordToChar.put(word,c);
        }
        return true;
    }


}
