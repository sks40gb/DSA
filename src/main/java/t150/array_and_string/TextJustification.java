package t150.array_and_string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static void main(String[] args) {
        TextJustification o = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(o.fullJustify(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int fromIndex = 0;
        while (fromIndex < words.length) {
            int toIndex = getToIndex(words, fromIndex, maxWidth);
            list.add(justify(words, fromIndex, toIndex, maxWidth));
            fromIndex = toIndex + 1;
        }
        return list;
    }

    private String justify(String[] words, int fromIndex, int toIndex, int maxWidth) {
        StringBuilder line = new StringBuilder();
        for (int i = fromIndex; i <= toIndex ; i++) {
            line.append(words[i]);
        }
        return line.toString();
    }

    private int getToIndex(String[] words, int fromIndex, int maxWidth) {
        int n = 0;
        while (fromIndex < words.length) {
            if (n + words.length <= maxWidth) {
                n += words.length + 1;
            } else {
                return fromIndex;
            }
            fromIndex++;
        }
        return -1;
    }
}
