import java.util.*;

public class Code_18 {

    public static void main(String[] args) {
        Code_18 c = new Code_18();
        int[] nums = {-1,-5,-5,-3,2,5,0,4};
        c.fourSum(nums, -7);//[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {//[[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        Arrays.sort(nums);

        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i ++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum0 = 4 * nums[i];
            if (sum0 > target) {
                break;
            }
            for (int j = i + 1; j < nums.length - 2; j ++) {
                if (nums[j] == nums[j-1] && j != i + 1) {
                    continue;
                }
                int sum1 = nums[i] + 3 * nums[j];
                if (sum1 > target) {
                    break;
                }
                for (int k = j + 1; k < nums.length - 1; k ++) {
                    if (nums[k] == nums[k-1] && k != j + 1) {
                        continue;
                    }
                    int sum2 = nums[i] + nums[j] + 2 * nums[k];
                    if (sum2 > target) {
                        break;
                    }
                    for (int m = k + 1; m < nums.length; m ++) {
                        if (nums[m] != nums[m-1] || m == k + 1) {
                            int sum = nums[i] + nums[j] + nums[k] + nums[m];
                            if (sum > target) {
                                break;
                            } else if (sum == target) {
                                List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[k], nums[m]);
                                ret.add(integers);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }
}
