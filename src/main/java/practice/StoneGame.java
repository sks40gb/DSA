package practice;

import java.util.ArrayList;
import java.util.List;

public class StoneGame {
    public static void main(String[] args) {
        int[] stones = {31, 26, 33, 21, 40};
        int result = new StoneGame().lastStoneWeightII(stones);
        System.out.println(result);

    }

    private int lastStoneWeightII(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for (int stone : stones) {
            stoneList.add(stone);
        }
        return minWeight(stoneList);
    }

    private int minWeight(List<Integer> stoneList) {
        if (stoneList.isEmpty()) {
            return 0;
        }
        if (stoneList.size() == 1) {
            return stoneList.get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stoneList.size(); i++) {
            int one = stoneList.get(i);
            for (int j = i + 1; j < stoneList.size(); j++) {
                List<Integer> l = new ArrayList<>(stoneList);
                int two = stoneList.get(j);
                l.remove(j);
                l.remove(i);
                if (one != two) {
                    l.add(Math.abs(two - one));
                }
                min = Math.min(min, minWeight(l));
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
