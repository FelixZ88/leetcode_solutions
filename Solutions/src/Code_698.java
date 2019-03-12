import java.util.Arrays;

public class Code_698 {

    public static void main(String[] args) {
        Code_698 c = new Code_698();
        int[] nums = new int[]{10,10,10,7,7,7,7,7,7,6,6,6};
        boolean palindrome = c.canPartitionKSubsets(nums, 3);
        System.out.println(palindrome);
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
        }

        if (sum % k != 0) {
            return false;
        }

        int ave = sum / k;
        if (nums[nums.length - 1] > ave) {
            return false;
        }

        int s = -1, e = nums.length - 1;

        int ave_remain = ave;
        while (s < e && e >= 0) {
            if (s == -1) {
                if (nums[e] == ave_remain) {
                    k --;
                    e --;
                    ave_remain = ave;
                } else if (nums[e] > ave_remain){
                    return false;
                } else {
                    s ++;
                }
            } else {
                if (nums[e] + nums[s] == ave_remain) {
                    k --;
                    e --;
                    s ++;
                    ave_remain = ave;
                } else if (nums[e] + nums[s] > ave){
                    return false;
                } else {
                    ave_remain -= nums[s];
                    s ++;
                }
            }
        }

        if (k == 0) {
            return true;
        } else {
            return false;
        }
    }
}
