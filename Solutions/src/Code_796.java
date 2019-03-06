public class Code_796 {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.length() == 0) {
            return true;
        }

        for (int i = 0; i < A.length(); i ++) {
            String left = A.substring(0, i);
            String right = A.substring(i, A.length());

            if (B.startsWith(right) && B.endsWith(left)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code_796 c = new Code_796();

        System.out.println(c.rotateString("abcdef", "cdefab"));
    }
}
