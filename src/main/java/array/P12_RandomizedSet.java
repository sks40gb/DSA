package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class P12_RandomizedSet {

    public static void main(String[] args) {

    }
}

class RandomizedSet{
    private List<Integer> list;

    public RandomizedSet(){
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        Integer v = val;
        if(list.contains(v)){
            return false;
        }
        return list.add(v);
    }

    public boolean remove(int val) {
        Integer v = val;
        return list.remove(v);
    }

    public int getRandom() {
        double randomVal = new Random().nextInt(list.size());
        return list.get((int) randomVal);
    }
}

