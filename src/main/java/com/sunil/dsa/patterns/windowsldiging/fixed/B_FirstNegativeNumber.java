package com.sunil.dsa.patterns.windowsldiging.fixed;

import java.util.ArrayList;
import java.util.List;

/* First Negative Number in every Window of Size K
 *
 * Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
 * Output : -1 -1 -7 -15 -15
 */
public class B_FirstNegativeNumber {

    public static void main(String[] args) {
        int[] input = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        List<Integer> result = findFirstNegative(input,k);
        result.forEach(System.out::println);
    }

    private static List<Integer> findFirstNegative(int[] input, int k){
        List<Integer> result = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for(int i=0; i<k; i++){
            if(input[i] < 0){
                 negatives.add(input[i]);
            }
        }
        if(!negatives.isEmpty()){
            result.add(negatives.get(0));
        }
        for(int i=k; i < input.length; i++){
            if(input[i-k] < 0){
                negatives.remove(0);
            }
            if(input[i] < 0) {
                negatives.add(input[i]);
            }
            if(!negatives.isEmpty()){
                result.add(negatives.get(0));
            }
        }
        return result;
    }
}
