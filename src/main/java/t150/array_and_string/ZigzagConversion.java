package t150.array_and_string;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {

    public static void main(String[] args) {
        ZigzagConversion o = new ZigzagConversion();
        System.out.println(o.convert("PAYPALISHIRING", 3)); //PAHNAPLSIIGYIR
        System.out.println(o.convert("AB", 1)); //PAHNAPLSIIGYIR
    }

    public String convert(String s, int numRows) {
        // Handle edge case where numRows is 1
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;
        for (int i = 0; i < s.length(); i++) {
            rows.get(currentRow).append(s.charAt(i));
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows.size(); i++) {
            result.append(rows.get(i));
        }
        return result.toString();
    }
}
