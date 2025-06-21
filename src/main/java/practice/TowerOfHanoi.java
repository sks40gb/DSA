package practice;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        move(n,'A','C','B');
    }

    private static void move(int n, char from, char to, char aux) {
        if(n == 1){
            System.out.println("moving " +  n + " from " + from + " to " + to);
            return;
        }
        move(n-1, from, aux, to);
        System.out.println("moving " +  n + " from " + from + " to " + to);
        move(n-1, aux, to, from);
    }

}
