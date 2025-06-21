package practice;

public class MapToArray {

    public static void main(String[] args) {

        countCharacters();
    }

    private static void countCharacters() {
        String input = "ACBACC";
        int[] arr = new int[256];
        for (int i = 0; i < input.length(); i++) {
            arr[input.charAt(i)]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0 ){
                System.out.printf("%s : %s", (char) i, arr[i]);
                System.out.println();
            }
        }
    }
}
