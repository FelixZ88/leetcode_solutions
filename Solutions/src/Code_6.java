public class Code_6 {

    public static void main(String[] args) {
        Code_6 c = new Code_6();
        String palindrome = c.convert("PAYPALISHIRING", 4);
        System.out.println(palindrome);
    }

//    public String convert(String s, int numRows) {
//        if (s.length() == 0 || numRows == 1) {
//            return s;
//        }
//
//        char[] words = s.toCharArray();
//        char[] new_words = new char[words.length];
//        int unit = numRows + numRows - 2;
//        int unit_count = words.length / unit + (words.length % unit) % 1;
//        int cols =
//        for (int i = 0; i < words.length; i ++) {
//            int mode = i % (2 * numRows - 2);
//            if (mode <= numRows - 1) {
//
//            } else {
//
//            }
//            int index = 0;
//            new_words[index] = words[i];
//        }
//
//        return "";
//    }

    public String convert(String s, int numRows) {
        if (s.length() == 0 || numRows == 1) {
            return s;
        }
        char[] words = s.toCharArray();

        int length = words.length;
        int full_cols = length / (2 * numRows - 2) * (numRows - 1);
        int left_cols = length % (2 * numRows - 2);
        int cols = full_cols + (left_cols <= numRows ? 1 : (left_cols - numRows) + 1);
        char[][] new_words = new char[numRows][cols];

        for (int j = 0; j < cols; j ++) {
            for (int i = 0; i < numRows; i ++) {
                if (j % (numRows - 1) == 0) {
                    int index = (numRows + numRows - 2) * (j / (numRows - 1)) + i;
                    if (index >= length) {
                        new_words[i][j] = ' ';
                        continue;
                    }
                    new_words[i][j] = words[index];
                } else if (j % (numRows - 1) == numRows - i - 1){
                    int index = (numRows + numRows - 2) * (j / (numRows - 1)) + (numRows + numRows - i - 2);
                    if (index >= length) {
                        new_words[i][j] = ' ';
                        continue;
                    }
                    new_words[i][j] = words[index];
                } else {
                    new_words[i][j] = ' ';
                }
            }
        }

        StringBuffer sb = new StringBuffer(s.length());
        for (int i = 0; i < numRows; i ++) {
            for (int j = 0; j < cols; j ++) {
                if (new_words[i][j] != ' ' && sb.length() < s.length()) {
                    sb.append(new_words[i][j]);
                }
            }
        }
        return sb.toString();
    }

}
