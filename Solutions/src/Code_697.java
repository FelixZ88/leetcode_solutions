import java.util.HashMap;
import java.util.Map;

public class Code_697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int maxCount = 0;
        int shortest = nums.length;
        for (int i = 0; i < nums.length; i ++) {
            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
                countMap.put(nums[i], 1);
            } else {
                countMap.put(nums[i], countMap.get(nums[i]) + 1);
            }
            last.put(nums[i], i);

            if (maxCount < countMap.get(nums[i])) {
                maxCount = countMap.get(nums[i]);
                shortest = i - first.get(nums[i]) + 1;
            } else if (maxCount == countMap.get(nums[i])) {
                shortest = Math.min(shortest, i - first.get(nums[i]) + 1);
            }
        }

        return shortest;
    }
}
