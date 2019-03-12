public class Code_27 {

    public static void main(String[] args) {
        Code_27 c = new Code_27();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int palindrome = c.removeElement(nums, 2);
        System.out.println(palindrome);
    }


    public int removeElement(int[] nums, int val) {

        int next = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                if (next != i) {
                    nums[next] = nums[i];
                }
                next ++;
            }
        }
        return next;
    }
}
