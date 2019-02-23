public class Code_53 {
    public int maxSubArray(int[] nums) {
        int largest = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);

            largest = Math.max(largest, nums[i]);
        }

        return largest;
    }
}
