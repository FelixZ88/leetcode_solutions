public class Code_198 {
    public static void main(String[] args) {
        Code_198 c = new Code_198();

        int[] nums = {2,7,9,3,1};
        System.out.println(c.rob(nums));
    }
    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i ++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }
        return Math.max(nums[nums.length - 2], nums[nums.length - 1]);
    }
}
