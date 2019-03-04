public class Code_463 {
    public int islandPerimeter(int[][] grid) {

        int count = 0;

        int neighbor = 0;
        for (int i = 0; i < grid.length; i ++) {
            Integer prev = null;
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == 1) {
                    count ++;
                }

                if (prev != null) {
                    if (prev == grid[i][j] && grid[i][j] == 1) {
                        neighbor ++;
                    }
                }
                prev = grid[i][j];
            }
        }

        for (int i = 0; i < grid[0].length; i ++) {
            Integer prev = null;
            for (int j = 0; j < grid.length; j ++) {
                if (prev != null) {
                    if (prev == grid[j][i] && grid[j][i] == 1) {
                        neighbor ++;
                    }
                }
                prev = grid[j][i];
            }
        }

        return count * 4 - neighbor * 2;
    }
}
