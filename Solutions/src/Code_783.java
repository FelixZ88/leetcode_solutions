public class Code_783 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDiffInBST(TreeNode root) {
        travasal(root);
        return min;
    }

    int min = Integer.MAX_VALUE;
    TreeNode prev;

    public void travasal(TreeNode node) {
        if (node != null) {
            travasal(node.left);

            if (prev != null) {
                min = Math.min(min, node.val - prev.val);
            }

            prev = node;

            travasal(node.right);
        }
    }
}
