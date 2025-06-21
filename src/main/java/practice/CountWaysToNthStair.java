package practice;

public class CountWaysToNthStair {

    public static void main(String[] args) {
        int n = 4; // Change this value to test other cases
        getAllPaths(n, "");
    }

    public static void getAllPaths(int n, String path) {
        if (n == 0) {
            System.out.println(path);
            return;
        }
        if (n >= 1) {
            getAllPaths(n - 1, path + String.format("[%s]", 1));
        }

        if (n >= 2) {
            getAllPaths(n - 2, path + String.format("[%s]", 2));
        }

        if (n >= 3) {
            getAllPaths(n - 3, path + String.format("[%s]", 3));
        }
    }

}
