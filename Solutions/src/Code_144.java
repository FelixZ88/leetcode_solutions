import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code_144 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Code_144 c = new Code_144();

        TreeNode n = new TreeNode(1);
        n.right = new TreeNode(3);
        n.right.left = new TreeNode(2);
        System.out.println(c.preorderTraversal(n));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            while (node != null) {
                ret.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
            } else {
                node = null;
            }
        }
        return ret;
    }
}
