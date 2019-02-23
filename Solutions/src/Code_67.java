public class Code_67 {
    public String addBinary(String a, String b) {
        int ia = a.length() - 1;
        int ib = b.length() - 1;

        char[] sum = new char[Math.max(ia, ib) + 1];
        int isum = sum.length - 1;
        int over = 0;
        while (ia >= 0 && ib >= 0 && isum >= 0) {
            char ca = a.charAt(ia);
            char cb = b.charAt(ib);

            int add = ca - '0' + cb - '0' + over;
            if (add >= 2) {
                over = 1;
            } else {
                over = 0;
            }
            sum[isum] = (char)(add % 2 + '0');
            ia --;
            ib --;
            isum --;
        }

        if (ia >= 0) {
            while (ia >= 0 && isum >= 0) {
                char ca = a.charAt(ia);

                int add = ca - '0' + over;
                if (add >= 2) {
                    over = 1;
                } else {
                    over = 0;
                }
                sum[isum] = (char)(add % 2 + '0');
                ia --;
                isum --;
            }
        } else if (ib >= 0){
            while (ib >= 0 && isum >= 0) {
                char cb = b.charAt(ib);

                int add = cb - '0' + over;
                if (add >= 2) {
                    over = 1;
                } else {
                    over = 0;
                }
                sum[isum] = (char)(add % 2 + '0');
                ib --;
                isum --;
            }
        }

        if (over == 1) {
            char[] dst = new char[sum.length + 1];
            dst[0] = '1';
            System.arraycopy(sum, 0, dst, 1, sum.length);
            return String.valueOf(dst);
        }
        return String.valueOf(sum);
    }
}
