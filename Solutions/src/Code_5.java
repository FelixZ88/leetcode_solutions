public class Code_5 {
    public static void main(String[] args) {
        Code_5 c = new Code_5();
        String palindrome = c.longestPalindrome("abcdcb");
        System.out.println(palindrome);
    }

    public String longestPalindrome(String s) {
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
