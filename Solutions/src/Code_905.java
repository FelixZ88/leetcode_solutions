public class Code_905 {
    public int[] sortArrayByParity(int[] A) {
        return sortArray(A, 0, A.length - 1);
    }

    public int[] sortArray(int[] A, int head, int tail) {
        if (head >= tail) {
            return A;
        }

        if (A[head] % 2 == 0 && A[tail] % 2 == 1) {
            head ++;
            tail --;
        } else if (A[head] % 2 == 0 && A[tail] % 2 == 0) {
            head ++;
        } else if (A[head] % 2 == 1 && A[tail] % 2 == 1) {
            tail --;
        } else {
            int tmp = A[head];
            A[head] = A[tail];
            A[tail] = tmp;
            head ++;
            tail --;
        }
        return sortArray(A, head, tail);
    }
}
