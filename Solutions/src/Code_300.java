import java.util.HashSet;

public class Code_300 {

    public static void main(String[] args) {
        Code_300 c = new Code_300();
        int[] nums = {10,9,2,4,5,3,7,101,18};
        c.lengthOfLIS(nums);
    }
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] longest = new int[nums.length];

        longest[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            longest[i] = 1;
            int tempLongest = 0;
            for (int j = i - 1; j >= 0; j --) {
                if (nums[i] > nums[j]) {
                    tempLongest = Math.max(tempLongest, longest[j]);
                }
            }
            longest[i] = tempLongest + 1;
        }

        int ret = longest[0];
        for (int i = 1; i < longest.length; i ++) {
            ret = Math.max(ret, longest[i]);
        }
        return ret;
    }
}
