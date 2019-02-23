import java.util.Arrays;

public class Code_16 {

    public static void main(String[] args) {
        Code_16 c = new Code_16();
        int [] nums = {-1,0,1,2,-1,-4};
        c.threeSumClosest(nums, 1);
//        System.out.println(palindrome);
    }

    int closest = 0;
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);

        boolean beginning = true;
        int s = 0, e = nums.length - 1, m = (s + e) / 2;
        closest = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i ++) {
            int next = i + 1;
            int last = nums.length - 1;
            while (next < last) {
                int sum = nums[i] + nums[next] + nums[last];
                if (sum > target) {
                    last --;
                } else if (sum < target) {
                    next ++;
                } else {
                    return target;
                }
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
            }
        }
        return closest;
    }
}
