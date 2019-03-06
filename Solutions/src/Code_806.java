public class Code_806 {

    public static void main(String[] args) {
        Code_806 c = new Code_806();

        int[] nums = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        System.out.println(c.numberOfLines(nums, "abcdefghijklmnopqrstuvwxyz"));
    }

    public int[] numberOfLines(int[] widths, String S) {

        int lineNum = 0;
        int lineLeft = 100;
        for (int i = 0; i < S.length(); i ++) {
            if (lineLeft >= widths[S.charAt(i) - 'a']) {
                lineLeft -= widths[S.charAt(i) - 'a'];
            } else {
                lineNum ++;
                lineLeft = 100 - widths[S.charAt(i) - 'a'];
            }
        }

        return new int[]{lineNum + 1, 100 - lineLeft};
    }
}
