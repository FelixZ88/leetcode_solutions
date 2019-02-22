import java.util.ArrayList;
import java.util.Iterator;

public class Code_378 {

    static class XY {
        int x, y;
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Code_378 c = new Code_378();
        int[][] nums1 = {{1,3,5},{6,7,12},{11,14,14}};

        c.kthSmallest(nums1, 6);
    }

    public int kthSmallest(int[][] matrix, int k) {
        int result = matrix[0][0];
        int count = 0;
        ArrayList<XY> candidates = new ArrayList<>();
        candidates.add(new XY(0, 0));
        while (count < k && candidates.size() > 0) {

            XY minNode = candidates.get(0);
            int min = matrix[minNode.x][minNode.y];
            Iterator<XY> it = candidates.iterator();
            while (it.hasNext()) {
                XY node = it.next();
                if (min > matrix[node.x][node.y]) {
                    minNode = node;
                    min = matrix[node.x][node.y];
                }
            }

            count ++;
            candidates.remove(minNode);
            result = matrix[minNode.x][minNode.y];

            boolean hasSameCol = false;
            boolean hasSameRow = false;

            for (XY xy : candidates) {
                if (xy.x == minNode.x + 1) {
                    hasSameCol = true;
                }
                if (xy.y == minNode.y + 1) {
                    hasSameRow = true;
                }
            }

            if (!hasSameCol && minNode.x < matrix.length - 1) {
                candidates.add(new XY(minNode.x + 1, minNode.y));
            }
            if (!hasSameRow && minNode.y < matrix[0].length - 1) {
                candidates.add(new XY(minNode.x, minNode.y + 1));
            }
        }

        return result;
    }
}
