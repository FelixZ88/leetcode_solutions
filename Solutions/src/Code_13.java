public class Code_13 {
    public static void main(String[] args) {
        Code_13 c = new Code_13();

        System.out.println(c.romanToInt("IIMCMXCIV"));
    }
    public int romanToInt(String s) {
        int val = 0;

        int prev = 0;
        int idx = s.length() - 1;
        while (idx >= 0) {
            char w = s.charAt(idx);
            int v = helper(w);

            if (v >= prev) {
                val += v;
                prev = v;
            } else {
                val -= v;
            }
            idx --;
        }
        return val;
    }

    public int helper(char w) {
        switch (w) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Illegal Input");
        }
    }
}
