public class Code_9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int half = 0;
        while (x > half) {
            int remainder = x % 10;
            half = half * 10 + remainder;
            if (x == half) {
                return true;
            }
            x /= 10;
        }
        if (x == half) {
            return true;
        }
        return false;
    }
}
