import java.util.HashSet;

public class Code_202 {

    public static void main(String[] args) {
        Code_202 c = new Code_202();
        int[] nums1 = {1,2,3,4,5,6,7};

        c.isHappy(200);
    }

    public boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        }

        HashSet<Integer> exists = new HashSet<>();
        exists.add(n);
        int sum = n;
        while (sum != 1) {

            int tmp = 0;
            while (sum != 0) {
                int d0 = sum % 10;
                tmp += d0 * d0;
                sum = sum / 10;
            }

            if (exists.contains(tmp)) {
                return false;
            }
            exists.add(tmp);
            sum = tmp;
        }
        return true;
    }
}
