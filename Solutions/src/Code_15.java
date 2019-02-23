import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Code_15 {

    public static void main(String[] args) {
        Code_15 c = new Code_15();
        int [] nums = {-1,0,1,2,-1,-4};
        c.threeSum(nums);
//        System.out.println(palindrome);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        ArrayList list = new ArrayList();
        if (nums.length <= 2) {
            return list;
        }
        Arrays.sort(nums);

        int lastI = nums[0];
        for (int i = 0; i < nums.length - 2; i ++) {

            if (i != 0 && lastI == nums[i]) {
                continue;
            }
            lastI = nums[i];

            int lastJ = nums[i + 1];

            HashMap map = new HashMap();
            for (int j = i + 1; j < nums.length - 1; j ++) {

                if (j != i + 1) {
                    int count = (int) map.get(nums[j]);
                    if (count == 1) {
                        map.remove(nums[j]);
                    } else {
                        map.put(nums[j], (int) map.get(nums[j]) - 1);
                    }

                    if (lastJ == nums[j]) {
                        continue;
                    }
                }

                lastJ = nums[j];

                if (j == i + 1) {
                    map = new HashMap();
                    for (int k = j + 1; k < nums.length; k ++) {
                        if (map.containsKey(nums[k])) {
                            map.put(nums[k], (int)map.get(nums[k]) + 1);
                        } else {
                            map.put(nums[k], 1);
                        }
                    }
                } else {

                }


                int target = 0 - (nums[i] + nums[j]);
                if (map.containsKey(target)) {
                    ArrayList sum = new ArrayList();
                    sum.add(nums[i]);
                    sum.add(nums[j]);
                    sum.add(target);
                    list.add(sum);
                }

            }
        }
        return list;
    }
}
