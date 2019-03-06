public class Code_110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode node) {
        if (node != null) {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
        return 0;
    }
}
