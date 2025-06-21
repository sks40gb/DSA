package practice;

import java.util.HashMap;
import java.util.Map;

public class Practice {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            map.put("A", map.getOrDefault("A",0)+1);

            for (int j = i; j < arr.length+i; j++) {
                int index = j % 3;
                System.out.print(arr[index]);
            }
            System.out.println();
        }

    }


}








