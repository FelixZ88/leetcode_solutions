import java.util.ArrayList;
import java.util.List;

public class Code_590 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    List<Integer> values = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        dfs(root);
        return values;
    }

    public void dfs(Node node) {

        if (node != null) {
            if (node.children != null) {
                for (Node tmp : node.children) {
                    dfs(tmp);
                }
            }
            values.add(node.val);
        }
    }
}
