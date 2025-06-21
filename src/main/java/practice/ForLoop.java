package practice;

public class ForLoop {
    public static void main(String[] args) {

        int n = 4;

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                System.out.print(j + 1);
            }
            System.out.println();
        }

        System.out.println("-----");

        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j >= 0; j--) {
                System.out.print(j + 1);
            }
            System.out.println();
        }

        System.out.println("-----");
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= n - 1; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }

        System.out.println("-----");

        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j <= n - 1; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
        System.out.println("---- I : [Fixed] C:[Increment] -----A");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }


        System.out.println("---- I : [Fixed] C:[Decrement] -----B>>>>>>>>>");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - i - 1; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }

        System.out.println("---- I : [Fixed] C:[Increment] -----D");

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                System.out.print(j + 1);
            }
            System.out.println();
        }


        System.out.println("---- I : [Fixed] C:[Decrement] -----C");

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= n - i - 1; j--) {
                System.out.print(j + 1);
            }
            System.out.println();
        }


        System.out.println("---- I : [Increment] C:[Fixed] -----E");

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print(j + 1);
            }
            System.out.println();
        }


        System.out.println("---- I : [Decrement] C:[Fixed] -----F");

        for (int i = 0; i < n; i++) {
            for (int j = n - i - 1; j < n; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }

    }
}
