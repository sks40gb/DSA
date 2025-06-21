package t150.array_and_string;

import java.util.*;

public class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> idxMap;
    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        idxMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(idxMap.containsKey(val)){
            return false;
        }
        idxMap.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!idxMap.containsKey(val)){
            return false;
        }
        int index = idxMap.get(val);
        int lastIndex = list.size() -1;
        if(index != lastIndex){
            int lastValue = list.get(lastIndex);
            list.add(index, lastValue);
            idxMap.put(lastValue, index);
        }
        list.remove(lastIndex);
        idxMap.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
