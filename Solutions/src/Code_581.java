import java.util.Arrays;

public class Code_581 {

    public static void main(String[] args) {
        Code_581 s = new Code_581();

        int[] nums = {2,5,4,3,1,3,4};
        s.findUnsortedSubarray2(nums);
    }

    public int findUnsortedSubarray2(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n-1-i]);
            if (A[i] < max) end = i;
            if (A[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }

    public int findUnsortedSubarray(int[] A) {
        int[] new_A = new int[A.length];
        System.arraycopy(A, 0, new_A, 0, A.length);
        Arrays.sort(new_A);

        int left  = 0, right = A.length - 1;

        while (left < A.length) {
            if (A[left] == new_A[left]) {
                left ++;
            } else {
                break;
            }
        }

        while (right >= left) {
            if (A[right] == new_A[right]) {
                right --;
            } else {
                break;
            }
        }

        return right - left + 1;
    }
}
