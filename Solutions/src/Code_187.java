import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Code_187 {

    public static void main(String[] args) {
        Code_187 c = new Code_187();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        c.findRepeatedDnaSequences("AAAAAAAAAA");
    }



    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return res;
        }

        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i ++) {
            String sub = new String(s.toCharArray(), i, 10);
            if (count.containsKey(sub)) {
                count.put(sub, count.get(sub) + 1);
            } else {
                count.put(sub, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
