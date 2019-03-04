public class Code_204 {

    public static void main(String[] args) {
        Code_204 c = new Code_204();
        c.countPrimes(2);

    }
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        for (int i = 1; i < n; i ++) {
            isPrime[i] = true;
        }

        for (int i = 1; i < n; i ++) {
            if (isPrime[i]) {
                for (int j = i + i + 1; j < n; j += (i + 1)) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 1; i < n - 1; i ++) {
            if (isPrime[i]) {
                count ++;
            }
        }
        return count;
    }


}
