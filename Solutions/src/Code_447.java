import java.util.HashMap;
import java.util.Map;

public class Code_447 {
    public static void main(String[] args) {
        Code_447 c = new Code_447();
        int[][] points = {{0,0},{1,0},{2,0}};
        c.numberOfBoomerangs(points);
    }

    public int numberOfBoomerangs(int[][] points) {
        int length = points.length;
        int total = 0;
        int[][] distances = new int[length][length];

        for (int i = 0; i < length; i ++) {
            for (int j = i + 1; j < length; j ++) {
                int[] pointi = points[i];
                int[] pointj = points[j];
                distances[i][j] = (pointj[1] - pointi[1]) * (pointj[1] - pointi[1]) + (pointj[0] - pointi[0]) * (pointj[0] - pointi[0]);
                distances[j][i] = distances[i][j];
            }
        }

        for (int i = 0; i < length; i ++) {
            HashMap<Integer, Integer> dMap = new HashMap<>();
            for (int j = 0; j < length; j ++) {
                int d = distances[i][j];
                if (dMap.containsKey(d)) {
                    dMap.put(d, dMap.get(d) + 1);
                } else {
                    dMap.put(d, 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : dMap.entrySet()) {
                int count = entry.getValue();
                if (count >= 2) {
                    total += count * (count - 1);
                }
            }
        }
        return total;
    }
}
