public class Code_832 {
    public static void main(String[] args) {
        Code_832 c = new Code_832();
        int[][] A = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        int[][] B = c.flipAndInvertImage(A);
        System.out.println();
    }
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] ret = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i ++) {
            int[] row = A[i];
            for (int j = row.length - 1; j >= 0; j --) {
                ret[i][row.length - j - 1] = A[i][j] == 0 ? 1 : 0;
            }
        }
        return ret;
    }
}
