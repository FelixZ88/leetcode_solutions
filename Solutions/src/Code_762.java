import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code_762 {


    public static void main(String[] args) {
        Code_762 c = new Code_762();
        c.countPrimeSetBits(842, 888);
    }

    public int countPrimeSetBits(int L, int R) {
        HashMap<Integer, Boolean> prime = new HashMap<>();

        int ret = 0;
        for (int i = L; i < R + 1; i ++) {
            int countOf1 = countOf1(i);
            if (!prime.containsKey(countOf1)) {
                prime.put(countOf1, isPrime(countOf1));
            }

            if (prime.get(countOf1)) {
                ret ++;
            }
        }
        return ret;
    }

    public int countOf1(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                count ++;
            }

            n = n >> 1;
        }
        return count;
    }

    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        } else {
            int top = (int)Math.sqrt(n);
            for (int i = 2; i <= top ; i ++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
