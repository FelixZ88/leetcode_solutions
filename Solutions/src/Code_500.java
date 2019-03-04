import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Code_500 {
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[]{};
        }

        HashMap<Character, Integer> keys = new HashMap<>();
        keys.put('Q', 1);
        keys.put('W', 1);
        keys.put('E', 1);
        keys.put('R', 1);
        keys.put('T', 1);
        keys.put('Y', 1);
        keys.put('U', 1);
        keys.put('I', 1);
        keys.put('O', 1);
        keys.put('P', 1);
        keys.put('A', 2);
        keys.put('S', 2);
        keys.put('D', 2);
        keys.put('F', 2);
        keys.put('G', 2);
        keys.put('H', 2);
        keys.put('J', 2);
        keys.put('K', 2);
        keys.put('L', 2);
        keys.put('Z', 3);
        keys.put('X', 3);
        keys.put('C', 3);
        keys.put('V', 3);
        keys.put('B', 3);
        keys.put('N', 3);
        keys.put('M', 3);

        List<String> ret = new ArrayList<>(Arrays.asList(words));

        for (String word : words) {
            String capital = word.toUpperCase();
            int row = 0;
            for (char c : capital.toCharArray()) {
                if (row != 0) {
                    if (row != keys.get(c)) {
                        ret.remove(word);
                        break;
                    }
                }
                row = keys.get(c);
            }
        }

        String[] retStrings = new String[ret.size()];
        ret.toArray(retStrings);
        return retStrings;
    }
}
