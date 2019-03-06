public class Code_98 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        return travasal(root);
    }

    public boolean travasal(TreeNode node) {
        if (node != null) {
            boolean res = travasal(node.left);

            if (!res) {
                return false;
            }
            if (prev != null) {
                if (prev.val >= node.val) {
                    return false;
                }
            }

            prev = node;

            res = travasal(node.right);
            if (!res) {
                return false;
            }
        }
        return true;
    }
}
