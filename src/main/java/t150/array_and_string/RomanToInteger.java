package t150.array_and_string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger o = new RomanToInteger();
        System.out.println(o.romanToInt("III"));//3
        System.out.println(o.romanToInt("LVIII"));//58
        System.out.println(o.romanToInt("MCMXCIV"));//1994
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int pre = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = map.get(c);
            if (value < pre) {
                total -= value;
            } else {
                total += value;
            }
            pre = value;
        }
        return total;
    }
}
