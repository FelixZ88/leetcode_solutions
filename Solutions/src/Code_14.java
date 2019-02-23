
public class Code_14 {
    public static void main(String[] args) {
        Code_14 c = new Code_14();
        String[] strs = {"flower","flow","flight"};
        c.longestCommonPrefix(strs);
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        int pos = 0;
        StringBuffer sb = new StringBuffer();
        while (pos < strs[0].length()) {
            boolean equals = true;
            char c = strs[0].charAt(pos);
            for (int i = 1; i < strs.length; i ++) {
                String str = strs[i];

                if (pos >= str.length()) {
                    return sb.toString();
                }
                if (c != str.charAt(pos)) {
                    equals = false;
                    break;
                }
            }

            if (equals) {
                sb.append(c);
            } else {
                return sb.toString();
            }
            pos ++;
        }
        return sb.toString();
    }
}
