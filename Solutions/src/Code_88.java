public class Code_88 {

    public static void main(String[] args) {
        Code_88 c = new Code_88();
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,7};
        c.merge(nums1, 3, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 || nums2.length == 0) {
            return ;
        }

        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[i + j + 1] = nums1[i];
                i --;
            } else {
                nums1[i + j + 1] = nums2[j];
                j --;
            }
        }

        if (i < 0 && j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }
}
