import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code_22 {
    public static void main(String[] args) {
        Code_22 c = new Code_22();
        List l = c.generateParenthesis(4);
        System.out.println();
    }
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            List<String> p = new ArrayList<>();
            p.add("()");
            return p;
        }

        List<String> parenthesis = generateParenthesis(n - 1);
        List<String> ret = new ArrayList<>();
        HashMap filter = new HashMap();
        for (String p : parenthesis) {
            String first = "()" + p;
            if (!filter.containsKey(first)) {
                ret.add(first);
                filter.put(first, first);
            }
            for (int i = 1; i < p.length(); i ++) {
                StringBuffer sb = new StringBuffer();
                sb.append(p.substring(0, i));
                sb.append("()");
                sb.append(p.substring(i, p.length()));
                String new_p = sb.toString();
                if (!filter.containsKey(new_p)) {
                    filter.put(new_p, new_p);
                    ret.add(new_p);
                }
            }
            String last = p + "()";
            if (!filter.containsKey(last)) {
                ret.add(last);
                filter.put(last, last);
            }
        }
        return ret;
    }
}
