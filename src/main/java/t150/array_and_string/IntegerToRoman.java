package t150.array_and_string;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman o = new IntegerToRoman();
        System.out.println(o.intToRoman(3749));   //MMMDCCXLIX
        System.out.println(o.intToRoman(58));     //LVIII
        System.out.println(o.intToRoman(1994));   //MCMXCIV
    }

    public String intToRoman(int num) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);


        StringBuilder builder = new StringBuilder();
        for (String key : map.keySet()) {
            int v = map.get(key);
            while (num >= v) {
                builder.append(key);
                num -= v;
            }
        }
        return builder.toString();
    }

}
