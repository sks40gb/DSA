package practice;

import util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class CanMakePalindromeFromSubstring {

    public static void main(String[] args) {
        String s = "lyb";
        int[][] queries = {{0,1,0}, {2,2,1}};
        List<Boolean> result = canMakePoli(s, queries);
        System.out.println(result); // Output: [true, false, false, true, true]
    }

    private static List<Boolean> canMakePoli(String s, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        //Keep the counts for each character

        int matrix[][] = new int[s.length()+1][26];
        for (int i = 0; i < s.length(); i++) {
            System.arraycopy(matrix[i], 0, matrix[i+1], 0, 26);
            matrix[i+1][s.charAt(i) - 'a']++;
        }
        ArrayUtil.print2D(matrix);
        //find the counts from matrix
        for (int[] query : queries){
            int left = query[0];
            int right = query[1];
            int k = query[2];
            int oddCount = getOddCount(matrix, s, left, right);
            if(oddCount/2 <= k){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }

    private static int getOddCount(int[][] matrix, String input, int left, int right) {
        int oddCount = 0;
        //String s = input.substring(left, right+1);
        for (int i = 0; i < matrix[0].length; i++) {
          int count = matrix[right+1][i] - matrix[left][i];
          if(count %2 != 0){
              oddCount++;
          }
        }
        return oddCount;
    }

}
