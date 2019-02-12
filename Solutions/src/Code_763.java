import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code_763 {
    public static void main(String[] args) {
        Code_763 s = new Code_763();
        s.partitionLabels("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels_old(String S) {
        Integer[] counts = new Integer[S.length()];
        HashMap charCount = new HashMap();

        int i = 0;
        for (char c : S.toCharArray()) {
            if (charCount.containsKey(c)) {
                Integer count = (Integer)charCount.get(c);
                charCount.put(c, ++count);
            } else {
                charCount.put(c, 1);
            }
            counts[i ++] = (Integer)charCount.get(c);
        }

        ArrayList allLabels = new ArrayList();
        ArrayList currentLabels = new ArrayList();
        Integer currentCounts = new Integer(0);
        for (int j = S.length() - 1; j >= 0; j--) {
            if (currentLabels.contains(S.charAt(j))) {
                currentCounts --;
            } else {
                currentCounts += (Integer)charCount.get(S.charAt(j));
                currentCounts --;
            }
            currentLabels.add(S.charAt(j));

            if (currentCounts == 0) {
                allLabels.add(0, currentLabels.size());
                currentLabels = new ArrayList();
                currentCounts = 0;
            }
        }
        return allLabels;
    }

    public List<Integer> partitionLabels(String S) {
        int[] last_index = new int[26];

        int index = 0;
        for (char c : S.toCharArray()) {
            last_index[c - 'a'] = index++;
        }

        List<Integer> ret = new ArrayList<>();

        int last = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            last = Math.max(last, last_index[c - 'a']);
            if (last == i) {
                ret.add(last - start + 1);
                start = last + 1;
            }
        }
        return ret;
    }
}
