public class Code_701 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        insert(root, val);
        return root;
    }

    public void insert(TreeNode root, int val) {
        if (root.val > val) {
            if (root.left != null) {
                insert(root.left, val);
            } else {
                TreeNode node = new TreeNode(val);
                root.left = node;
            }
        } else {
            if (root.right != null) {
                insert(root.right, val);
            } else {
                TreeNode node = new TreeNode(val);
                root.right = node;
            }
        }
    }
}
