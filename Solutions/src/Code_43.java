public class Code_43 {

    public static void main(String[] args) {
        Code_43 c = new Code_43();
        System.out.println(c.multiply("123", "0"));
    }

    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.charAt(0) == '0'
                || (num2.length() == 1 && num2.charAt(0) == '0')) {
            return "0";
        }
        StringBuffer ret = new StringBuffer();

        for (int i = num1.length() - 1; i >= 0; i --) {
            int valI = (num1.charAt(i) - '0');
            StringBuffer tmpSum = new StringBuffer();
            for (int j = num2.length() - 1; j >= 0; j --) {
                int valJ = num2.charAt(j) - '0';

                StringBuffer sb = new StringBuffer();
                sb.append(valI * valJ);
                for (int k = num2.length() - 1; k > j; k --) {
                    sb.append('0');
                }

                tmpSum = add(tmpSum, sb);
            }

            for (int k = num1.length() - 1; k > i; k --) {
                tmpSum.append('0');
            }
            ret = add(ret, tmpSum);
        }

        return ret.toString();
    }

    StringBuffer add(StringBuffer val1, StringBuffer val2) {
        int l1 = val1.length();
        int l2 = val2.length();

        if (l1 > l2) {
            StringBuffer tmp = val1;
            val1 = val2;
            val2 = tmp;

            int ltmp = l1;
            l1 = l2;
            l2 = ltmp;
        }

        int carry = 0;
        char[] sum = new char[l2 + 1];

        for (int i = 0; i < l1; i ++) {
            int c1 = val1.charAt(l1 - i - 1) - '0';
            int c2 = val2.charAt(l2 - i - 1) - '0';
            if (c1 + c2 + carry>= 10) {
                sum[l2 - i] = (char)(c1 + c2 + carry - 10 + '0');
                carry = 1;
            } else {
                sum[l2 - i] = (char)(c1 + c2 + carry + '0');
                carry = 0;
            }
        }

        for (int i = l1; i < l2; i ++) {
            int c2 = val2.charAt(l2 - i - 1) - '0';
            if (c2 + carry >= 10) {
                sum[l2 - i] = (char)(c2 + carry - 10 + '0');
                carry = 1;
            } else {
                sum[l2 - i] = (char)(c2 + carry + '0');
                carry = 0;
            }
        }

        if (carry == 1) {
            sum[0] = '1';
        }

        if (sum[0] == '1') {
            StringBuffer ret = new StringBuffer();
            ret.append(sum);
            return ret;
        } else {
            StringBuffer ret = new StringBuffer();
            ret.append(sum, 1, l2);
            return ret;
        }
    }
}
