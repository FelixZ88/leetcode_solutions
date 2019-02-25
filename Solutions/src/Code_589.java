import java.util.ArrayList;
import java.util.List;

public class Code_589 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    List<Integer> values = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root != null) {
            helper(root);
        }
        return values;
    }

    public void helper(Node root) {

        values.add(root.val);

        for (Node node : root.children) {
            preorder(node);
        }
    }
}
