import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Code_57 {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        Interval i0 = new Interval(1,2);
        Interval i1 = new Interval(3,4);

        Interval in = new Interval(-1,5);
        Code_57 c = new Code_57();
        c.insert(Arrays.asList(i0, i1), in);
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Interval tmpIn = new Interval(newInterval.start, newInterval.end);
        List<Interval> ret = new LinkedList<>();
        for (int i = 0; i < intervals.size(); i ++) {
            Interval in = intervals.get(i);

            if (in.start < tmpIn.start) {
                if (in.end < tmpIn.start) {
                    ret.add(in);
                } else {
                    tmpIn.start = in.start;
                    tmpIn.end = Math.max(tmpIn.end, in.end);
                }
            } else if (in.start == tmpIn.start) {
                tmpIn.end = Math.max(tmpIn.end, in.end);
            } else {
                if (in.start > tmpIn.end) {
                    ret.add(tmpIn);
                    tmpIn = in;
                } else {
                    tmpIn.end = Math.max(tmpIn.end, in.end);
                }
            }
        }

        ret.add(tmpIn);

        return ret;
    }
}
