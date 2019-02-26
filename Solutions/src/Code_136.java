import java.util.HashMap;

public class Code_136 {
    public int singleNumber(int[] nums) {

        int result = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            result ^= nums[i];
        }
        return result;
    }


    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> numbers = new HashMap<>();

        for (int num : nums) {
            if (!numbers.containsKey(num)) {
                numbers.put(num, 1);
            } else {
                numbers.remove(num);
            }
        }

        return numbers.entrySet().iterator().next().getKey();
    }

}
