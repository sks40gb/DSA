package t150.array_and_string;

import java.util.Arrays;

public class CandyDistribution {

    public static int candy(int[] ratings) {

        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // Each child gets at least one candy

        // Traverse from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum up the candies
        int total = 0;
        for (int i = 0; i < candies.length; i++) {
            total += candies[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println("Total candies needed: " + candy(ratings));
    }
}
