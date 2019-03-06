public class Code_35 {

    public int searchInsert(int[] nums, int target) {
        int s = 0, e = nums.length - 1, cur = (s + e) / 2;

        while (s < e) {
            if (nums[cur] == target) {
                return cur;
            } else if (nums[cur] > target){
                e = Math.max(s, cur - 1);
                cur = (s + e) / 2;
            } else {
                s = cur + 1;
                cur = (s + e) / 2;
            }
        }

        if (nums[e] > target) {
            return e;
        } else {
            return e + 1;
        }
    }
}
