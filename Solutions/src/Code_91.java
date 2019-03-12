public class Code_91 {

    public static void main(String[] args) {
        Code_91 c = new Code_91();
        System.out.println(c.numDecodings("10101"));
    }
    public int numDecodings(String s) {
        int[] count = new int[s.length()];

        if (s.charAt(0) == '0') {
            return 0;
        }

        count[0] = 1;

        for (int i = 1; i < count.length; i ++) {
            char ci = s.charAt(i);
            char pre = s.charAt(i - 1);
            if (ci == '0') {
                if (pre == '0' || pre >= '3') {
                    return 0;
                } else if (i >= 2) {
                    count[i] = count[i - 2];
                } else {
                    count[i] = 1;
                }
            } else if (pre == '0') {
                count[i] = count[i - 1];
            } else {
                Integer val = Integer.parseInt(String.valueOf(new char[]{pre, ci}));
                if (val >= 27) {
                    count[i] = count[i - 1];
                } else if (i >= 2) {
                    count[i] = count[i - 1] + count[i - 2];
                } else {
                    count[i] = count[i - 1] + 1;
                }
            }
        }
        return count[count.length - 1];
    }
}
