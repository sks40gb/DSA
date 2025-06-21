package practice;

public class FriendsPartyPlan {

    public static void main(String[] args) {
        String input = "ABCDEFGH";
        int ways = findWays(input);
        int c2 = countWays(input.length());
        System.out.println(ways + ": " + c2);
    }

    private static int findWays(String input) {
        if(input.length() == 0 ){
            return 0;
        }
        if(input.length() == 1){
            return 1;
        }
        if(input.length() == 2){
            return 2;
        }
        int alone = 1 + findWays(input.substring(1));
        int pair = 1 + findWays(input.substring(2));
        return  alone + pair ;
    }

    // Recursive function to find the number of ways n friends can attend the party
    public static int countWays(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recurrence relation:
        // 1. The nth friend can attend alone: countWays(n-1)
        // 2. The nth friend can pair up with any of the remaining (n-1) friends: (n-1) * countWays(n-2)
        return countWays(n - 1) + (n - 1) * countWays(n - 2);
    }


}
