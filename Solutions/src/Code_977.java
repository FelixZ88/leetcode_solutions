public class Code_977 {
    public static void main(String[] args) {
        Code_977 c = new Code_977();
    }

    public int[] sortedSquares(int[] A) {
        if (A.length == 0) {
            return A;
        }
        if (A.length == 1) {
            return new int[] {A[0] * A[0]};
        }

        int[] squares = new int[A.length];

        int index = A.length - 1;
        int front = 0;
        int tail = A.length - 1;

        while (true) {
            if (Math.abs(A[front]) < Math.abs(A[tail])) {
                squares[index --] = A[tail] * A[tail];
                tail --;
            } else {
                squares[index --] = A[front] * A[front];
                front ++;
            }

            if (index == 0) {
                squares[0] = A[front] * A[front];
                break;
            }
        }
        return squares;
    }
}
