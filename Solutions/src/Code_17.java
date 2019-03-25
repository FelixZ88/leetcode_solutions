import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Code_17 {

    public static void main(String[] args) {
        Code_17 c = new Code_17();
        c.letterCombinations("23");
    }


    public List<String> letterCombinations(String digits) {
        List<StringBuffer> ret = new LinkedList<>();
        for (int i = 0; i < digits.length(); i ++) {
            char c = digits.charAt(i);
            List<Character> chars = helper(c - '0');

            List<StringBuffer> newRet = new LinkedList<>();
            if (ret.size() > 0) {
                for (StringBuffer sb : ret) {
                    for (Character ch : chars) {
                        StringBuffer newSb = new StringBuffer(sb);
                        newSb.append(ch);
                        newRet.add(newSb);
                    }
                }
                ret = newRet;
            } else {
                for (Character ch : chars) {
                    ret.add(new StringBuffer(ch + ""));
                }
            }

        }

        List<String> strRet = new LinkedList<>();
        for (StringBuffer b : ret) {
            strRet.add(b.toString());
        }
        return strRet;
    }

    public List<Character> helper(int digit) {
        switch (digit) {
            case 2:
                return Arrays.asList('a', 'b', 'c');
            case 3:
                return Arrays.asList('d', 'e', 'f');
            case 4:
                return Arrays.asList('g', 'h', 'i');
            case 5:
                return Arrays.asList('j', 'k', 'l');
            case 6:
                return Arrays.asList('m', 'n', 'o');
            case 7:
                return Arrays.asList('p', 'q', 'r', 's');
            case 8:
                return Arrays.asList('t', 'u', 'v');
            case 9:
                return Arrays.asList('w', 'x', 'y', 'z');
            default:
                throw new IllegalArgumentException();
        }
    }
}
