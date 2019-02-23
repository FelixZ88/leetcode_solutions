public class Code_66 {
    public int[] plusOne(int[] digits) {
        int[] plus = new int[digits.length];

        int i = digits.length - 1;
        int over = 1;
        while (i >= 0) {
            int add = digits[i] + over;
            if (add > 9) {
                over = 1;
            } else {
                over = 0;
            }

            plus[i] = add % 10;
            i --;
        }

        if (over == 1) {
            int[] newplus = new int[digits.length + 1];
            System.arraycopy(plus, 0, newplus, 1, digits.length);
            newplus[0] = 1;
            return newplus;
        }
        return plus;
    }
}
