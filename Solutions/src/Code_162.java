public class Code_162 {


    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int last = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] > last && nums[i] > nums[i + 1]) {
                return i;
            }
            last = nums[i];
        }

        if (nums[nums.length - 1] > last) {
            return nums.length - 1;
        }
        return -1;
    }
}
