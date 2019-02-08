import java.util.HashMap;

public class Solution {
    public static void main() {
        Solution s = new Solution();
        s.numJewelsInStones("abcd", "AAaadd");
    }

    public int numJewelsInStones(String J, String S) {
        HashMap jMap = new HashMap();
        for (int i = 0; i < J.length(); i ++) {
            char c = J.charAt(i);
            jMap.put(c+"", c+"");
        }

        int count = 0;
        for (int i = 0; i < S.length(); i ++) {
            char c = S.charAt(i);
            if (jMap.containsKey(c+"")) {
                count ++;
            }
        }
        return count;
    }
}