import org.omg.CORBA.NO_IMPLEMENT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code_429 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {
        Code_429 c = new Code_429();
        Node n5 = new Node(5, null);
        Node n0 = new Node(0, null);

        List<Node> l10 = new ArrayList<>();
        l10.add(n5);
        l10.add(n0);
        Node n10 = new Node(10, l10);

        Node n6 = new Node(6, null);
        List<Node> l3 = new ArrayList<>();
        l3.add(n6);

        Node n3 = new Node(3, l3);

        List<Node> l1 = new ArrayList<>();
        l1.add(n10);
        l1.add(n3);

        Node n1 = new Node(1, l1);

        c.levelOrder(n1);
    }


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> values = new ArrayList<>();
        if (root == null) {
            return values;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level_values = new ArrayList<>();
            values.add(level_values);

            int level_count = queue.size();
            for (int i = 0; i < level_count; i ++) {
                Node n = queue.poll();
                level_values.add(n.val);
                if (n.children != null ) {
                    queue.addAll(n.children);
                }
            }
        }
        return values;
    }
}
