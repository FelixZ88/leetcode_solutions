public class Code_58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = s.length() - 1;
        boolean needTrim = true;
        int len = 0;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                if (needTrim) {
                    i --;
                } else {
                    break;
                }
            } else {
                needTrim = false;
                i --;
                len ++;
            }
        }

        return len;
    }
}
