import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Code_373 {

    static class Pair {
        int p1;
        int p2;

        public Pair(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public String toString() {
            return "(" + p1 + "," + p2 + ")";
        }
    }

    public static void main(String[] args) {
        Code_373 c = new Code_373();
        int[] nums1 = {1,2};
        int[] nums2 = {3};

        c.kSmallestPairs(nums1, nums2, 3);
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if (nums1.length != 0 && nums2.length != 0) {

//            if (nums1[0] > nums2[0]) {
//                int[] tmp = nums1;
//                nums1 = nums2;
//                nums2 = tmp;
//            }

            ArrayList<Pair> candidates = new ArrayList<>();
            candidates.add(new Pair(0, 0));

            int count = 0;
            while (count < k && candidates.size() > 0) {
                Iterator<Pair> it = candidates.iterator();
                Pair min_pair = candidates.get(0);
                int min = nums1[min_pair.p1] + nums2[min_pair.p2];
                while (it.hasNext()) {
                    Pair pair = it.next();
                    int sum = nums1[pair.p1] + nums2[pair.p2];
                    if (sum < min) {
                        min = sum;
                        min_pair = pair;
                    }
                }

                candidates.remove(min_pair);
                result.add(new int[]{nums1[min_pair.p1], nums2[min_pair.p2]});
                count ++;

                boolean hasRight = false, hasBottom = false;
                for (Pair p : candidates) {
                    if (p.p1 == min_pair.p1 + 1) {
                        hasRight = true;
                    }
                    if (p.p2 == min_pair.p2 + 1) {
                        hasBottom = true;
                    }
                }

                Pair right = new Pair(min_pair.p1 + 1, min_pair.p2);
                Pair bottom = new Pair(min_pair.p1, min_pair.p2 + 1);
                if (!hasRight && min_pair.p1 < nums1.length - 1) {
                    candidates.add(right);
                }
                if (!hasBottom && min_pair.p2 < nums2.length - 1) {
                    candidates.add(bottom);
                }
            }

        }

        return result;
    }
}
