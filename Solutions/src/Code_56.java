import java.util.*;

public class Code_56 {

    static class Interval {
        int start;
        int end;
        public Interval() {start = 0; end = 0;}
        public Interval(int s, int e) {start = s; end = e;}
        public String toString() {
            return "s:" + start + " e:" + end;
        }
    }

    public static void main(String[] args) {
        Code_56 c = new Code_56();
        List<Interval> intervals = new LinkedList<Interval>();
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));
        intervals.add(new Interval(1, 10));
        List list = c.merge(intervals);
        System.out.println();
    }


    public List<Interval> merge(List<Interval> intervals) {
        int count = intervals.size();
        if (count == 0) {
            return intervals;
        }
        if (count == 1) {
            return intervals;
        }
        int median = intervals.size() / 2;

        List<Interval> left = merge(new ArrayList<Interval>(intervals.subList(0, median)));
        List<Interval> right = merge(new ArrayList<Interval>(intervals.subList(median, intervals.size())));

        while(right.size() > 0) {
            boolean merged = false;
            Interval l = left.get(left.size() - 1);
            Interval r = right.get(0);
            if (l.start <= r.start && l.end >= r.end) {
                merged = true;
            } else if (l.start >= r.start && l.start <= r.end) {
                merged = true;
            } else if (l.start <= r.start && l.end >= r.start) {
                merged = true;
            } else if (l.start >= r.start && l.end <= r.end) {
                merged = true;
            }

            if (merged) {
                l.start = Math.min(l.start, r.start);
                l.end = Math.max(l.end, r.end);
                right.remove(0);
            } else {
                break;
            }
        }
        if (right.size() > 0) {
            left.addAll(right);
        }
        return left;
    }
}
