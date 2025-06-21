package practice;

public class FindWays {
    public static void main(String[] args) {
        int n = 3;
        int ways = findWays(n);
        System.out.println(ways);
    }

    public static int findWays(int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return findWays(n-1) +
                findWays(n-2) +
                findWays(n-3);
    }
}
