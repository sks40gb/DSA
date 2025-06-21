package windowsldiging.fixed;

/* Count Occurrences of Anagrams
 *
 * Input : forxxorfxdofr
 *         for
 * Output : 3
 * Explanation : Anagrams of the word for - for, orf,
 * ofr appear in the text and hence the count is 3.
 *
 *
 * Input : aabaabaa
 *         aaba
 * Output : 4
 * Explanation : Anagrams of the word aaba - aaba,
 * abaa each appear twice in the text and hence the
 * count is 4.
 */


import java.util.Arrays;

public class A_CountOccurrencesOfAnagrams {

    public static void main(String[] args) {
        String input = "forxxorfxdofr";
        String match = "for";
        int occurrence = findAnagram(input, match);
        System.out.println(occurrence);
    }

    private static int findAnagram(String input, String match){
        int occurrence = 0;
        int[] matchArray = new int[256];
        int[] inputArray = new int[256];
        int k = match.length();
        for(int i=0; i< k; i++){
            matchArray[match.charAt(i)]++;
        }

        for(int i=0; i< k; i++){
            inputArray[input.charAt(i)]++;
        }

        if(Arrays.equals(matchArray, inputArray)){
            occurrence++;
        }

        for(int i=k; i<input.length(); i++){
            inputArray[input.charAt(i-1)]--;
            inputArray[input.charAt(i)]++;
            if(Arrays.equals(matchArray, inputArray)){
                occurrence++;
            }
        }
        return occurrence;
    }

}
