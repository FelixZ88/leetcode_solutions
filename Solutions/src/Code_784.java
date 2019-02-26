import java.util.ArrayList;
import java.util.List;

public class Code_784 {

    public static void main(String[] args) {
        Code_784 c = new Code_784();

        System.out.println(c.letterCasePermutation("a1B2"));
    }


    List<String> letterStrings = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        StringBuffer sb = new StringBuffer(S.length());
        enumLetters(S, 0, sb);
        return letterStrings;
    }

    public void enumLetters(String S, int index, StringBuffer sb) {
        if (index == S.length()) {
            letterStrings.add(sb.toString());
            return ;
        }

        char c = S.charAt(index);
        if (Character.isAlphabetic(c)) {
            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 'a' + 'A');
            }
            StringBuffer sb2 = new StringBuffer(S.length());
            sb2.append(sb);
            sb2.append(c);
            enumLetters(S, index + 1, sb2);

            c = (char)(c - 'A' + 'a');
            StringBuffer sb3 = new StringBuffer(S.length());
            sb3.append(sb);
            sb3.append(c);
            enumLetters(S, index + 1, sb3);
        } else {
            sb.append(c);
            enumLetters(S, index+1, sb);
        }
    }
}
