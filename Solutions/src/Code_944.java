public class Code_944 {

    public static void main(String[] args) {
        Code_944 s = new Code_944();

        String[] A = {"zyx","wvu","tsr"};
        s.minDeletionSize(A);
    }

    public int minDeletionSize(String[] A) {

        int deletion = 0;
        for (int i = 0; i < A[0].length(); i ++) {
            char c = A[0].charAt(i);
            for (int j = 1; j < A.length; j ++) {
                if (A[j].charAt(i) < c) {
                    deletion ++;
                    break;
                }
                c = A[j].charAt(i);
            }
        }
        return deletion;
    }
}
