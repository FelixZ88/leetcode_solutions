public class Code_26 {

    public static void main(String[] args) {
        Code_26 c = new Code_26();
        int[] nums = new int[]{1, 1, 1, 3, 3, 5};
        int palindrome = c.removeDuplicates(nums);
        System.out.println(palindrome);
    }

    public int removeDuplicates(int[] nums) {
        int preVal = nums[0];
        int next = 1;
        int length = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (preVal == nums[i]) {
//                next = i;
            } else if (next != i) {
                nums[next] = nums[i];
                next ++;
                preVal = nums[i];
                length ++;
            } else {
                preVal = nums[i];
                next ++;
                length ++;
            }
        }
        return length;
    }
}
