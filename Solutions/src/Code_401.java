import java.util.ArrayList;
import java.util.List;

public class Code_401 {
    public List<String> readBinaryWatch(int num) {
        // 8,4,2,1;32,16,8,4,2,1
        List<String> result = new ArrayList<>();
        if (num == 0) {
            result.add("0:00");
            return result;
        }

        for (int h = 0; h < 12; h ++) {
            for (int m = 0; m < 60; m ++) {
                if (Integer.bitCount(h * 64 + m) == num) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return result;
    }
}
