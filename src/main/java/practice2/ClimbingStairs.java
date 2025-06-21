package practice2;

public class ClimbingStairs {
    public static void main(String[] args) {
        int ways = new ClimbingStairs().ways(2);
        System.out.println(ways);
    }

    private int ways(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if(n < 0){
            return 0;
        }
        return ways(n-1) + ways(n-2);
    }
}
