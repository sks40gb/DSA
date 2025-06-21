package categories.pattern.a_MinMax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoneGame {
    public static void main(String[] args) {
        int[] stones = {31, 26, 33, 21, 40};
        int result = new StoneGame().lastStoneWeightII(stones);
        System.out.println(result);
    }

    public int lastStoneWeightII(int[] stones) {

        List<Integer> list = new ArrayList<>();
        Map<String, Integer> memo = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            list.add(stones[i]);
        }
        return getMin(list, memo);
    }

    private int getMin(List<Integer> stones, Map<String,Integer> memo) {
        if (stones.isEmpty()) {
            return 0;
        }
        if (stones.size() == 1) {
            return stones.get(0);
        }
        if(memo.containsKey(stones.toString())){
            return memo.get(stones.toString());
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stones.size() ; i++) {
            for (int j = i+1; j < stones.size(); j++) {
                List<Integer> newList = new ArrayList<>(stones);
                int one = stones.get(i);
                int two = stones.get(j);
                newList.remove(j);
                newList.remove(i);
                if (one != two) {
                    newList.add(Math.abs(one - two));
                }
                int result = getMin(newList, memo);
                if (result != Integer.MAX_VALUE) {
                    min = Math.min(min, result);
                }
            }
        }
         min  = min == Integer.MAX_VALUE ? -1 :  min;
         memo.put(stones.toString(), min);
         return min;
    }
}
