public class Code_125 {

    public static void main(String[] args) {
        Code_125 c = new Code_125();
        int[] points = {1, 7, 3, 6, 5, 6};
        System.out.println(c.isPalindrome("0P"));
    }


    // "aBBa"
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);

            while (!Character.isAlphabetic(lc) && !Character.isDigit(lc)) {
                left ++;
                if (left < s.length()) {
                    lc = s.charAt(left);
                } else {
                    return true;
                }
            }
            while (!Character.isAlphabetic(rc) && !Character.isDigit(rc)) {
                right --;
                if (right >= 0) {
                    rc = s.charAt(right);
                } else {
                    return true;
                }
            }

            if (lc != rc) {
                return false;
            }
            left ++;
            right --;
        }

        return true;
    }
}
