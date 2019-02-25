public class Code_942 {

    public static void main(String[] args) {
        Code_942 s = new Code_942();

        s.diStringMatch("I");
    }

    public int[] diStringMatch(String S) {
        int[] result = new int[S.length() + 1];
        int l = 0, r = S.length();
        for (int i = 0; i < S.length(); i ++) {
            if (S.charAt(i) == 'I') {
                result[i] = l;
                l ++;
            } else {
                result[i] = r;
                r --;
            }
        }

        result[S.length()] = l;
        return result;
    }
}
