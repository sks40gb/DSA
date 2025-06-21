package practice;

public class ConvertStringToInt {

    public static void main(String[] args) {
        String input = "pp1-53er"; // -153
        int output = convertToInt(input, input.length()-1);
        System.out.println(output);
    }

    private static int convertToInt(String input, int index) {
        if(index == 0){
            return 0;
        }
        char c = input.charAt(index);
        if(isIntValue(c)){
            return convertToInt(input, index-1) * 10 + Character.getNumericValue(c);
        }
        return convertToInt(input, index-1) ;
    }

    private static boolean isIntValue(char c) {
        return c >= '0' && c <= '9';
    }
}
