import java.util.HashSet;

public class Code_961 {
    public int repeatedNTimes(int[] A) {
        HashSet set = new HashSet();
        for (int a : A) {
            if (set.contains(a)) {
                return a;
            } else {
                set.add(a);
            }
        }
        return 0;
    }
}
