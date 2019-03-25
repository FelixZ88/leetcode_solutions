import java.util.HashMap;
import java.util.Map;

public class Code_594 {

    public static void main(String[] args) {
        Code_594 c = new Code_594();
        int[] nums = new int[]{1,3,2,2,5,2,3,7};
        c.findLHS(nums);
    }
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int longest = 0;
        for (Map.Entry<Integer, Integer> count : counts.entrySet()) {
            int num = count.getKey();
            int small = counts.getOrDefault(num - 1, 0);
            if (small != 0) {
                longest = Math.max(longest, small + count.getValue());
            }
            int big = counts.getOrDefault(num + 1, 0);
            if (big != 0) {
                longest = Math.max(longest, big + count.getValue());
            }
        }
        return longest;
    }
}
