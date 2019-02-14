import java.util.LinkedList;

public class Code_7 {

    public static void main(String[] args) {
        Code_7 c = new Code_7();
        int palindrome = c.reverse(1534236469);
        System.out.println(palindrome);
    }

    public int reverse(int x) {
        boolean negative = x < 0;

        x = Math.abs(x);

        LinkedList list = new LinkedList();

        boolean start = true;
        while (x > 0) {
            int dividend = x % 10;
            if (!start || dividend != 0) {
                list.add(dividend);
                start = false;
            }
            x /= 10;
        }

        long reversed = 0;
        for (Object val : list) {
            reversed = reversed * 10 + (int)val;
            if (reversed > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int)reversed * (negative ? (-1) : 1);
    }
}
