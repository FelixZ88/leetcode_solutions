public class Code_33 {

    public static void main(String[] args) {
        Code_33 c = new Code_33();
        int[] nums = {5,0,1,2,3};
        System.out.println(c.search(nums, 5));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid] && nums[mid] < target) {
                left = mid + 1;
            } else if (nums[left] <= nums[mid] && nums[left] > target) {
                left = mid + 1;
            } else if (nums[left] <= nums[mid] && nums[left] <= target && target < nums[mid]) {
                right = mid;
            } else if (nums[mid] > target) { // nums[left] > nums[mid]
                right = mid;
            } else if (nums[mid] < target && nums[left] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left < nums.length && nums[left] == target) {
            return left;
        }

        return -1;
    }
}
