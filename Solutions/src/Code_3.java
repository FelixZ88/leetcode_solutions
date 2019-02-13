import java.util.HashMap;
import java.util.HashSet;

public class Code_3 {

    public static void main(String[] args) {
        Code_3 c = new Code_3();
        c.lengthOfLongestSubstring("abcdcba");
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] words = s.toCharArray();

        int head = 0, tail = 0;
        int longest = 0;
        int current_length = 0;
        StringBuffer sb = new StringBuffer();
        HashSet sub = new HashSet();
        while (true) {
            if (!sub.contains(words[tail])) {
                current_length ++;
                longest = Math.max(longest, current_length);
                sub.add(words[tail]);
                tail ++;
            } else {
                sub.remove(words[head]);
                head ++;
                current_length --;
            }

            if (tail == words.length) {
                break;
            }
        }
        return longest;
    }

    // Brute force
    public int lengthOfLongestSubstring2(String s) {
        char[] words = s.toCharArray();

        int longest = 0;
        for (int i = 0; i < words.length; i ++) {
            HashMap sub = new HashMap();
            for (int j = i; j < words.length; j ++) {
                if (sub.containsKey(words[j])) {
                    longest = Math.max(longest, sub.size());
                    break;
                } else {
                    sub.put(words[j], words[j]);
                }
                if (j == words.length - 1) {
                    longest = Math.max(longest, sub.size());
                }
            }
        }
        return longest;
    }
}
