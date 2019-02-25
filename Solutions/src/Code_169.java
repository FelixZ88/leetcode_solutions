import java.util.HashMap;

public class Code_169 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                count.put(nums[i], 1);
            }

            if (count.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {

        int major = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i ++) {
            if (count == 0) {
                major = nums[i];
                count ++;
            } else if (major == nums[i]) {
                count ++;
            } else {
                count --;
            }
        }
        return major;
    }
}
