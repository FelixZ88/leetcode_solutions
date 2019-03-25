import java.util.HashSet;

public class Code_128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);

        for (int num : nums) {
            set.add(num);
        }

        int longest = Integer.MIN_VALUE;
        for (Integer num : set) {
            int consecutive = 1;
            int next = num + 1;
            while (set.contains(next)) {
                consecutive ++;
                next += 1;
            }

            longest = Math.max(longest, consecutive);
        }
        return longest;
    }
}
