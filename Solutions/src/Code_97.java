public class Code_97 {

    public static void main(String[] args) {
        Code_97 c = new Code_97();
        System.out.println(c.isInterleave( "aabcc", "dbbca", "aadbbcbcac"));
//        System.out.println(palindrome);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int i = 0, j = 0, k = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s3.charAt(k)) {
                i ++;
                k ++;
                continue;
            }
            if (s2.charAt(j) == s3.charAt(k)) {
                j ++;
                k ++;
                continue;
            }
            return false;
        }

        if (i == s1.length() && j == s2.length()) {
            return true;
        }
        if (i == s1.length()) {
            while (j < s2.length()) {
                if (s2.charAt(j) == s3.charAt(k)) {
                    j ++;
                    k ++;
                    continue;
                }
                return false;
            }
        }
        if (j == s2.length()) {
            while (i < s1.length()) {
                if (s1.charAt(i) == s3.charAt(k)) {
                    i ++;
                    k ++;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
