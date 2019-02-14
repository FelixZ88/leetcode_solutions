public class Code_8 {

    public static void main(String[] args) {
        Code_8 c = new Code_8();
        int palindrome = c.myAtoi("-2147483649");
        System.out.println(palindrome);
    }

    public int myAtoi(String str) {
        char[] words = str.toCharArray();

        int value = 0;
        int index = 0;
        int negative = 1;
        boolean beginning = true;

        int maxQuatient = Integer.MAX_VALUE / 10;
        int maxRemainder = Integer.MAX_VALUE - maxQuatient * 10;

        int minQuatient = Integer.MIN_VALUE / 10;
        int minRemainder = Integer.MIN_VALUE - minQuatient * 10;

        while (index < words.length) {
            if (beginning && words[index] == ' ') {
                index ++;
            } else if (words[index] >= '0' && words[index] <= '9') {
                beginning = false;
                if (negative == 1) {
                    if (value > maxQuatient) {
                        return Integer.MAX_VALUE;
                    } else if (value == maxQuatient) {
                        if ((words[index] - '0') >= maxRemainder) {
                            return Integer.MAX_VALUE;
                        }
                    }
                } else {
                    if (value * negative < minQuatient) {
                        return Integer.MIN_VALUE;
                    } else if (value * negative == minQuatient) {
                        if ((words[index] - '0') >= -minRemainder) {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                value = value * 10 + (words[index] - '0');
                index ++;
            } else if (beginning && words[index] == '-') {
                negative = -1;
                beginning = false;
                index++;
            } else if (beginning && words[index] == '+') {
                negative = 1;
                beginning = false;
                index ++;
            } else {
                return value * negative;
            }
        }
        return value * negative;
    }

}
