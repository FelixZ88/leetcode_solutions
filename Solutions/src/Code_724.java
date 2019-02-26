public class Code_724 {

    public static void main(String[] args) {
        Code_724 c = new Code_724();
        int[] points = {1, 7, 3, 6, 5, 6};
        c.pivotIndex(points);
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (leftSum + leftSum + nums[i] == sum) {
                return i;
            }
            leftSum += nums[i];

        }
        return -1;
    }
}
