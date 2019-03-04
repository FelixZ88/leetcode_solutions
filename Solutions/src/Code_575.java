import java.util.HashSet;

public class Code_575 {
    public int distributeCandies(int[] candies) {
        int sisterCount = 0, brotherCount = 0;
        HashSet<Integer> sisterSet = new HashSet<>();
        HashSet<Integer> brotherSet = new HashSet<>();

        for (int i = 0; i < candies.length; i ++) {
            int candy = candies[i];
            if (sisterCount < candies.length/2 && brotherCount < candies.length/2) {
                if (!sisterSet.contains(candy)) {
                    sisterSet.add(candy);
                    sisterCount ++;
                } else {
                    brotherSet.add(candy);
                    brotherCount ++;
                }
            } else if (brotherCount == candies.length/2) {
                sisterSet.add(candy);
            } else if (sisterCount == candies.length/2) {
                return sisterCount;
            }
        }

        return sisterSet.size();
    }
}
