public class Code_189 {
    public void rotate1(int[] nums, int k) {
        int[] new_nums = new int[nums.length];

        k = k % nums.length;
        System.arraycopy(nums, nums.length - k, new_nums, 0, k);
        System.arraycopy(nums, 0, new_nums, k, nums.length - k);
        System.arraycopy(new_nums, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        Code_189 c = new Code_189();
        int[] nums1 = {1,2,3,4,5,6,7};

        c.rotate3(nums1, 4);
    }

    // Failure
    public void rotate2(int[] nums, int k) {
        k %= nums.length;

        int loop = 0;
        int pointer = 0;
        while (loop < k) {
            pointer = loop;
            int val = nums[pointer];
            while (pointer < nums.length) {
                int next = (pointer + k) % nums.length;
                int tmp = nums[next];
                nums[next] = val;
                val = tmp;
                pointer += k;
            }
            loop ++;
        }
    }

    public void rotate3(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }


    public void reverse(int[] nums, int start, int end) {
        if (end < nums.length) {
            while (start < end) {
                int tmp = nums[end];
                nums[end] = nums[start];
                nums[start] = tmp;
                start ++;
                end --;
            }
        }
    }
}
