import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Code_884 {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> words = new HashMap<>();

        String[] a = A.split(" ");
        for (String s : a) {
            if (words.containsKey(s)) {
                words.put(s, words.get(s) + 1);
            } else {
                words.put(s, 1);
            }
        }

        String[] b = B.split(" ");
        for (String s : b) {
            if (words.containsKey(s)) {
                words.put(s, words.get(s) + 1);
            } else {
                words.put(s, 1);
            }
        }

        ArrayList<String> ret = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() == 1) {
                ret.add(entry.getKey());
            }
        }

        String[] r = new String[ret.size()];
        ret.toArray(r);
        return r;
    }
}
