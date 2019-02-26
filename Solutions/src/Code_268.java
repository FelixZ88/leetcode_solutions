public class Code_268 {
    public int missingNumber(int[] nums) {
        boolean[] exists = new boolean[nums.length + 1];

        for (int num : nums) {
            exists[num] = true;
        }

        for (int i = 0; i < exists.length; i ++) {
            if (exists[i] == false) {
                return i;
            }
        }
        return 0;
    }
}
