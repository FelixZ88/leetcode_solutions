import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Code_438 {
    public static void main(String[] args) {
        Code_438 c = new Code_438();
        c.findAnagrams("cba",
                "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new LinkedList<>();
        if (p.length() > s.length()) {
            return ret;
        }

        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            if (pMap.containsKey(c)) {
                pMap.put(c, pMap.get(c) + 1);
            } else {
                pMap.put(c, 1);
            }
        }

        for (int i = 0; i < s.length() - p.length() + 1; i ++) {
            HashMap<Character, Integer> sMap = new HashMap<>();
            boolean matched = true;
            for (int j = i; j < i + p.length(); j ++) {
                char c = s.charAt(j);
                if (pMap.containsKey(c)) {
                    int pCount = pMap.get(c);
                    if (sMap.containsKey(c)) {
                        sMap.put(c, sMap.get(c) + 1);
                    } else {
                        sMap.put(c, 1);
                    }
                    int sCount = sMap.get(c);
                    if (pCount < sCount) {
                        matched = false;
                        break;
                    }
                } else {
                    i = j;
                    matched = false;
                    break;
                }
            }

            if (matched) {
                if (pMap.size() == sMap.size()) {
                    for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
                        int pCount = entry.getValue();
                        int sCount = sMap.get(entry.getKey());
                        if (pCount != sCount) {
                            matched = false;
                            break;
                        }
                    }
                    if (matched) {
                        ret.add(i);
                    }
                }
            }
        }
        return ret;
    }
}
