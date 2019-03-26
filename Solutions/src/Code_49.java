import java.util.*;

public class Code_49 {

    public static void main(String[] args) {
        Code_49 c = new Code_49();

        String[] strs = {};
        c.groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<HashMap<Character, Integer>> charMapList = new LinkedList<>();
        List<List<String>> groups = new ArrayList<>();

        for (String str : strs) {
            boolean exist = false;

            HashMap<Character, Integer> charMap = convert(str);

            int idx = 0;
            for (HashMap<Character, Integer> map : charMapList) {
                if (map.size() == charMap.size()) {
                    boolean isSame = true;
                    for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                        if (map.get(entry.getKey()) != entry.getValue()) {
                            isSame = false;
                            break;
                        }
                    }
                    if (isSame) {
                        exist = true;
                    }
                }
                if (exist) {
                    break;
                }
                idx ++;
            }

            if (exist) {
                groups.get(idx).add(str);
            } else {
                charMapList.add(charMap);
                List<String> group = new ArrayList<>();
                group.add(str);
                groups.add(group);
            }
        }

        return groups;
    }

    HashMap<Character, Integer> convert(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
