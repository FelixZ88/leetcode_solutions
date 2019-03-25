import java.util.ArrayList;
import java.util.List;

public class Code_1002 {
    public List<String> commonChars(String[] A) {
        ArrayList<int[]> counts = new ArrayList<>(A.length);
        ArrayList<String> ret = new ArrayList<>();

        for (String a : A) {
            int[] count = new int[26];
            for (char c : a.toCharArray()) {
                count[c - 'a'] ++;
            }
            counts.add(count);
        }

        for (int i = 0; i < 26; i ++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < A.length; j ++) {
                min = Math.min(min, counts.get(j)[i]);
                if (min == 0) {
                    break;
                }
            }

            if (min != 0) {
                for (int k = 0; k < min; k ++) {
                    ret.add(String.valueOf((char)('a' + i)));
                }
            }
        }
        return ret;
    }
}
