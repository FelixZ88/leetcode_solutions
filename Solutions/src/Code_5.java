import java.util.Arrays;

public class Code_5 {
    public static void main(String[] args) {
        Code_5 c = new Code_5();
        String palindrome = c.longestPalindrome("babad");
        System.out.println(palindrome);
    }

    /** Manacher's Algorithm*/
    public String longestPalindrome(String s) {
        StringBuffer sb = new StringBuffer(s.length() * 2 + 3);
        sb.append("^");
        for (char c : s.toCharArray()) {
            sb.append("#");
            sb.append(c);
        }
        sb.append("#$");

        int[] p = new int[sb.length()];
        Arrays.fill(p, 1);

        int mx = 0, id = 0;
        int maxId = 0;
        for (int i = 1; i < sb.length() - 1; i ++) {
            if (i < mx) {
                p[i] = Math.min(p[id * 2 - i], mx - i);
            }

            while (sb.charAt(i - p[i]) == sb.charAt(i + p[i])) {
                p[i] ++;
            }

            if (mx < i + p[i]) {
                id = i;
                mx = i + p[i];
            }
            if (p[i] > p[maxId]) {
                maxId = i;
            }
        }

        return s.substring((maxId - p[maxId]) / 2, (maxId - p[maxId]) / 2 + p[maxId] - 1);
    }

    public String longestPalindrome2(String s) {
        char[] words = s.toCharArray();

        int start = 0, end = 0;
        for (int i = 0; i < words.length; i ++) {
            int len1 = expand(words, i, i);
            int len2 = expand(words, i, i+1);
            if (len2 > len1 && len2 > end - start) {
                start = i - len2/2 + 1;
                end = i + len2/2 + 1;
            } else if (len1 > len2 && len1 > end - start){
                start = i - len1/2;
                end = i + len1/2 + 1;
            }
        }

        return s.substring(start, end);
    }

    public int expand(char[] word, int left, int right) {
        int len = 0;
        while (left >= 0 && right < word.length) {
            if (word[left] == word[right]) {
                len = right - left + 1;
                left --;
                right ++;
            } else {
                break;
            }
        }
        return len;
    }

}
