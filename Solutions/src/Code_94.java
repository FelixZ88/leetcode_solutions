import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Code_94 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Code_94 c = new Code_94();

        TreeNode n = new TreeNode(1);
        n.right = new TreeNode(3);
        n.right.left = new TreeNode(2);
        System.out.println(c.inorderTraversal(n));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            ret.add(node.val);
            node = node.right;
        }
        return ret;
    }

}
