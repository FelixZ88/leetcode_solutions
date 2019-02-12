import java.util.*;

public class Code_39 {
    public static void main(String[] args) {
        Code_39 c = new Code_39();

        int[] candidates = new int [] {2,3,4, 7};
        c.combinationSum(candidates, 7);
    }
    public List<List<Integer>> sumList = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List ret = new ArrayList();
        ArrayList factors = new ArrayList();
        for (int i = 0; i < candidates.length; i ++) {
            factors.add(0);
        }
        combine(candidates, factors, 0, target);
        for (List<Integer> sums : sumList) {
            ArrayList<Integer> sumIntegers = new ArrayList<>();
            for (int i = 0; i < sums.size(); i ++) {
                for (int j = 0; j < sums.get(i); j ++) {
                    sumIntegers.add(candidates[i]);
                }
            }
            ret.add(sumIntegers);
        }
        return ret;
    }

    public void combine(int[] candidates, ArrayList factors, int pointer, int target) {
        if (pointer != candidates.length - 1) {
            // jump current and to next
            combine(candidates, (ArrayList)factors.clone(), pointer + 1, target);
        }
        target -= candidates[pointer];
        ArrayList sumFactors = (ArrayList)factors.clone();
        sumFactors.set(pointer, (int)factors.get(pointer) + 1);
        if (target == 0) {
            sumList.add(sumFactors);
        } else if (target > 0) {
            combine(candidates, sumFactors, pointer, target);
            if (pointer != candidates.length - 1) {
                combine(candidates, sumFactors, pointer + 1, target);
            }
        }
    }
}
