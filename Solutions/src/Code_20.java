import java.util.Stack;

public class Code_20 {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while(idx < s.length()) {
            char c = s.charAt(idx);

            if (stack.size() > 0) {
                if (c == ']' || c == ')' || c == '}') {
                    char p = stack.pop();
                    if ((c == ']' && p == '[') || (c == ')' && p == '(') || (c == '}' && p == '{')) {

                    } else {
                        return false;
                    }
                } else {
                    stack.push(c);
                }

            } else {
                if (c == ']' || c == ')' || c == '}') {
                    return false;
                } else {
                    stack.push(c);
                }
            }
            idx ++;
        }

        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
