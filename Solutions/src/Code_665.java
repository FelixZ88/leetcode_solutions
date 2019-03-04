public class Code_665 {

    public static void main(String[] args) {
        Code_665 s = new Code_665();

        int[] nums = {2,3,3,2,4};
        s.checkPossibility(nums);
    }

    public boolean checkPossibility(int[] nums) {
        int descend = 0;
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] > nums[i + 1]) {
                descend ++;

                nums[i] = nums[i + 1];

                if (i != 0 && nums[i - 1] > nums[i + 1]) {
                    return false;
                }
            }
        }

        return descend <= 1;
    }
}
