import java.util.HashMap;
import java.util.Map;

public class Code_447 {
    public static void main(String[] args) {
        Code_447 c = new Code_447();
        int[][] points = {{0,0},{1,0},{2,0}};
        c.numberOfBoomerangs(points);
    }

    public int numberOfBoomerangs(int[][] points) {
        int total = 0;
        HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();
        for (int i = 0; i < points.length; i ++) {
            for (int j = i + 1; j < points.length; j ++) {
                int[] pointi = points[i];
                int[] pointj = points[j];
                int distance = (pointj[1] - pointi[1]) * (pointj[1] - pointi[1]) + (pointj[0] - pointi[0]) * (pointj[0] - pointi[0]);
                if (distances.containsKey(distance)) {
                    distances.put(distance, distances.get(distance) + 1);
                } else {
                    distances.put(distance, 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            total += entry.getValue() * (entry.getValue() - 1);
        }
        return total;
    }
}
