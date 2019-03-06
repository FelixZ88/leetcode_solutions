import java.util.HashMap;

public class Code_389 {
    public char findTheDifference(String s, String t) {
        int f = '0';
        int sf = '0';
        for (char c : t.toCharArray()) {
            f += c;
        }
        for (char c : s.toCharArray()) {
            sf += c;
        }

        return (char)(f - sf);
    }
    public char findTheDifference1(String s, String t) {
        HashMap<Character, Integer> words = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (words.containsKey(c)) {
                words.put(c, words.get(c) + 1);
            } else {
                words.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (words.containsKey(c)) {
                int count = words.get(c);
                if (count == 0) {
                    return c;
                } else {
                    words.put(c, words.get(c) - 1);
                }
            } else {
                return c;
            }
        }
        return 'a';
    }
}
