public class Code_28 {

    public static void main(String[] args) {
        strStr("a", "a");
    }
    public static int strStr(String haystack, String needle) {

        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i ++) {
            boolean matched = true;
            for (int j = 0; j < needle.length(); j ++) {

                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    continue;
                } else {
                    matched = false;
                    break;
                }
            }

            if (matched) {
                return i;
            }
        }

        return -1;
    }
}
