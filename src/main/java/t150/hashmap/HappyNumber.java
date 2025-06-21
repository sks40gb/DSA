package t150.hashmap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {

        HappyNumber solution = new HappyNumber();
        System.out.println(solution.isHappy(19)); // true
        System.out.println(solution.isHappy(2));  // false
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}
