public class Code_908 {
    public int smallestRangeI(int[] A, int K) {

        int max = A[0], min = A[0];
        for (int i = 0; i < A.length; i ++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }

        int diff = max - min;
        if (diff <= K * 2) {
            return 0;
        }
        return diff - K * 2;
    }
}
